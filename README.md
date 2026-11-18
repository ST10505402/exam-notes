# PROG6112 (Programming 1B) – Exam Notes

Study notes, quick references, code templates and worked model answers for the IIE PROG6112 open-book examination.

- **Repository:** https://github.com/ST10505402/exam-notes
- **Repository owner:** Thakgalang Monama
- **Content compiled by:** Thakgalang Monama
- **Last updated:** November 2026

---

## Contents

| Folder / file | What it is | Use it for |
| --- | --- | --- |
| `references/Java_Methods_Reference.pdf` | 7-page quick reference: String, StringBuilder, Character, arrays, `Arrays`, int / Integer / Double, Math, ArrayList, common traps | Looking up a method's name, return type and behaviour |
| `guides/01_8-Day_Study_Plan.pdf` | 8-day plan, exam format, past-paper topic analysis, first templates | Planning revision |
| `guides/02_Learning_Unit_Study_Guide.pdf` | Every learning outcome (LU1–LU6) explained with code and self-checks | Theory and concepts |
| `guides/03_NetBeans_GUI_Builder.pdf` | Step-by-step drag-and-drop Swing in NetBeans (Maven), menus, handlers, troubleshooting | Building the Question 2 form quickly |
| `guides/04_Mock_Exam_1.pdf`, `guides/04_Mock_Exam_1_Memo.pdf` | Mock exam (water usage + car wash) and its memo | Timed practice |
| `guides/05_Mock_Question_Event_Registration.pdf` | Extended Question 2 practice (above exam level) | Validation and file practice |
| `guides/06_Mock_Exam_2.pdf`, `guides/07_Mock_Exam_3.pdf` | Exam-level mocks (farm stall + car hire; student marks + water usage) | Timed practice |
| `templates/` (`PROG6112-Exam-Templates`) | Maven project of reusable templates + memos for past papers | Copying patterns into exam projects |
| `mock-solutions/PROG6112-Mock2-Solution/` | Model answers for Mock 2 (Question1 + Question2, with NetBeans `.form`) | Checking your attempt |
| `mock-solutions/PROG6112-Mock3-Solution/` | Model answers for Mock 3 | Checking your attempt |

> **Copyright:** do not upload the textbook PDF, the IIE past papers or the IIE module outline to this repository if it is public. They are referenced below, not redistributed.

---

## Code references (by file)

In-text citations refer to the [Reference list](#reference-list). Each file was written for this repository; the sources show where the technique comes from.

### Templates – `templates/src/main/java/templates/`

| File | Covers | Sources (in-text) |
| --- | --- | --- |
| `arrays/SortingTemplate.java` | Bubble sort (asc / desc / String), parallel-array sort, insertion sort, `Arrays.sort` | (Farrell, 2023: §8.7); (Oracle, n.d.a); (Oracle, n.d.g) |
| `arrays/TwoDArrayTemplate.java` | 2D + parallel arrays, table printing, row / column / grand totals, average, max / min, search | (Farrell, 2023: §8.8); (Oracle, n.d.g); (Oracle, n.d.i) |
| `arrays/ArrayListTemplate.java` | ArrayList of Strings, Integers and objects; `Collections` | (Farrell, 2023: §13.3); (Oracle, n.d.a); (Oracle, n.d.l) |
| `arrays/EnumTemplate.java` | `values()`, `ordinal()`, `valueOf()`, switch, enum with a field | (Farrell, 2023: §8.10); (Oracle, n.d.a) |
| `interfaces/IProductSales.java`, `ProductSales.java`, `ProductSalesReport.java` | Interface + implementing class; Question 1 console report | (Farrell, 2023: §9.12); (Oracle, n.d.h) |
| `inheritance/Employee.java`, `Manager.java` | Superclass / subclass, `super`, `@Override`, overloading, `toString`, `equals` | (Farrell, 2023: §9.1–9.10); (Oracle, n.d.h) |
| `inheritance/Shape.java`, `Circle.java`, `Rectangle.java`, `InheritanceDemo.java` | Abstract classes, dynamic binding, arrays of subclass objects | (Farrell, 2023: §9.8–9.11); (Oracle, n.d.h) |
| `exceptions/ExceptionTemplate.java`, `InvalidInputException.java` | try / catch / finally, `throws`, `throw`, custom exception, call stack, `assert` | (Farrell, 2023: ch. 10); (Oracle, n.d.e) |
| `files/FileTemplate.java` | Write, append, read, split CSV, random access (`FileChannel`) | (Farrell, 2023: ch. 11); (Oracle, n.d.f); (Oracle, n.d.a) |
| `gui/MovieTicketForm.java`, `TicketData.java`, `IMovieTickets.java`, `MovieTickets.java` | Swing form, menu, process / save / load / clear, validation class | (Farrell, 2023: ch. 14); (Oracle, n.d.b); (Oracle, n.d.c) |
| `gui/TravelForm.java` | Combo boxes, array with a maximum, append file, load into `JList` | (Farrell, 2023: ch. 14); (Oracle, n.d.b); (Oracle, n.d.f) |
| `gui/SwingComponentsTemplate.java` | Layouts, panels, colours, radio buttons, `ButtonGroup`, `JList`, menus with mnemonics / accelerators, mouse events, dialogs | (Oracle, n.d.b); (Oracle, n.d.c); (Oracle, n.d.j); (Oracle, n.d.k) |
| `test/.../*Test.java` | JUnit 5 assertions: `assertEquals` (with tolerance), `assertTrue/False`, `assertArrayEquals`, `assertThrows` | (JUnit Team, n.d.) |

### Past-paper memos – `templates/src/main/java/memos/`

| Package | Answers | Sources (in-text) |
| --- | --- | --- |
| `exam2024.q1`, `exam2024.q2` | 2024 exam: movie ticket report; movie tickets GUI (14% VAT) | (The IIE, 2024); (Farrell, 2023); (Oracle, n.d.a) |
| `exam2025.q1`, `exam2025.q2` | 2025 exam: product sales report; product sales GUI | (The IIE, 2025); (Farrell, 2023); (Oracle, n.d.b) |
| `practice2026.q1`, `practice2026.q2` | 2026 practice exam: theatre report; surf shop GUI | (The IIE, 2026b); (Farrell, 2023) |
| `mock1.q1`, `mock1.q2` | Mock exam 1: water usage; car wash | (Farrell, 2023); (Oracle, n.d.a) |
| `mock2.q2` | Event registration (character limits via `DocumentFilter`, live counter, validation) | (Oracle, n.d.d); (Oracle, n.d.b) |

### Mock solutions – `mock-solutions/`

| Project | Sources (in-text) |
| --- | --- |
| `PROG6112-Mock2-Solution/Question1` (farm stall report) | (Farrell, 2023: §8.8); (Oracle, n.d.g) |
| `PROG6112-Mock2-Solution/Question2` (car hire GUI, NetBeans form) | (Apache NetBeans, n.d.); (Oracle, n.d.b); (Oracle, n.d.f) |
| `PROG6112-Mock3-Solution/Question1` (student marks report) | (Farrell, 2023: §8.8); (Oracle, n.d.i) |
| `PROG6112-Mock3-Solution/Question2` (water usage GUI, NetBeans form) | (Apache NetBeans, n.d.); (Oracle, n.d.b); (Oracle, n.d.f) |

### Guides and PDF

| Document | Sources (in-text) |
| --- | --- |
| Java Methods Reference (PDF) | (Oracle, n.d.a); (Farrell, 2023) |
| 8-Day Study Plan | (The IIE, 2026a); (The IIE, 2022; 2023; 2024; 2025); (Farrell, 2023) |
| Learning Unit Study Guide | (The IIE, 2026a); (Farrell, 2023); (Oracle, n.d.b–n.d.h) |
| NetBeans GUI Builder guide | (Apache NetBeans, n.d.); (Apache Maven Project, n.d.); (JUnit Team, n.d.) |
| Mock exams and memos | Format modelled on (The IIE, 2024; 2025; 2026b) |

---

## Reference list

Harvard style, following the IIE referencing convention. Check the current *IIE Referencing Guide* for exact punctuation.

Anthropic. 2026. *Claude* (Opus 5.5) [Large language model]. Available at: https://claude.ai [Accessed 11–18 November 2026].

Apache Maven Project. n.d. *Maven Getting Started Guide*. [Online]. Available at: https://maven.apache.org/guides/getting-started/ [Accessed 18 November 2026].

Apache NetBeans. n.d. *Designing a Swing GUI in NetBeans IDE*. [Online]. Available at: https://netbeans.apache.org/tutorial/main/kb/docs/java/quickstart-gui/ [Accessed 18 November 2026].

Farrell, J. 2023. *Java Programming*. 10th ed. Boston: Cengage Learning.

JUnit Team. n.d. *JUnit 5 User Guide*. [Online]. Available at: https://junit.org/junit5/docs/current/user-guide/ [Accessed 18 November 2026].

Oracle. n.d.a. *Java Platform, Standard Edition 17 API Specification*. [Online]. Available at: https://docs.oracle.com/en/java/javase/17/docs/api/ [Accessed 18 November 2026].

Oracle. n.d.b. *The Java Tutorials: Creating a GUI With Swing*. [Online]. Available at: https://docs.oracle.com/javase/tutorial/uiswing/ [Accessed 18 November 2026].

Oracle. n.d.c. *The Java Tutorials: How to Use Menus*. [Online]. Available at: https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html [Accessed 18 November 2026].

Oracle. n.d.d. *The Java Tutorials: Text Component Features* (Implementing a Document Filter). [Online]. Available at: https://docs.oracle.com/javase/tutorial/uiswing/components/generaltext.html [Accessed 18 November 2026].

Oracle. n.d.e. *The Java Tutorials: Lesson: Exceptions*. [Online]. Available at: https://docs.oracle.com/javase/tutorial/essential/exceptions/ [Accessed 18 November 2026].

Oracle. n.d.f. *The Java Tutorials: Basic I/O*. [Online]. Available at: https://docs.oracle.com/javase/tutorial/essential/io/ [Accessed 18 November 2026].

Oracle. n.d.g. *The Java Tutorials: Arrays*. [Online]. Available at: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html [Accessed 18 November 2026].

Oracle. n.d.h. *The Java Tutorials: Interfaces and Inheritance*. [Online]. Available at: https://docs.oracle.com/javase/tutorial/java/IandI/ [Accessed 18 November 2026].

Oracle. n.d.i. *The Java Tutorials: Formatting Numeric Print Output*. [Online]. Available at: https://docs.oracle.com/javase/tutorial/java/data/numberformat.html [Accessed 18 November 2026].

Oracle. n.d.j. *The Java Tutorials: How to Use Buttons, Check Boxes, and Radio Buttons*. [Online]. Available at: https://docs.oracle.com/javase/tutorial/uiswing/components/button.html [Accessed 18 November 2026].

Oracle. n.d.k. *The Java Tutorials: How to Make Dialogs*. [Online]. Available at: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html [Accessed 18 November 2026].

Oracle. n.d.l. *The Java Tutorials: Introduction to Collections*. [Online]. Available at: https://docs.oracle.com/javase/tutorial/collections/intro/index.html [Accessed 18 November 2026].

The Independent Institute of Education (The IIE). 2022. *Programming 1B (PROG6112) Examination 2022*. Johannesburg: The IIE.

The Independent Institute of Education (The IIE). 2023. *Programming 1B (PROG6112) Examination 2023*. Johannesburg: The IIE.

The Independent Institute of Education (The IIE). 2024. *Programming 1B (PROG6112) Examination 2024*. Johannesburg: The IIE.

The Independent Institute of Education (The IIE). 2025. *Programming 1B (PROG6112) Examination 2025*. Johannesburg: The IIE.

The Independent Institute of Education (The IIE). 2026a. *Programming 1B (PROG6112w) Module Outline 2026*. Johannesburg: The IIE.

The Independent Institute of Education (The IIE). 2026b. *Programming 1B Practice Examination 2026*. Johannesburg: The IIE.

---

## How to cite this repository

**Reference list entry:**

Monama, T. 2026. *exam-notes* [Source code]. GitHub. Available at: https://github.com/ST10505402/exam-notes [Accessed 18 November 2026].

**In-text:** (Monama, 2026)

**Code attribution comment** (place above code you adapted from this repository):

```java
/*
 * Code attribution
 * Adapted from: Monama, T. 2026. exam-notes [Source code]. GitHub.
 * Available at: https://github.com/ST10505402/exam-notes [Accessed 18 Novemeber 2026].
 * File: templates/src/main/java/templates/arrays/TwoDArrayTemplate.java
 */
```

---

