import java.util.InputMismatchException;
import java.util.Scanner;

public class PerfectNumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter a positive integer: ");
            try {
                number = scanner.nextInt();

                if (number <= 0) {
                    System.out.println("Error: Please enter a number greater than zero.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a whole number.");
                scanner.next();
            }
        }

        long sumOfDivisors = 1;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sumOfDivisors += i;
            }
        }

        System.out.println("\n--- Result ---");
        System.out.println("The number you entered is: " + number);
        System.out.println("Sum of its proper divisors is: " + sumOfDivisors);

        if (sumOfDivisors == number) {
            System.out.println(number + " IS a perfect number!");
        } else {
            System.out.println(number + " IS NOT a perfect number.");
        }

        scanner.close();
    }
}
