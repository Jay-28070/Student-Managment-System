import java.awt.Toolkit;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MenuHub {

    public static void mainMenu(Scanner scanner) {
        System.out.print("\n---Manage Students---\n");
        System.out.print("1. Student's grades\n2. Student's subjects\n3. Back\n");

        //Space
        System.out.print("\n");


        int userChoice_int = 0;
        String userChoice = Functions.checkEmptyString("Enter choice: ");
        // COnvert to int for checks
        //Fix bug where it prints "Please enter choice" before exception check
        while (true) {
            userChoice = Functions.checkEmptyString("Please enter choice: ");

            try {
                userChoice_int = Integer.parseInt(userChoice);
                break;
            } catch (NumberFormatException e) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }
        }
        //Continue with menu select here.
        if (userChoice_int == 1) {


        } else if (userChoice_int == 2) {


        } else if (userChoice_int == 3) {
            StudentManagementSystem.mainMenu(scanner);

        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid number that is specified!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
