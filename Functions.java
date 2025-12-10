import java.util.Scanner;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Functions {
    public static Scanner scanner = new Scanner(System.in);

    // Check if inputs were submitted with empty strings
    public static String checkEmptyString(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();

            if (input.isBlank()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "You cannot leave field empty!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                return input;
            }
        }
    }
}
