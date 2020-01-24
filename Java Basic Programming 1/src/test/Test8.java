package test;

import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String firstName, lastName, fullName;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your first name: ");
		firstName = scan.nextLine();
		System.out.println("Please enter your last name: ");
		lastName = scan.nextLine();
		Test8 test = new Test8();
		firstName = test.firstLetterUpperCase(firstName);
		lastName = test.firstLetterUpperCase(lastName);
		fullName = firstName + " " + lastName;
		System.out.println("Your full name is: \"" + fullName + "\"");
	}
	
	public String firstLetterUpperCase(String toUpper){
		String firstLetter = toUpper.substring(0,1);
		firstLetter = firstLetter.toUpperCase();
		String rest = toUpper.substring(1);
		String result = firstLetter + rest;
		return result;
	}
	
}
