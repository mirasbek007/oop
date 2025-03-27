package ADS;
import java.util.Scanner;
public class task2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        double sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        double average = sum / n;
        System.out.println("The average is: " + average);

        scanner.close();
    }
}


