import java.awt.Toolkit;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

//Next feature to add is in view method, add an option to select which student they want more of an in-depth description of
//eg. Subjects and marks.

public class studentManagmentSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Call main menu method
        mainMenu(scanner);
    }

    // =========================================================================================================================================
    // Add Students method
    // =========================================================================================================================================
    public static void addStudents(Scanner scanner) {
        System.out.print("\n---Add Students---\n");

        // Name field
        String name = "";
        while (true) {
            System.out.print("Enter student's name: ");
            name = scanner.nextLine();
            // Check if name variable has a value
            if (name.isBlank()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "You cannot leave field empty!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }

        // Surname field
        String surname = "";
        while (true) {
            System.out.print("Enter " + name + "'s surname: ");
            surname = scanner.nextLine();
            // Check if surname variable has a value
            if (surname.isBlank()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "You cannot leave field empty!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }

        // Age field
        String age_str = "";
        int age_int = 0;
        while (true) {
            System.out.print("Enter " + name + "'s age: ");
            age_str = scanner.nextLine();
            // Check if age_str variable has a value
            if (age_str.isBlank()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "You cannot leave field empty!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                // Convert age_str to an Integer
                int age = Integer.parseInt(age_str);
                age_int += age;
                // break out of loop
                break;
            }
        }

        // Calculate unique ID for students
        Random random = new Random();
        int id = 0;
        for (int i = 0; i < 5; i++) {
            int randomNr = random.nextInt(10);
            id = id * 10 + randomNr;
        }

        //Parse ID to String
        String id_str = Integer.toString(id);

        // Object
        Student newStudent = new Student(name, surname, age_int, id_str);
        // Store student object to Array List students. File location =
        // arrayStudents.java
        ArrayStudents.students.add(newStudent);

        // Go back to main menu after
        mainMenu(scanner);
    }

    // =========================================================================================================================================
    // View Students Method
    // =========================================================================================================================================
    public static void viewStudents(Scanner scanner) {
        System.out.print("\n---View all students---\n");
        System.out.print("\n");

        for (Student student : ArrayStudents.students) {
            System.out.println(student.getName() + " " + student.getSurname() + "\nID: " + student.getId());
            System.out.print("\n");
        }

        // Go back to main menu afterward
        mainMenu(scanner);
    }

    // =========================================================================================================================================
    // Remove Students method
    // =========================================================================================================================================
    public static void removeStudents(Scanner scanner) {
        System.out.print("\n---Remove Students---\n");
        System.out.print("\n");

        while (true) {
            System.out.print("Enter name of student you wish to remove: ");
            String input = scanner.nextLine().toLowerCase();

            // Check if field is empty
            if (input.isBlank()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "You cannot leave field empty!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                // Rest of logic down here bro
                final String removeRequest = input;

                // Remove student
                boolean removed = ArrayStudents.students.removeIf(
                        student -> removeRequest.equalsIgnoreCase(student.getName()));

                if (removed) {
                    System.out.println("Student removed!");
                } else {
                    System.out.println("No student found with that name.");
                }
                // Break out main while loop
                break;
            }
        }
    }

    // =========================================================================================================================================
    // Search student method
    // =========================================================================================================================================
    public static void searchStudentInfo(Scanner scanner) {
        System.out.print("\n---Search Students---\n");
        System.out.print("\n");

        String input = "";
        while (true) {
            System.out.print("Enter Name/Surname/ID number: ");
            input = scanner.nextLine().toLowerCase();
            // Check if user inputted a value
            if (input.isBlank()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "You cannot leave field empty!", "Error",
                        JOptionPane.ERROR_MESSAGE);

            } else {
                // If input is not blank carry on rest of checks here V
                if (ArrayStudents.students.isEmpty()) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null,
                            "There are no students loaded on to the system. \nPlease ensure relevant students are added.",
                            "Hint", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Gap for neater output
                    System.out.println("\n");
                    // If not empty search array list for name and surname
                    for (Student s : ArrayStudents.students) {
                        if (s.getName().equalsIgnoreCase(input) || s.getSurname().equalsIgnoreCase(input) || s.getId().equalsIgnoreCase(input)) {
                            System.out.print(s.getName() + " " + s.getSurname() + "\nID: " + s.getId());
                            break;
                        }
                    }
                }
                // Gap to neaten output
                System.out.println("\n");
                // Go to main menu after finding the student
                mainMenu(scanner);
                // Break out of while loop
                break;
            }
        }
    }

    // =========================================================================================================================================
    // Main menu method
    // =========================================================================================================================================
    public static void mainMenu(Scanner scanner) {

        while (true) {

            System.out.print(
                    "\nWelcome\n---------------------------------------------------------------------------------------------------");
            System.out
                    .print("\n1. Add students\n2. View all students\n3. Remove student\n4. Search student\n5. Exit\n");

            System.out.print("\nEnter choice: ");
            String userChoice_str = scanner.nextLine();
            // Check if userChoice_str is submitted without input
            if (userChoice_str.isBlank()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "You cannot leave field empty!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                int userChoice_int = Integer.parseInt(userChoice_str);
                // Check if userChoice_int contains valid number
                if (userChoice_int > 5 || userChoice_int <= 0) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (userChoice_int == 1) {
                    addStudents(scanner);
                } else if (userChoice_int == 2) {
                    viewStudents(scanner);
                } else if (userChoice_int == 3) {
                    removeStudents(scanner);
                } else if (userChoice_int == 4) {
                    searchStudentInfo(scanner);
                } else if (userChoice_int == 5) {
                    System.exit(10);
                } else {
                    // Break out of while loop
                    break;
                }
            }
        }
    }
}