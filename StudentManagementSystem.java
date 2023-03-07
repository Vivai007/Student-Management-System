import java.util.*;

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. View all students");
            System.out.println("4. Exit");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    System.out.println("Enter student name:");
                    String name = sc.nextLine();
                    System.out.println("Enter student ID:");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.println("Enter student email:");
                    String email = sc.nextLine();
                    Student newStudent = new Student(name, id, email);
                    students.add(newStudent);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.println("Enter student ID to remove:");
                    int removeId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    boolean removed = false;
                    for (Student s : students) {
                        if (s.getId() == removeId) {
                            students.remove(s);
                            removed = true;
                            System.out.println("Student removed successfully.");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("No student with that ID found.");
                    }
                    break;
                case 3:
                    System.out.println("All students:");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Student {
    private String name;
    private int id;
    private String email;
    
    public Student(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Email: " + email;
    }
}
