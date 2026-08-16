# AI-Generated Software Architecture: Comparative Evaluation of AI-Generated and Human-Designed Architectures

## Dissertation Project

This repository contains the research artefacts associated with my MSc dissertation investigating the comparative characteristics of **AI-generated and human-designed software architectures**.

The study examines whether Generative AI can produce coherent, requirements-aligned, and application-specific software architectures, and investigates where human architectural expertise remains important, particularly in contextual reasoning, architectural judgement, trade-offs, and validation.

---

## Research Overview

The dissertation uses a **multiple-case comparative research design** to evaluate AI-generated architectures against published human-designed architectures.

A common **implementation-independent Software Requirements Specification (SRS)** is reconstructed for each case study. The SRS is then used as the requirements baseline for generating an independent AI architecture.

The architectures are subsequently compared using:

- Requirements-to-architecture traceability
- Functional suitability
- Modularity
- Maintainability
- Scalability
- Interoperability
- Security
- Architectural evidence and justification

A consistent evaluation framework and evidence-based scoring approach are applied across the cases.

---

## Research Methodology

The research follows these main stages:

1. **Case Study Selection**
   - Selection of published software architecture cases from different application domains.

2. **Implementation-Independent SRS Reconstruction**
   - Requirements are extracted from the published case material.
   - Implementation technologies, architectural patterns, and design decisions are excluded.

3. **AI Architecture Generation**
   - The implementation-independent SRS is provided to the selected GenAI model.
   - The published human architecture is not provided to the AI model.
   - The generated architecture is treated as an independent architectural alternative.

4. **Human Architecture Extraction**
   - The published human-designed architecture is documented from the available source material without modification.

5. **Comparative Evaluation**
   - Both architectures are evaluated using the same requirements baseline and evaluation framework.

6. **Cross-Case Analysis**
   - Findings are compared across the different application domains to identify recurring patterns and differences.

7. **Proof of Concept**
   - The methodology is additionally demonstrated through an independently developed and implemented Carbon Credit Trading Platform.

---

# Proof of Concept — Carbon Credit Trading Platform

## Overview

A key component of this research is the **Proof of Concept (PoC): a Carbon Credit Trading Platform** developed specifically to demonstrate the application of the comparative architecture evaluation methodology in an independently implemented system.

Unlike the published case studies, the PoC provides an additional level of **implementation evidence**, allowing the architectural comparison to be examined alongside an actual working software implementation.

The platform addresses a carbon-credit trading workflow involving areas such as:

- User and access management
- Sustainability verification
- Carbon credit issuance
- Carbon credit marketplace operations
- Credit purchasing
- Portfolio management
- Monitoring and reporting
- Security and auditability
- Extensibility

---

## PoC Architecture

The human-designed PoC architecture was developed using a **layered MVC and Monolithic-Kernel architectural organisation**, supported by several design patterns and architectural mechanisms.

The implementation includes mechanisms such as:

- MVC-based separation of responsibilities
- Monolithic Kernel organisation
- Factory Pattern
- Strategy Pattern
- State Pattern
- Observer Pattern
- Decorator Pattern
- Interceptor-based mechanisms
- Authentication and role-based access control
- JSON-based persistence

These architectural mechanisms were selected to support the functional and quality requirements of the platform.

---

## AI-Generated Architecture

An independent AI-generated architecture was produced from the same implementation-independent SRS.

The AI model was not provided with the human-designed architecture or its implementation details.

This allows the PoC to demonstrate the central research comparison:

```text
Implementation-Independent SRS
              │
       ┌──────┴──────┐
       │             │
       ▼             ▼
 Human Architecture  AI-Generated Architecture
       │             │
       └──────┬──────┘
              ▼
     Common Evaluation Framework
              │
              ▼
       Comparative Findings
