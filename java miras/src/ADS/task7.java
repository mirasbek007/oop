package ADS;
import java.util.Scanner;
public class task7 {
        public static void reversePrint(int n, Scanner scanner) {
            if (n == 0) {
                return;
            }

            int num = scanner.nextInt();
            reversePrint(n - 1, scanner);
            System.out.print(num + " ");
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number of elements (n): ");
            int n = scanner.nextInt();
            System.out.println("Enter the elements one by one:");
            reversePrint(n, scanner);
            scanner.close();
        }
    }


