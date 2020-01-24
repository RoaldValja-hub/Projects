package test;

import java.util.Scanner;

public class test03 {

	public static int sum(int num1, int num2){
		int sum;
		sum = num1 + num2;
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		Scanner scan = new Scanner(System.in);
		System.out.println("Give me first number!");
		a = scan.nextInt();
		System.out.println("Give me second number!");
		b = scan.nextInt();
		
		System.out.println("the addition is: " + sum(a,b));
		scan.close();
	}

}
