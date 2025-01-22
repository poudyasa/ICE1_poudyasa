package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card and a hard-coded lucky card.
 * @author poudyasa
 * @modifier Sarbesh Poudyal, 991759934
 */
public class CardTrick {

    public static void main(String[] args) {
        // Create an array to hold the magic hand of 7 cards
        Card[] magicHand = new Card[7];
        
        // Fill the array with random Card objects
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue((int) (Math.random() * 13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[(int) (Math.random() * 4)]); // Random suit
            magicHand[i] = c;
        }

        // Add a luckyCard with a predefined value and suit
        Card luckyCard = new Card();
        luckyCard.setValue(8);
        luckyCard.setSuit("Hearts"); 

        // Display the magic hand
        System.out.println("\nMagic Hand:");
        for (Card c : magicHand) {
            System.out.println("Card: " + c.getValue() + " of " + c.getSuit());
        }

        // Ask the user for a card
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the card value (1-13): ");
        int userValue = input.nextInt();
        System.out.print("Enter the card suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = input.next();

        // Create the user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

      
        boolean userFound = false;
        boolean luckyFound = false;
        
        for (Card c : magicHand) {
            if (c.getValue() == userCard.getValue() && c.getSuit().equals(userCard.getSuit())) {
                userFound = true;
            }
            if (c.getValue() == luckyCard.getValue() && c.getSuit().equals(luckyCard.getSuit())) {
                luckyFound = true;
            }
        }

        // Reporting the results for the user's card
        if (userFound) {
            System.out.println("\nCongratulations! Your card (" + userValue + " of " + userSuit + ") is in the magic hand.");
        } else {
            System.out.println("\nSorry, your card (" + userValue + " of " + userSuit + ") is not in the magic hand.");
        }

        // Reporting the result for the lucky card
        if (luckyFound) {
            System.out.println("Congratulations! The lucky card (" + luckyCard.getValue() + " of " + luckyCard.getSuit() + ") is in the magic hand.");
        } else {
            System.out.println("Sorry, the lucky card (" + luckyCard.getValue() + " of " + luckyCard.getSuit() + ") is not in the magic hand.");
        }
    }
}
