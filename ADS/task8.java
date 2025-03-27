package ADS;
import java.util.Scanner;
public class task8 {
    public static boolean isAllDigits(String s, int index) {
        if (index == s.length()) {
            return true;
        }
        if (!Character.isDigit(s.charAt(index))) {
            return false;
        }
        return isAllDigits(s, index + 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        boolean result = isAllDigits(s, 0);
        System.out.println(result ? "Yes" : "No");

        scanner.close();
    }
}
