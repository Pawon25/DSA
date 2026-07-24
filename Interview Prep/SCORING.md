# Scoring Logic

Transparent formula so the numbers `score.py` prints always trace back to something you understand.

## Problems (`daily-log.csv`)

Points depend on `difficulty` and `result`:

| result | Easy | Medium | Hard |
|---|---|---|---|
| `unaided` (solved cleanly, in budget) | 5 | 10 | 15 |
| `partial` (solved but over time or needed a nudge) | 2.5 | 5 | 7.5 |
| `hint` (needed the pattern name or a real hint) | 1 | 2 | 3 |
| `failed` (couldn't finish) | 0 | 0 | 0 |

**Comeback bonus:** +3 if this row's `mistake_tag` matches an earlier row that was `hint` or `failed`, and this time `result` is `unaided`. Rewards the spaced-repetition win, not just first-attempt luck.

## Theory (`theory-log.csv`)

| recall_quality | Points |
|---|---|
| `clean` (explained in <90s, no stumbling) | 3 |
| `shaky` (got there but hesitated/backtracked) | 1 |
| `blank` (couldn't produce it) | 0 |

## Mocks (`mocks-log.csv`)

- Flat 15 points for completing one.
- `+ communication_rating * 2` (self-rated 1-5 on how clearly you talked through it) — up to 10 more.
- Max 25/mock.

## Streak bonus

+2 for each calendar day that has **at least one** `daily-log.csv` row **and** one `theory-log.csv` row. Rewards showing up on both fronts daily, not just grinding problems.

## Reading the weekly number

Rough benchmark for "on pace" (5 active days/week):
- 5 problems (mostly medium, unaided) ≈ 50
- 5 theory drills ≈ 15
- streak bonus ≈ 10
- 1 mock ≈ 20
- **≈ 95-100 pts/week** is a solid, sustainable pace. Treat it as a sanity check, not a quota to game — a `hint`-heavy week that surfaces real gaps is worth more than a `partial`-padded one that doesn't.

Run `python score.py` any time for the live total, this-week total, current streak, and which weeks in the roadmap still have zero logged patterns.
