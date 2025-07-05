package ugandawordcounter;
import java.util.Scanner;

public class UgandaWordCounter {

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.println("Hello Librarian!");
        System.out.println("Please enter the book description:");

        String bookDescription = inputReader.nextLine();

        String lowerCaseDescription = bookDescription.toLowerCase();

        String targetWord = "uganda";

        int count = 0;

        String[] words = lowerCaseDescription.split("\\W+");

        for (String word : words) {
            if (word.equals(targetWord)) {
                count++;
            }
        }

        System.out.println("\n--- Counting Complete ---");
        System.out.println("The word '" + targetWord + "' appears " + count + " time(s) in the description.");

        inputReader.close();
    }
}


