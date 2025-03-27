package ADS;
import java.util.Scanner;
public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (n): ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Fibonacci is not defined for negative numbers.");
        } else {
            System.out.println("The " + n + "-th Fibonacci number is: " + fibonacci(n));
        }

        scanner.close();
    }
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}


