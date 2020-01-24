package test;

import java.util.*;
public class Test5 {

	public static void main(String[] args){
		int number, number1, number2;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a number");
		number = scan.nextInt();
		System.out.println("You entered :" + number);
		
		System.out.println("Please enter first number");
		number1 = scan.nextInt();
		System.out.println("Please enter second number");
		number2 = scan.nextInt();
		
		int addition = number1 + number2;
		int multiplication = number1 * number2;
		int division = number1 / number2;
		int subtraction = number1 - number2;
		int modulus = number1 % number2;
		
		System.out.println("Entered addition is :" + addition);
		System.out.println("Entered subtraction is :" + subtraction);
		System.out.println("Entered multiplication is :" + multiplication);
		System.out.println("Entered division is :" + division);
		System.out.println("Entered modulus is :" + modulus);
		
		
		
	}
}
