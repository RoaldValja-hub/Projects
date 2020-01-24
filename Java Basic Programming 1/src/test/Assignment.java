package test;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Assignments:
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		Assignment assignment = new Assignment();
		
		double area, circumference;
		System.out.println("Please enter Radious");
		int radious = scan.nextInt();
		area = Math.PI * Math.pow(radious, 2);
		circumference = 2 * Math.PI * radious;
		DecimalFormat fmt = new DecimalFormat("#.###");
		fmt.format(area);
		fmt.format(circumference);
		System.out.println(" Area is: " + area);
		System.out.println(" circumference is: " + circumference);
		
		System.out.println("Enter two numbers: ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		System.out.println("The larger number of the two entered is " + assignment.MaxOfTwo(num1, num2));
		
		System.out.println("Enter a number between 1 and 5: ");
		int numToWord = scan.nextInt();
		String wordedNumber = null;
		switch(numToWord)
		{
		case 5:
			wordedNumber = "five";
			break;
		case 4:
			wordedNumber = "four";
			break;
		case 3:
			wordedNumber = "three";
			break;
		case 2:
			wordedNumber = "two";
			break;
		case 1:
			wordedNumber = "one";
			break;
		}
		System.out.println("User entered number " + wordedNumber);
		
	}
	
	public int MaxOfTwo(int one, int two){
		if(one > two)
		{
			return one;
		}
		else
		{
			return two;
		}
	}
	
	public boolean Divisible(int par1, int par2){
		if(par2 == 0){
			return false;
		}
		try {
			//System.out.println(firsta + " / " + seconda + " = " + (firsta / seconda));
			//throw new ArithmeticException();
			if(par1 / par2 > 0);
		} catch (ArithmeticException e) {
			System.out.println("Do not divide by 0");
			return false;
		}
		return true;
	}

}
