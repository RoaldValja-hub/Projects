package test;

import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int days, hours/*, minutes*/;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an amount of days: ");
		/*
		days = scan.nextInt();
		hours = days*24;
		minutes = hours*60;
		*/
		days = scan.nextInt();
		double minutes = (double)days * (24*60);
		System.out.println("The amount of minutes in entered days is: " + minutes);
	}

}
