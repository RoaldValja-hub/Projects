package test;

import java.util.Random;
import java.util.Scanner;

public class Test13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rand = (int)(Math.random()*10);
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number between 0 and 10: ");
		/*int guess = scan.nextInt();
		if(guess == rand){
			System.out.println("You guessed right, the random number was: " + rand);
		}
		else
		{
			System.out.println("You guessed wrong, the random number was: " + rand);
		}
		*/
		int guesses = 1;
		while(true){
			int guess = scan.nextInt();
			if(guess == rand){
				System.out.println("You guessed right, the random number was: " + rand);
				System.out.println("It took you " + guesses + " guesses!");
				break;
			}
			else{
				System.out.println("You guessed wrong, guess again!: ");
				guesses++;
			}
		}
		// teachers solution
		
		int MAX, answer, guess;
		MAX = 10;
		Random generator = new Random();
		answer = generator.nextInt(MAX) + 1;
		System.out.println("I'm thinking of a number between 1 and " + MAX + ". Guess what it is:");
		guess = scan.nextInt();
		if(guess == answer)
		{
			System.out.println("You got it! Good guessing!");
		}
		else
		{
			System.out.println("That is not correct, sorry.");
			System.out.println("The number was " + answer);
		}
	}

}
