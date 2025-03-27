package ADS;

import java.util.Scanner;

public class task9 {
    public static int binomialCoeff(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k); // Recursive formula
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.print("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("C(" + n + ", " + k + ") = " + binomialCoeff(n, k));

        scanner.close();
    }
}
