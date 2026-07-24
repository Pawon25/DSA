# Interview Prep — 3 Month Roadmap

Start date: 2026-07-24 · Target: 12 weeks of daily practice before/while applying vigorously.

## How the system fits together

| File | Purpose |
|---|---|
| `daily-log.csv` | One row per DSA problem you attempt. |
| `theory-log.csv` | One row per CS-fundamentals flashcard drilled out loud. |
| `mocks-log.csv` | One row per weekly mock interview. |
| `mistakes-journal.md` | Living log of specific mistakes, reviewed on a spaced schedule. |
| `SCORING.md` | Explains exactly how points are calculated (formula, not magic). |
| `score.py` | Run it any time: `python score.py` → prints today/week/total score, streak, pattern coverage gaps. |

**Daily routine (fill in as you go, ~60-90 min):**
1. Warm-up: re-solve yesterday's problem from memory (not logged, just a mental rep).
2. Solve today's problem from the week's theme below → add a row to `daily-log.csv`.
3. Drill one theory flashcard out loud → add a row to `theory-log.csv`.
4. If something went wrong, add/update an entry in `mistakes-journal.md`.
5. Sunday: one mock interview → add a row to `mocks-log.csv`.

Run `python score.py` at the end of each day to see your score and streak update.

## 12-Week Pattern Roadmap

- [ ] **Week 1 (Jul 28–Aug 3):** Unbounded knapsack family — Climbing Stairs, Coin Change (min coins), Coin Change 2 (combinations), Combination Sum.
- [ ] **Week 2 (Aug 4–10):** 0/1 knapsack family — House Robber, 0/1 Knapsack, Subset Sum, Partition Equal Subset Sum.
- [ ] **Week 3 (Aug 11–17):** 2D DP — LIS, LCS, Edit Distance, Longest Palindromic Subsequence.
- [ ] **Week 4 (Aug 18–24):** Mixed review week — 1 problem from each of weeks 1-3, timed, no hints. Reassess weak patterns.
- [ ] **Week 5 (Aug 25–31):** Arrays/Strings — sliding window, two pointers, prefix sums, Kadane's variants.
- [ ] **Week 6 (Sep 1–7):** Sorting & Searching — binary search on answer, merge intervals, k-way merge.
- [ ] **Week 7 (Sep 8–14):** LinkedList & Stacks/Queues — reversal, cycle detection, monotonic stack.
- [ ] **Week 8 (Sep 15–21):** Trees & BST — traversals (iterative + recursive), LCA, BST validation/construction.
- [ ] **Week 9 (Sep 22–28):** Graphs — BFS/DFS, topological sort, union-find, shortest path basics.
- [ ] **Week 10 (Sep 29–Oct 5):** Greedy & Backtracking — interval scheduling, permutations/subsets, N-Queens style.
- [ ] **Week 11 (Oct 6–12):** OOP/system-design fundamentals deep dive + behavioral story prep (this is your other known gap — see `mistakes-journal.md`).
- [ ] **Week 12 (Oct 13–19):** Full mock week — timed mixed-pattern problems daily, resume/behavioral polish, taper before applying hard.

Adjust dates freely if a week runs long — the point is finishing each pattern family solidly, not hitting the calendar exactly.

## Score snapshot

Run `python score.py` for live numbers. Manual snapshot (update weekly if you like):

| Week | Points | Streak (days) | Notes |
|---|---|---|---|
| 1 | – | – | – |
