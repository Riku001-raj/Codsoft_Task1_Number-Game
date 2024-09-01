import java.util.Random;
import java.util.Scanner;
    
    public class NumberGuessingGame {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            boolean playAgain = true;
            int totalScore = 0;
    
            while (playAgain) {
                int numberToGuess = random.nextInt(100) + 1;
                int numberOfAttempts = 0;
                int maxAttempts = 7;
                boolean hasGuessedCorrectly = false;
    
                System.out.println("Welcome to the Number Guessing Game!");
                System.out.println("I have selected a number between 1 and 100.");
                System.out.println("You have " + maxAttempts + " attempts to guess it.");
    
                while (numberOfAttempts < maxAttempts && !hasGuessedCorrectly) {
                    System.out.print("Enter your guess: ");
                    
                    // Input validation
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter an integer between 1 and 100.");
                        scanner.next(); // Discard the invalid input
                    }
    
                    int userGuess = scanner.nextInt();
                    numberOfAttempts++;
    
                    if (userGuess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the correct number.");
                        hasGuessedCorrectly = true;
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                }
    
                if (!hasGuessedCorrectly) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
                }
    
                totalScore += hasGuessedCorrectly ? maxAttempts - numberOfAttempts + 1 : 0;
    
                System.out.println("Your score for this round is: " + (hasGuessedCorrectly ? maxAttempts - numberOfAttempts + 1 : 0));
                System.out.println("Attempts taken: " + numberOfAttempts);
                System.out.println("Total Score: " + totalScore);
    
                System.out.print("Do you want to play another round? (yes/no): ");
                String response = scanner.next();
                playAgain = response.equalsIgnoreCase("yes");
            }
    
            System.out.println("Thank you for playing! Your final score is: " + totalScore);
            scanner.close();
        }
        
    }
      
    

