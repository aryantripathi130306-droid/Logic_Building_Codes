package campusmanagementproject;

import java.util.Scanner;

// ======================= LEVEL 1: STUDENT CLASS =======================
class Student {
    int rollNumber;
    String name;
    int[] marks = new int[6];
    int total;
    double average;
    char grade;
    boolean isPass;

    // Constructor to initialize student and calculate academic metrics
    Student(int rollNumber, String name, int[] marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        System.arraycopy(marks, 0, this.marks, 0, 6);
        calculatePerformance();
    }

    // Modular calculation logic
    final void calculatePerformance() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }
        average = total / 6.0;

        if (average >= 90)
            grade = 'A';
        else if (average >= 75)
            grade = 'B';
        else if (average >= 60)
            grade = 'C';
        else if (average >= 40)
            grade = 'D';
        else
            grade = 'F';

        isPass = average >= 40;
    }

    // Display student details in a card like format
    void displayCard() {
        System.out.println("\n\t╔════════════════════════════════════╗");
        System.out.println("\t║          STUDENT DETAILS           ║");
        System.out.println("\t╠════════════════════════════════════╣");
        System.out.printf("\t║ Roll No : %-24d ║\n", rollNumber);
        System.out.printf("\t║ Name    : %-24s ║\n", name);
        System.out.println("\t╠═══════════════════════════════════╣");
        System.out.println("\t║ Subject Marks:                     ║");
        for (int i = 0; i < 6; i++) {
            System.out.printf("\t║ Sub %d   : %-24d ║\n", (i + 1), marks[i]);
        }
        System.out.println("\t╠════════════════════════════════════╣");
        System.out.printf("\t║ Total   : %-24d ║\n", total);
        System.out.printf("\t║ Average : %-24.2f ║\n", average);
        System.out.printf("\t║ Grade   : %-24c ║\n", grade);
        System.out.printf("\t║ Result  : %-24s ║\n", (isPass ? "PASS" : "FAIL"));
        System.out.println("\t╚════════════════════════════════════╝");
    }

    // Method for table row representation (used for batch lists)
    void displayTableRow() {
        System.out.printf("| %-8d | %-15s | %-6d | %-7.2f | %-5c | %-6s |\n",
                rollNumber, name, total, average, grade, (isPass ? "PASS" : "FAIL"));
    }
}

// ======================= LEVEL 2: BATCH CLASS =======================
class Batch {
    String batchName;
    Student[] students = new Student[100]; // Array for storage (no ArrayList)
    int studentCount = 0;

    Batch(String batchName) {
        this.batchName = batchName;
    }

    // Validation: Check for duplicate roll numbers
    boolean isDuplicateRoll(int roll) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].rollNumber == roll)
                return true;
        }
        return false;
    }

    // Core Feature: Add Student
    void addStudent(Scanner sc) {
        if (studentCount >= 100) {
            System.out.println("Error: Batch is full.");
            return;
        }

        System.out.print("Enter Roll Number: ");
        int roll = readInt(sc);
        sc.nextLine(); // consume newline

        if (isDuplicateRoll(roll)) {
            System.out.println("Error: Duplicate roll number!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }

        int[] marks = new int[6];
        for (int i = 0; i < 6; i++) {
            System.out.print("Enter Marks for Subject " + (i + 1) + " (0-100): ");
            marks[i] = readInt(sc);
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Error: Invalid marks (must be 0-100).");
                return;
            }
        }

        students[studentCount++] = new Student(roll, name, marks);
        System.out.println("✨ Student added to " + batchName + " successfully!");
    }

    // Core Feature: Display Students
    void displayStudents() {
        if (studentCount == 0) {
            System.out.println("No students in batch: " + batchName);
            return;
        }

        System.out.println("\nLIST OF STUDENTS IN " + batchName.toUpperCase());
        System.out.println("------------------------------------------------------------------");
        System.out.println("| Roll No  | Name            | Total  | Avg     | Grade | Result |");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < studentCount; i++) {
            students[i].displayTableRow();
        }
        System.out.println("------------------------------------------------------------------");
    }

    // Core Feature: Search Student
    Student searchStudent(int roll) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].rollNumber == roll)
                return students[i];
        }
        return null;
    }

    // Core Feature: Update Student
    void updateStudent(int roll, Scanner sc) {
        Student s = searchStudent(roll);
        if (s == null) {
            System.out.println("Error: Student not found.");
            return;
        }

        System.out.println("Updating " + s.name + "... (Press Enter to keep current name)");
        sc.nextLine(); // clear buffer
        System.out.print("New Name: ");
        String newName = sc.nextLine().trim();
        if (!newName.isEmpty())
            s.name = newName;

        System.out.println("Update Marks? (1. Yes / 2. No)");
        int choice = readInt(sc);
        if (choice == 1) {
            for (int i = 0; i < 6; i++) {
                System.out.print("New Marks for Subject " + (i + 1) + ": ");
                int m = readInt(sc);
                if (m >= 0 && m <= 100)
                    s.marks[i] = m;
            }
            s.calculatePerformance();
        }
        System.out.println("Student updated successfully!");
    }

    // Core Feature: Delete Student (Array Shifting)
    void deleteStudent(int roll) {
        int index = -1;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].rollNumber == roll) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Error: Student not found.");
            return;
        }

        for (int i = index; i < studentCount - 1; i++) {
            students[i] = students[i + 1];
        }
        studentCount--;
        System.out.println("Student deleted successfully.");
    }

    // Core Feature: Analytics
    void displayAnalytics() {
        if (studentCount == 0) {
            System.out.println("No data available for analytics.");
            return;
        }

        Student topper = students[0];
        double batchTotalAvg = 0;
        int passCount = 0;

        for (int i = 0; i < studentCount; i++) {
            batchTotalAvg += students[i].average;
            if (students[i].average > topper.average)
                topper = students[i];
            if (students[i].isPass)
                passCount++;
        }

        System.out.println("\nBATCH ANALYTICS - " + batchName.toUpperCase());
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Topper Name     : " + topper.name + " (" + topper.average + "%)");
        System.out.println("Batch Average   : " + String.format("%.2f", (batchTotalAvg / studentCount)) + "%");
        System.out.println("Total Pass      : " + passCount);
        System.out.println("Total Fail      : " + (studentCount - passCount));
        System.out
                .println("Pass Percentage : " + String.format("%.2f", ((double) passCount / studentCount * 100)) + "%");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    // Bonus Feature: Sort Students by Total Marks (Bubble Sort)
    void sortStudents() {
        if (studentCount < 2)
            return;
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {
                if (students[j].total < students[j + 1].total) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("Students sorted by marks (highest to lowest).");
    }

    // Helper for robust integer reading
    private int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }
}

// ======================= LEVEL 3: CAMPUS CLASS =======================
class Campus {
    Batch[] batches = new Batch[50]; // Fixed array for batches
    int batchCount = 0;

    // Validation: Duplicate batch names
    boolean isDuplicateBatch(String name) {
        for (int i = 0; i < batchCount; i++) {
            if (batches[i].batchName.equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    void addBatch(String name) {
        if (name.trim().isEmpty()) {
            System.out.println("Error: Batch name cannot be empty.");
            return;
        }
        if (isDuplicateBatch(name)) {
            System.out.println("Error: Batch '" + name + "' already exists.");
            return;
        }
        if (batchCount >= 50) {
            System.out.println("Error: Campus batch limit reached.");
            return;
        }
        batches[batchCount++] = new Batch(name);
        System.out.println("Batch '" + name + "' created successfully!");
    }

    void displayBatches() {
        if (batchCount == 0) {
            System.out.println("No batches registered in the campus.");
            return;
        }
        System.out.println("\nREGISTERED BATCHES");
        System.out.println("━━━━━━━━━━━━━━━━━━━━");
        for (int i = 0; i < batchCount; i++) {
            System.out.println((i + 1) + ". " + batches[i].batchName + " [" + batches[i].studentCount + " Students]");
        }
    }

    Batch searchBatch(String name) {
        for (int i = 0; i < batchCount; i++) {
            if (batches[i].batchName.equalsIgnoreCase(name))
                return batches[i];
        }
        return null;
    }

    void campusAnalytics() {
        if (batchCount == 0) {
            System.out.println("No campus data available.");
            return;
        }

        Student overallTopper = null;
        String topperBatchName = "";
        int totalStudents = 0;
        Batch bestBatch = null;
        double highestBatchAvg = -1;

        for (int i = 0; i < batchCount; i++) {
            Batch b = batches[i];
            totalStudents += b.studentCount;
            double currentBatchSum = 0;

            for (int j = 0; j < b.studentCount; j++) {
                Student s = b.students[j];
                currentBatchSum += s.average;
                if (overallTopper == null || s.average > overallTopper.average) {
                    overallTopper = s;
                    topperBatchName = b.batchName;
                }
            }

            if (b.studentCount > 0) {
                double avg = currentBatchSum / b.studentCount;
                if (avg > highestBatchAvg) {
                    highestBatchAvg = avg;
                    bestBatch = b;
                }
            }
        }

        System.out.println("\n GLOBAL CAMPUS ANALYTICS");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Total Students  : " + totalStudents);
        System.out.println("Total Batches   : " + batchCount);
        if (overallTopper != null) {
            System.out.println("Overall Topper  : " + overallTopper.name + " (" + overallTopper.average + "%)");
            System.out.println("Topper's Batch  : " + topperBatchName);
        }
        if (bestBatch != null) {
            System.out.println(
                    "Best Batch      : " + bestBatch.batchName + " (" + String.format("%.2f", highestBatchAvg) + "%)");
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
}

// ======================= MAIN ENTRY POINT =======================
public class CampusManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Campus campus = new Campus();

        displaySplash();

        int choice = 0;
        while (choice != 11) {
            printMenu();
            System.out.print("Selection: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // Clear buffer
            } else {
                System.out.println("Invalid Input! Please enter a number.");
                sc.next(); // Clear invalid token
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter new batch name: ");
                    campus.addBatch(sc.nextLine());
                    break;

                case 2:
                    campus.displayBatches();
                    break;

                case 3:
                    System.out.print("Enter target batch name: ");
                    Batch bAdd = campus.searchBatch(sc.nextLine());
                    if (bAdd != null)
                        bAdd.addStudent(sc);
                    else
                        System.out.println("Batch not found.");
                    break;

                case 4:
                    System.out.print("Enter batch name: ");
                    Batch bDisp = campus.searchBatch(sc.nextLine());
                    if (bDisp != null)
                        bDisp.displayStudents();
                    else
                        System.out.println("Batch not found.");
                    break;

                case 5:
                    System.out.print("Enter batch name: ");
                    Batch bSearch = campus.searchBatch(sc.nextLine());
                    if (bSearch != null) {
                        System.out.print("Enter Student Roll Number: ");
                        int roll = readInt(sc);
                        Student s = bSearch.searchStudent(roll);
                        if (s != null)
                            s.displayCard();
                        else
                            System.out.println("Student not found.");
                    } else
                        System.out.println("Batch not found.");
                    break;

                case 6:
                    System.out.print("Enter batch name: ");
                    Batch bUpdate = campus.searchBatch(sc.nextLine());
                    if (bUpdate != null) {
                        System.out.print("Enter Student Roll Number: ");
                        bUpdate.updateStudent(readInt(sc), sc);
                    } else
                        System.out.println("Batch not found.");
                    break;

                case 7:
                    System.out.print("Enter batch name: ");
                    Batch bDel = campus.searchBatch(sc.nextLine());
                    if (bDel != null) {
                        System.out.print("Enter Student Roll Number: ");
                        bDel.deleteStudent(readInt(sc));
                    } else
                        System.out.println("Batch not found.");
                    break;

                case 8:
                    System.out.print("Enter batch name: ");
                    Batch bAnal = campus.searchBatch(sc.nextLine());
                    if (bAnal != null)
                        bAnal.displayAnalytics();
                    else
                        System.out.println("Batch not found.");
                    break;

                case 9:
                    campus.campusAnalytics();
                    break;

                case 10:
                    System.out.print("Enter batch name: ");
                    Batch bSort = campus.searchBatch(sc.nextLine());
                    if (bSort != null)
                        bSort.sortStudents();
                    else
                        System.out.println("Batch not found.");
                    break;

                case 11:
                    System.out.println("Thank you for using SMART CAMPUS! Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    private static void displaySplash() {
        System.out.println("\n\t*****************************************");
        System.out.println("\t*      SMART CAMPUS MANAGEMENT SYSTEM     *");
        System.out.println("\t*        [ FINAL CAPSTONE PROJECT ]      *");
        System.out.println("\t*****************************************");
    }

    private static void printMenu() {
        System.out.println("\n MAIN MENU");
        System.out.println("1. Add Batch");
        System.out.println("2. Display Batches");
        System.out.println("3. Add Student to Batch");
        System.out.println("4. Display Students of Batch");
        System.out.println("5. Search Student");
        System.out.println("6. Update Student");
        System.out.println("7. Delete Student");
        System.out.println("8. Batch Analytics");
        System.out.println("9. Campus Analytics");
        System.out.println("10. Sort Students in Batch");
        System.out.println("11. Exit");
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }
}