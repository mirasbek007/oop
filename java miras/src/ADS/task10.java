package ADS;
import java.util.Scanner;
public class task10 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two numbers (a b): ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("GCD(" + a + ", " + b + ") = " + gcd(a, b));
        scanner.close();
    }
}

