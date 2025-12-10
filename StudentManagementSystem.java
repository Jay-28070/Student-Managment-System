import java.awt.Toolkit;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class StudentManagementSystem {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        mainMenu(scanner);
    }

    // =====================================================================
    // Add Students method
    // =====================================================================
    public static void addStudents(Scanner scanner) {
        System.out.print("\n---Add Students---\n");

        // Name field
        String name = Functions.checkEmptyString("Enter student's name: ");

        // Surname field
        String surname = Functions.checkEmptyString("Enter " + name + "'s surname: ");

        // Age field
        int age_int = 0;
        String age = Functions.checkEmptyString("Enter " + name + "'s age: ");
        // Convert age to int for try and catch
        try {
            age_int = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid number!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        // Generate unique ID
        Random random = new Random();
        int id = 0;
        for (int i = 0; i < 5; i++) {
            int randomNr = random.nextInt(10);
            id = id * 10 + randomNr;
        }

        // Parse id to string
        String id_str = Integer.toString(id);

        // Create student object
        Student newStudent = new Student(name, surname, age_int, id_str);
        ArrayStudents.students.add(newStudent);

        System.out.println("\nStudent added successfully!\n");
        mainMenu(scanner);
    }

    // =====================================================================
    // View Students Method (sorted by ID)
    // =====================================================================
    public static void viewStudents(Scanner scanner) {
        System.out.print("\n---View all students (Sorted via ID)---\n\n");

        // Bubble sort by ID
        for (int i = 0; i < ArrayStudents.students.size() - 1; i++) {
            for (int j = 0; j < ArrayStudents.students.size() - i - 1; j++) {

                // Need to change to int to use comparison operators
                int id1 = Integer.parseInt(ArrayStudents.students.get(j).getId());
                int id2 = Integer.parseInt(ArrayStudents.students.get(j + 1).getId());

                if (id1 > id2) {
                    Collections.swap(ArrayStudents.students, j, j + 1);
                }
            }
        }

        // Print students
        for (Student student : ArrayStudents.students) {
            System.out.println(student.getName() + " " + student.getSurname() + "\nID: " + student.getId());
            System.out.print("\n");
        }

        mainMenu(scanner);
    }

    // =====================================================================
    // Remove Students method
    // =====================================================================
    public static void removeStudents(Scanner scanner) {
        System.out.print("\n---Remove Students---\n\n");

        while (true) {
            System.out.print("Enter name of student you wish to remove: ");
            String input = scanner.nextLine().trim();

            if (input.isBlank()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "You cannot leave field empty!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                boolean removed = ArrayStudents.students.removeIf(student -> input.equalsIgnoreCase(student.getName()));
                if (removed) {
                    System.out.println("Student removed!");
                } else {
                    System.out.println("No student found with that name.");
                }
                break;
            }
        }
        mainMenu(scanner);
    }

    // =====================================================================
    // Search student method
    // =====================================================================
    public static void searchStudentInfo(Scanner scanner) {
        System.out.print("\n---Search Students---\n\n");

        System.out.print("Enter name/surname/ID to search: ");
        String input = scanner.nextLine().trim();

        if (input.isBlank()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "You cannot leave field empty!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            boolean found = false;
            for (Student student : ArrayStudents.students) {
                if (student.getName().equalsIgnoreCase(input) || student.getSurname().equalsIgnoreCase(input)
                        || student.getId().equalsIgnoreCase(input)) {
                    System.out.println(
                            "Found: " + student.getName() + " " + student.getSurname() + " | ID: " + student.getId());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No student found with that name.");
            }
        }
        mainMenu(scanner);
    }

    // =====================================================================
    // Update Students method
    // =====================================================================
    public static void updateStudents(Scanner scanner) {
        System.out.print("\n---Update Student---");

        System.out.print("\n");

        if (ArrayStudents.students.isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,
                    "System has no students to update!\nEnsure students are added to update", "Hint",
                    JOptionPane.PLAIN_MESSAGE);
            mainMenu(scanner);
        }

        // Print list of students
        for (Student s : ArrayStudents.students) {
            System.out.print(s.getName() + " " + s.getSurname() + "\nID: " + s.getId() + "\nAge: " + s.getAge());
            System.out.println("\n");
        }

        String input = Functions.checkEmptyString("Enter name/surname/ID to select student you wish to update: ");
        // Check if updateName == name/Id/Surname to update.

        Student target = null;

        // Find student
        for (Student s : ArrayStudents.students) {
            if (s.getName().equalsIgnoreCase(input) || s.getSurname().equalsIgnoreCase(input)
                    || s.getId().equalsIgnoreCase(input)) {
                target = s;
                break;
            }
        }

        // Check if target could not be found
        if (target == null) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Student could not be found!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Update fields
        System.out.println("\nUpdating: " + target.getName() + " " + target.getSurname());

        String newName = Functions.allowBlank(scanner, "Enter new name (leave blank to keep same): ");
        if (!newName.isBlank())
            target.setName(newName);

        String newSurname = Functions.allowBlank(scanner, "Enter new surname (leave blank to keep same): ");
        if (!newSurname.isBlank())
            target.setSurname(newSurname);

        String newAgeStr = Functions.allowBlank(scanner, "Enter new age (leave blank to keep same): ");
        if (!newAgeStr.isBlank()) {
            try {
                target.setAge(Integer.parseInt(newAgeStr));
            } catch (NumberFormatException e) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Invalid number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        System.out.println("\nStudent updated successfully!");

        mainMenu(scanner);
    }

    // =====================================================================
    // Main menu method
    // =====================================================================
    public static void mainMenu(Scanner scanner) {
        while (true) {
            System.out.print(
                    "\nWelcome\n---------------------------------------------------------------------------------------------------");
            System.out
                    .print("\n1. Add students\n2. View all students\n3. Remove student\n4. Search student\n5. Update students\n6. Exit\n");

            System.out.print("\nEnter choice: ");
            String userChoice_str = scanner.nextLine();

            if (userChoice_str.isBlank()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "You cannot leave field empty!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int userChoice_int = Integer.parseInt(userChoice_str);
                    if (userChoice_int > 5 || userChoice_int <= 0) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Enter a valid number!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (userChoice_int == 1) {
                        addStudents(scanner);
                    } else if (userChoice_int == 2) {
                        viewStudents(scanner);
                    } else if (userChoice_int == 3) {
                        removeStudents(scanner);
                    } else if (userChoice_int == 4) {
                        searchStudentInfo(scanner);
                    } else if (userChoice_int == 5) {
                        updateStudents(scanner);
                    } else if (userChoice_int == 6) {
                        System.exit(0);
                    }
                    break;
                } catch (NumberFormatException e) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Enter a valid number!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}