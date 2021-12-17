import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Validator {
    public static final Scanner sc = new Scanner(System.in);
    private int selection;
    
    public class DomainNotValidException extends RuntimeException {

        public DomainNotValidException(String message) {
           super(message);
        }
    }

    public void validateEmail(String email) {
        if (!isDomainValid(email)) {
            throw new DomainNotValidException("Invalid domain");
        }
    }

    private boolean isDomainValid(String email) {
        List<String> validDomains = Arrays.asList("gmail.com", "yahoo.com", "outlook.com");
        if (validDomains.contains(email.substring(email.indexOf("@") + 1))) {
            return true;
        }
        return false;
    }

    public boolean validateInt(String input) {
        if (sc.hasNextInt())
            return true;
        else 
            return false;
    }
}
