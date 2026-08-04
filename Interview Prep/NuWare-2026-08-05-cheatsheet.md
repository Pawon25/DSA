# NuWare Systems — Interview Cheat Sheet
**Wed 2026-08-05 @ 1 PM IST · MS Teams · Interviewer unknown**
Role: Dev (full-stack), HR specifically flagged interest in your **AI experience** — lead with that.

Company snapshot: US-based MNC IT services firm (founded 1994). Two visible lines: domain solutions
(Life Sciences / Capital Markets / CPG-Retail) and NuRIM (Remote Infrastructure Mgmt + QA, 24x7 India
ops center). Don't assume they're deep into AI/Rust/FastAPI — that's an unconfirmed guess, not a fact
(see "Why this role" below).

---

## 1. "Do you have AI experience?" (opener)
> "Yes — I've built and shipped AI features to production, not just prototyped them. At Texas AI I
> integrated Llama 3.2 for resume parsing and a TF-IDF + cosine-similarity scoring engine into our ATS
> platform, live for two client companies processing 500+ candidates a month. I've also worked with
> multi-agent LLM orchestration outside work — happy to go deeper on either."

Say it in your own words, not memorized verbatim. The dangling "multi-agent orchestration" line is a
deliberate breadcrumb for PairMind — don't explain it unless they bite.

## 2. Griffin Recruit (multi-tenant ATS) — Texas AI
**Why TF-IDF + cosine similarity over a fine-tuned model:**
> "Two reasons. One — TF-IDF plus cosine similarity is cheap to run and fully explainable, which matters
> when recruiters need to trust why a candidate ranked where they did, not a black-box score. Two — an
> LLM would need real GPU spend to re-rank thousands of candidates against hundreds of roles every week,
> and fine-tuning one would've meant weeks of labeling data we didn't have."

**Tenant isolation (how 2 client companies stay separate):**
> Shared DB, row-level isolation via `tenant_id` filter on every query, sourced from the JWT on each
> request. Honest gap to own, not hide: it's currently opt-in per query, not systemically enforced.
> "What I'd want next is enforcing that at the repository layer — a base data-access class that injects
> the tenant filter automatically, so it's not something a developer can forget."

## 3. CJIS-compliant investigation platform — Texas AI
**What CJIS constrained:** PII encrypted at rest + in transit, all services in a VPC, GovCloud for
government tenants.

**Why self-hosted Llama (via llama.cpp) instead of a third-party API:**
> "Third-party APIs mean your PII leaves your perimeter and hits a vendor you don't control — a
> non-starter under CJIS. So we self-hosted Llama on an EC2 c6i instance inside our VPC. More
> operational overhead for us, but it's the only way sensitive data never leaves our environment."

**Challenge/failure story — metadata migration (real, specific, use for "tell me about a bug/mistake"):**
- **Situation:** Document/evidence metadata was stored as an array inside the parent folder document in
  MongoDB — approaching the hard 16MB BSON document size limit as folders grew.
- **Discovery:** name how you actually noticed this before it became an outage (monitoring / near-miss /
  audit — nail this down before the interview, it's the one soft spot in the story).
- **Action:** split into two collections — folder metadata and flat file metadata — instead of nested
  arrays. Migrated live production data with a backfill script during a low-traffic window, with
  before/after validation counts to guarantee zero data loss (legally sensitive evidence data).
- **Result:** solved the size-ceiling problem *and* ~60% faster reads/filters/searches, since queries no
  longer needed a nested-array lookup.

## 4. OOP: abstraction vs encapsulation
> "Abstraction is what you choose to hide; encapsulation is how you enforce that hiding."
- Abstraction = design decision (what to expose) — e.g. a `List` interface: `add()`/`get()` without
  knowing the backing implementation.
- Encapsulation = mechanism (how you enforce it) — bundling data + methods, access modifiers
  (**private**, default, protected, public — don't drop `private`, it's the important one).

## 5. "Tell me about yourself" (Present → Past → Future)
> "I'm a full-stack engineer who specializes in shipping AI features into production, not just
> prototyping them. Over the last 1.5 years at Texas AI I've built systems like an AI-powered ATS
> scoring engine live for 500+ users a month, alongside earning an AWS ML Engineer certification
> (814/1000). I also placed 5th out of 300 developers at a Google-hosted hackathon (Proptwars), which
> pushed me to work fast and disciplined under real time pressure. What I'm looking for now is a role
> where I can keep owning that full loop — UI to backend to AI — on problems with real production
> stakes, which is part of why this conversation interested me."

## 6. "Why NuWare / why leave Texas AI"
Don't badmouth current stack/employer. Don't assert NuWare's tech direction — that's an unconfirmed
guess, not something HR told you.
> "I've built a strong foundation on Spring Boot and traditional stacks, but the work's become fairly
> repetitive. I'm looking to grow into more dynamic, AI-integrated work — that's the direction I want my
> career heading. Actually, I'm curious — how much is NuWare currently investing in AI-driven projects?"
Ending on a question is deliberate — turns a guess into genuine curiosity instead of a claim you can't back up.

## 7. Backup material if asked "what else have you built with AI" (breadcrumb targets)
- **PairMind** — multi-agent (Buyer/Seller) negotiation system, LangGraph orchestration, hybrid RAG
  (BM25 + dense kNN over OpenSearch, fused via Reciprocal Rank Fusion), Claude Haiku for reasoning,
  citation-grounded responses w/ validation-and-retry to cut hallucination, deadlock/timeout detection,
  deployed on EC2 + Nginx, streamed to React via SSE. Your most technically sophisticated project — good
  one to lead with if they push past the opener.
- **AgroIntent** — Vertex AI (Gemini 2.5 Flash) crop diagnostic tool, serverless FastAPI on Cloud Run,
  voice I/O + multi-language via Web Speech API.
- **NeuroSpectra** — SVM classifier for autism-risk prediction, 99.98% acc, benchmarked against Random
  Forest/Logistic Regression.

## 8. Known personal weak spots — self-check before you sleep
- Off-by-one loop bounds (recurring 3x in past DP drills: `i<=n` not `i<n` when filling `dp[n]`).
- If graphs/DSA come up: cycle detection needs `inStack`/`onPath` (not just `visited`) for directed
  graphs — cross edges false-positive on plain visited-set.
- Don't let vague claims stand — always anchor with one name/number/technique, not "several"/"various".

## Logistics
Join: https://teams.microsoft.com/meet/424308386910735?p=mSVDs3E6BmHwLFw9yW
Meeting ID: 424 308 386 910 735 · Passcode: Vb9dS2sJ
