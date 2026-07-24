#!/usr/bin/env python3
"""Score reader for the interview-prep trackers. See SCORING.md for the formula.
Usage: python score.py
"""
import csv
import datetime
from pathlib import Path

DIR = Path(__file__).parent

PROBLEM_POINTS = {
    ("unaided", "Easy"): 5, ("unaided", "Medium"): 10, ("unaided", "Hard"): 15,
    ("partial", "Easy"): 2.5, ("partial", "Medium"): 5, ("partial", "Hard"): 7.5,
    ("hint", "Easy"): 1, ("hint", "Medium"): 2, ("hint", "Hard"): 3,
    ("failed", "Easy"): 0, ("failed", "Medium"): 0, ("failed", "Hard"): 0,
}
THEORY_POINTS = {"clean": 3, "shaky": 1, "blank": 0}
COMEBACK_BONUS = 3
STREAK_BONUS = 2


def read_rows(name):
    path = DIR / name
    with open(path, newline="", encoding="utf-8") as f:
        return list(csv.DictReader(f))


def parse_date(s):
    return datetime.date.fromisoformat(s.strip())


def score_daily(rows):
    total = 0.0
    seen_mistake_outcomes = {}  # mistake_tag -> list of (date, result) seen so far, in order
    rows_sorted = sorted(rows, key=lambda r: r["date"])
    for r in rows_sorted:
        diff, result = r["difficulty"].strip(), r["result"].strip()
        pts = PROBLEM_POINTS.get((result, diff), 0)
        tag = r.get("mistake_tag", "").strip()
        if tag and result == "unaided":
            prior = seen_mistake_outcomes.get(tag, [])
            if any(pr in ("hint", "failed") for pr in prior):
                pts += COMEBACK_BONUS
        if tag:
            seen_mistake_outcomes.setdefault(tag, []).append(result)
        total += pts
    return total


def score_theory(rows):
    return sum(THEORY_POINTS.get(r["recall_quality"].strip(), 0) for r in rows)


def score_mocks(rows):
    total = 0.0
    for r in rows:
        rating = float(r["communication_rating"]) if r["communication_rating"].strip() else 0
        total += 15 + min(rating, 5) * 2
    return total


def active_days(daily_rows, theory_rows):
    daily_dates = {r["date"].strip() for r in daily_rows if r["date"].strip()}
    theory_dates = {r["date"].strip() for r in theory_rows if r["date"].strip()}
    return daily_dates & theory_dates


def current_streak(active):
    if not active:
        return 0, None
    dates = sorted((parse_date(d) for d in active), reverse=True)
    most_recent = dates[0]
    today = datetime.date.today()
    if (today - most_recent).days > 1:
        return 0, most_recent
    streak = 1
    for i in range(1, len(dates)):
        if (dates[i - 1] - dates[i]).days == 1:
            streak += 1
        else:
            break
    return streak, most_recent


def week_bounds(d):
    start = d - datetime.timedelta(days=d.weekday())  # Monday
    end = start + datetime.timedelta(days=6)
    return start, end


def filter_this_week(rows, start, end):
    out = []
    for r in rows:
        if not r["date"].strip():
            continue
        d = parse_date(r["date"])
        if start <= d <= end:
            out.append(r)
    return out


def main():
    daily = read_rows("daily-log.csv")
    theory = read_rows("theory-log.csv")
    mocks = read_rows("mocks-log.csv")

    today = datetime.date.today()
    week_start, week_end = week_bounds(today)

    total_score = score_daily(daily) + score_theory(theory) + score_mocks(mocks)

    week_daily = filter_this_week(daily, week_start, week_end)
    week_theory = filter_this_week(theory, week_start, week_end)
    week_mocks = filter_this_week(mocks, week_start, week_end)
    week_score = score_daily(week_daily) + score_theory(week_theory) + score_mocks(week_mocks)

    active = active_days(daily, theory)
    streak, last_active = current_streak(active)
    week_score += streak * STREAK_BONUS

    patterns = sorted({r["pattern"].strip() for r in daily if r["pattern"].strip()})

    print(f"=== Interview Prep Score - {today.isoformat()} ===")
    print(f"Total score (all time):   {total_score:.1f}")
    print(f"This week ({week_start} to {week_end}): {week_score:.1f}")
    print(f"Current streak: {streak} day(s)" + ("" if streak else f" (last active: {last_active})"))
    print(f"Problems logged: {len(daily)} | Theory drills: {len(theory)} | Mocks: {len(mocks)}")
    if patterns:
        print(f"Patterns touched so far ({len(patterns)}): {', '.join(patterns)}")
    else:
        print("No patterns logged yet - add rows to daily-log.csv to get started.")


if __name__ == "__main__":
    main()
