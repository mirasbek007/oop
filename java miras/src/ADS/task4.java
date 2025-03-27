package ADS;
import java.util.Scanner;
public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            System.out.println("Factorial of " + n + " is: " + factorial(n));
        }
        scanner.close();
    }
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}



