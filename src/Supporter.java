import java.util.InputMismatchException;
import java.util.Scanner;

public class Supporter {
    public static final Scanner sc = new Scanner(System.in);
    Validator validator = new Validator();

    public int inputInt() {
        int number = 0;
        try {
            number = sc.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Integers only, Choose again: ");
            sc.next();
        }

        return number;
    }

    public String inputString() {
        String str = "";
        try {
            str = sc.next();
        } catch (InputMismatchException exception) {
            System.out.println("Integers only, Choose again: ");
            sc.next();
        }

        return str;
    }

}
