package test;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double base, height, area;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Base of Rectangle: ");
		base = scan.nextDouble();
		System.out.print("Enter the Height of Rectangle: ");
		height = scan.nextDouble();
		
		area = base*height;
		
		System.out.print("The area is: " + area);
	}

}
