package ADS;
import java.util.Scanner;
public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        if (n <= 1) {
            System.out.println("Neither Prime nor Composite");
        } else if (isPrime(n)) {
            System.out.println("Prime");
        } else {
            System.out.println("Composite");
        }
        scanner.close();
    }
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}


