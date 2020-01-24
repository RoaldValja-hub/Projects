package test;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ask the user 2 numbers
		// produce mathematics outputs
		double first, second;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter two numbers for mathematics magic!");
		first = scan.nextDouble();
		second = scan.nextDouble();
		System.out.println(first + " * " + second + " = " + (first * second));
		try {
			System.out.println(first + " / " + second + " = " + (first / second));
		} catch (Exception e) {
			System.out.println("Do not divide by 0");
		}
		System.out.println(first + " + " + second + " = " + (first + second));
		System.out.println(first + " - " + second + " = " + (first - second));
		System.out.println(first + " % " + second + " = " + (first % second));
		
		
		int firsta, seconda;
		//Scanner scan = new Scanner(System.in);
		System.out.println("Enter two numbers for mathematics magic!");
		firsta = scan.nextInt();
		seconda = scan.nextInt();
		System.out.println(firsta + " * " + seconda + " = " + (firsta * seconda));
		try {
			System.out.println(firsta + " / " + seconda + " = " + (firsta / seconda));
			//throw new ArithmeticException();
		} catch (ArithmeticException e) {
			System.out.println("Do not divide by 0");
		}
		System.out.println(firsta + " + " + seconda + " = " + (firsta + seconda));
		System.out.println(firsta + " - " + seconda + " = " + (firsta - seconda));
		try {
			System.out.println(firsta + " % " + seconda + " = " + (firsta % seconda));
		} catch (ArithmeticException e) {
			System.out.println("Do not reminder by 0");
		}
		//teachers solution
		/*
		double num1, num2, sum, sub, mult, div, rem;
		DecimalFormat df = new DecimalFormat()
		*/
		
		//next exercise
		
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
		
	}

}
