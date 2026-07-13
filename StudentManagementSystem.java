import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age);
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // ✅ Input validation
            while (!sc.hasNextInt()) {
                System.out.println("❌ Please enter a valid number!");
                sc.next(); // discard invalid input
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: System.out.println("👋 Exiting... Thank you!"); break;
                default: System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        students.add(new Student(id, name, age));
        System.out.println("✅ Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students found.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : students) {
                s.display();
            }
        }
    }

    private static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Student s : students) {
            if (s.getId() == id) {
                s.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Student not found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Student s : students) {
            if (s.getId() == id) {
                sc.nextLine(); // consume newline
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new age: ");
                int age = sc.nextInt();
                s.setName(name);
                s.setAge(age);
                System.out.println("✅ Student updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        boolean removed = students.removeIf(s -> s.getId() == id);
        if (removed) {
            System.out.println("✅ Student deleted successfully!");
        } else {
            System.out.println("❌ Student not found.");
        }
    }
}
