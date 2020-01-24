package test;

import java.util.Scanner;

public class test12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter something random: ");
		String random = scan.nextLine();
		System.out.println("Reversed string is: " + reverse(random));
		scan.close();
		//teachers solution:
		
		int input;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number to reverse");
		input = sc.nextInt();
		System.out.println(getReverseInt(input));
		sc.close();
	}
	
	private static String reverse(String reversable){
		String result = "";
		int length = reversable.length();
		for(int i = length-1; i >= 0; i--){
			result = result + reversable.charAt(i);
		}
		
		return result;
	}
	
	//Teachers solution
	
	public static int getReverseInt(int value){
		int resultNumber = 0;
		for(int i = value; i != 0; i/=10){
			resultNumber = resultNumber * 10 + i % 10;
		}
		return resultNumber;
	}

}
