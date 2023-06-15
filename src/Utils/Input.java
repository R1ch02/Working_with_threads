package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static int getUserInput(String prompt) {
        System.out.println(prompt);
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }
}
