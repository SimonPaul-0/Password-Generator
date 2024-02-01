import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

    public static String generatePassword(int length, boolean useUppercase, boolean useDigits, boolean useSpecialChars) {
        StringBuilder characters = new StringBuilder(LOWERCASE_CHARS);

        if (useUppercase) {
            characters.append(UPPERCASE_CHARS);
        }
        if (useDigits) {
            characters.append(DIGITS);
        }
        if (useSpecialChars) {
            characters.append(SPECIAL_CHARS);
        }

        if (characters.length() == 0) {
            System.out.println("Error: No character set selected.");
            return null;
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUppercase = scanner.next().toLowerCase().equals("y");

        System.out.print("Include digits? (y/n): ");
        boolean useDigits = scanner.next().toLowerCase().equals("y");

        System.out.print("Include special characters? (y/n): ");
        boolean useSpecialChars = scanner.next().toLowerCase().equals("y");

        String password = generatePassword(length, useUppercase, useDigits, useSpecialChars);

        if (password != null) {
            System.out.println("Generated Password: " + password);
        }
    }
}
