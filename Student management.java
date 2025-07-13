// Jvdroid main-class: Main

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n====== Student Record Management ======");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    manager.addStudent(new Student(roll, name, dept));
                    break;

                case 2:
                    manager.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter roll number: ");
                    int r = sc.nextInt();
                    Student s = manager.searchStudent(r);
                    if (s != null)
                        System.out.println(s);
                    else
                        System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter roll number to delete: ");
                    int d = sc.nextInt();
                    if (manager.deleteStudent(d))
                        System.out.println("Deleted successfully.");
                    else
                        System.out.println("Student not found.");
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
                    break;
            } // closing switch
        } // closing while
    } // closing main
} // closing Main class

// -----------------------------
// Student class
// -----------------------------
class Student {
    private int rollNo;
    private String name;
    private String department;

    public Student(int rollNo, String name, String department) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Dept: " + department;
    }
}

// -----------------------------
// StudentManager class
// -----------------------------
class StudentManager {
    private List<Student> studentList = new ArrayList<>();

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Student s : studentList)
            System.out.println(s);
    }

    public Student searchStudent(int rollNo) {
        for (Student s : studentList) {
            if (s.getRollNo() == rollNo)
                return s;
        }
        return null;
    }

    public boolean deleteStudent(int rollNo) {
        Student s = searchStudent(rollNo);
        if (s != null) {
            studentList.remove(s);
            return true;
        }
        return false;
    }
                
