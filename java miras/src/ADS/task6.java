package ADS;
import java.util.Scanner;
public class task6 {
    public static double power(double a, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / power(a, -n);
        }
        return a * power(a, n - 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter base (a): ");
        double a = scanner.nextDouble();
        System.out.print("Enter exponent (n): ");
        int n = scanner.nextInt();
        double result = power(a, n);
        System.out.println(a + "^" + n + " = " + result);

        scanner.close();
    }
}


