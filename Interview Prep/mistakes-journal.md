# Mistakes Journal (spaced repetition)

Log each real mistake once, then review it on the schedule below (Leitner-style: wrong → review sooner, right → review later). Move entries between boxes as you review them; don't delete history, just update `box` and `next_review`.

Boxes: **1** = review next day · **2** = review in 3 days · **3** = review in 7 days · **4** = review in 14 days · **5** = mastered, review monthly.

## Seed entries (from 2026-07-24 interview debrief)

### coin-change-combinations
- **What happened:** Given N and unlimited 1/2 rupee coins, tried to brute-force with buggy nested loops (`i>0; i++` never terminates) instead of recognizing the unbounded-knapsack-combinations pattern.
- **Fix:** `dp[0]=1; for coin in coins: for a in coin..N: dp[a]+=dp[a-coin]` — coin loop OUTSIDE, amount loop INSIDE gives combinations (not permutations).
- **Box:** 1 · **Next review:** 2026-07-25

### abstraction-vs-encapsulation
- **What happened:** Fumbled a clean live explanation of abstraction vs encapsulation.
- **Fix:** "Abstraction hides complexity (what), encapsulation hides data (how)." Abstraction = interface design (abstract class/interface). Encapsulation = access control (private fields + public methods). Car analogy: driving pedals = abstraction, sealed engine internals = encapsulation.
- **Box:** 1 · **Next review:** 2026-07-25

<!-- Add new entries below in the same format as you find new gaps. -->
