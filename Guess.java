//Programmer(s): John Bedlington and Michael Woo
//Date: 1/9/2023
//Class: CS &141
//Assignment: Lab 1
//This program will make a guessing game where the user has to guess a number between 1 and n. It will also display game results at the end.

import java.util.Scanner;
import java.util.Random;

public class Guess {
       
	final static int MAX = 100;
	public static void main(String[] args) {
      
		Scanner input = new Scanner(System.in);

		int numTries = 0;
		int totalNumTries = 0;
		int best = 0;
		int totalGames = 0;
		String ask = "y";

		intro();

		while(ask.substring(0,1).equalsIgnoreCase("y")) {

			totalGames++;
			numTries = playGame(input);
			totalNumTries += numTries;

			if(numTries < best || totalGames == 1) {

				best = numTries;
			}

			System.out.print("do you want to play again? ");
			ask = input.next();
			System.out.println();

			if(Character.toLowerCase(ask.charAt(0)) == 'n') {

				results(totalNumTries, best, totalGames);
			}
		}
	} 
     
    //Introduces player to the rules of the guessing game  
   	public static void intro() {
       		
		System.out.println("This program allows you to play a guessing game.");
   	  	System.out.println("I will think of a number between 1 and");
   	  	System.out.println("100 and will allow you to guess until");
   	  	System.out.println("you get it. For each guess, I will tell you");
   	  	System.out.println("whether the right answer is higher or lower");
   	  	System.out.println("than your guess.");
   	  	System.out.println();
          
   	} 
   
   	//play one round of the guessing game
   	public static int playGame(Scanner input) { 
    	  
		int numTries = 0;
		int guess = 0;

		Random rand = new Random();
		int randomNumber = rand.nextInt(MAX) + 1; 

		System.out.println("I'm thinking of a number between 1 and " + MAX + "...");          

		while (guess != randomNumber) {

			numTries++;
			System.out.print("Your guess? ");
			guess = input.nextInt();

			if (guess > randomNumber) {

				System.out.println("It's lower.");

			} 

				else if (guess < randomNumber){ 

					System.out.println("It's higher.");
				}

		} 

		if(numTries == 1) {

			System.out.printf("You got it right in %d guess%n", numTries);
			return numTries;
		}

		else {

			System.out.printf("You got it right in %d guesses%n", numTries);
			return numTries;
		}
   	}	 
	//Prints results of the guessing game
   	public static void results(int totalNumTries, int best, int totalGames) {
   	
		double guessOverGame = (totalNumTries + 0.0) / (totalGames + 0.0);
   	
		System.out.println("Overall results:");
		System.out.println("   total games   = "+ totalGames);
		System.out.println("   total guesses = " + totalNumTries);
		System.out.printf("   guesses/game  = %.1f%n", guessOverGame);
		System.out.println("   best game     = " + best);

   	}   
} 
