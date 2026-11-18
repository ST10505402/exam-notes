# PROG6112 Exam-Level Mock 3 – Model Solution

One repo, one branch, one folder per question (the same layout to use in the real exam).

| Folder | Project | Run | Expected result |
| --- | --- | --- | --- |
| `Question1/` | Student marks report | `StudentMarksReport.java` | Averages 72.33 / 50.67 / 86.00; highest 91, lowest 45, 2 marks below 50 |
| `Question2/` | Sedibeng Water GUI | `WaterUsageForm.java` (set as the main class in `pom.xml`) | 277 kl / 23 kl / 31 kl / 4 over limit; Months Processed: 4; saves `usage_log.txt` |

Open each folder separately in NetBeans (**File → Open Project**). `WaterUsageForm` has its `.form` file, so it opens in **Design** view.

Unit tests are in each project's `src/test/java`. Right-click the project → **Test**.
