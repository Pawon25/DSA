# Mistakes Journal (spaced repetition)

Log each real mistake once, then review it on the schedule below (Leitner-style: wrong → review sooner, right → review later). Move entries between boxes as you review them; don't delete history, just update `box` and `next_review`.

Boxes: **1** = review next day · **2** = review in 3 days · **3** = review in 7 days · **4** = review in 14 days · **5** = mastered, review monthly.

## Seed entries (from 2026-07-24 interview debrief)

### coin-change-combinations
- **What happened:** Given N and unlimited 1/2 rupee coins, tried to brute-force with buggy nested loops (`i>0; i++` never terminates) instead of recognizing the unbounded-knapsack-combinations pattern.
- **Fix:** `dp[0]=1; for coin in coins: for a in coin..N: dp[a]+=dp[a-coin]` — coin loop OUTSIDE, amount loop INSIDE gives combinations (not permutations).
- **Box:** 1 · **Next review:** 2026-07-26
- **2026-07-25 review:** Solved `n,{1,2}` case with an ad-hoc parity-counting loop; had an off-by-one (loop excluded `i=0`, the all-2s case), fixed after a nudge. Didn't get to the general `dp[]` tabulation version — deferred to tomorrow. Staying in box 1 since the core pattern (not just this coin pair) isn't solid yet.

### abstraction-vs-encapsulation
- **What happened:** Fumbled a clean live explanation of abstraction vs encapsulation.
- **Fix:** "Abstraction hides complexity (what), encapsulation hides data (how)." Abstraction = interface design (abstract class/interface). Encapsulation = access control (private fields + public methods). Car analogy: driving pedals = abstraction, sealed engine internals = encapsulation.
- **Box:** 2 · **Next review:** 2026-07-31
- **2026-07-25 review:** First pass was thin (two flat definitions, no distinguishing hook). Recited the corrected version cleanly on second pass. Promoted to box 2.
- **2026-07-28 review:** One-liner and encapsulation half solid immediately, but the abstraction example conflated abstraction with inheritance (described parent-class-implementation reuse rather than a pure interface/caller relationship). Corrected with `list.sort()` — abstraction needs no inheritance at all. Clean restatement on second pass ("interface hides the how, caller just uses it"). Staying in box 2 (not promoting) since a genuine conceptual conflation surfaced, not just a thin definition.

### off-by-one-array-loop-bounds
- **What happened (2026-07-27, Climbing Stairs):** In the bottom-up tabulation version, sized the array `new int[n]` (valid indices `0..n-1`) but then read `dp[n]`. Separately, the fill loop used `i < n-1` as the stop condition, so the last index(es) never got computed before being read. This is the second session in a row with an array/loop boundary bug (Coin Change 2 on 2026-07-25 also had one) — recurring pattern, not a one-off.
- **Fix:** When a table needs indices `0..n` inclusive, allocate `n+1` slots. When a fill loop needs to cover index `n`, the condition must be `i <= n` (i.e. `i < n+1`), not `i < n` or `i < n-1`. General habit: after writing array size / loop bound, explicitly check "what's the highest index I read after this loop, and does my size/condition actually reach it?"
- **Box:** 1 · **Next review:** 2026-07-28
- **Note:** self-corrected both bugs via guided tracing (no answer handed over), and asked a sharp follow-up on why `dp[0]=1` rather than `0` — understood the "empty sequence still counts as one way" reasoning cleanly on first explanation.
- **2026-07-29 review (recall quiz):** Asked cold "what size do you allocate, and what's the loop condition to fill dp[n]?" Got the size (`n+1`) right instantly, but answered the loop condition as `i<n` — the exact same bug, third time now (Coin Change 2, Climbing Stairs, and this quiz). Self-corrected the instant it was pointed out, to `i<=n`. Staying in box 1, next review 2026-07-30 — recall clearly isn't automatic yet, needs another same-day-ish pass.

### dp-sentinel-value-choice
- **What happened (2026-07-29, Coin Change min coins):** Built the min-coins DP correctly (state, base case, min-over-coins recurrence, `c<=i` bounds guard) with heavy guidance, and it passed the reachable test case (`coins=[1,2,5],n=11`→`3`). But initialized the "impossible" sentinel per-index as `dp[i]=i+1`. Hand-tracing `coins=[2],n=3` (should be `-1`) exposed the bug: `dp[1]` stayed at its sentinel (`2`) since amount 1 is unreachable with only 2s, but the recurrence for `dp[3]` used `dp[1]+1=3` as if it were a real value, producing a fake-looking "real" answer of `3` instead of detecting impossibility.
- **Fix:** the sentinel must be a single value larger than any real answer *anywhere in the whole table*, not just larger than each index's own value. Since the max real coins needed for amount `i` (with a 1-coin available) is `i` itself, and `i` never exceeds `n`, initializing every `dp[index]` to the same `n+1` (not `index+1`) is safe: no chain of `+1` additions across the table can ever accidentally produce a value `<= n` from a truly-unreachable subproblem. (Also considered `Integer.MAX_VALUE` — rejected because `MAX_VALUE + 1` overflows to a huge negative number in Java, corrupting the `min()` comparison.)
- **Box:** 1 · **Next review:** 2026-07-30
- **Note:** self-reasoned to the fix via hand-tracing a concrete counterexample rather than being told the bug existed — good instinct once prompted to trace by hand. Implementation of the fix itself was pending when the session ended; verify it's actually applied and both test cases pass on the next review.

<!-- Add new entries below in the same format as you find new gaps. -->
