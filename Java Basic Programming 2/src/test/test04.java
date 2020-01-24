package test;

import java.util.Scanner;

public class test04 {

	public static int sum(int a, int b){
		int sum = a + b;
		return sum;
	}

	public static int sub(int a, int b){
		int sub = a - b;
		return sub;
	}
	
	public static int div(int a, int b){
		int div = 0;
		try{
			div = a / b;
		}catch(ArithmeticException e){
			System.out.println("You divided by zero");
		}
		
		return div;
	}
	
	public static float div2(float a, float b){
		float div = 0;
		try{
			div = a / b;
		}catch(ArithmeticException e){
			System.out.println("You divided by zero");
		}
		
		return div;
	}
	
	public static int mul(int a, int b){
		int mul = a * b;
		return mul;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c;
		boolean condition = true;
		Scanner scan = new Scanner(System.in);
		while(condition){
			System.out.println("Enter the first number: ");
			a = scan.nextInt();
			System.out.println("Enter the first number: ");
			b = scan.nextInt();
			System.out.println("Enter a command number: ");
			System.out.println("Enter 1 for addition");
			System.out.println("Enter 2 for subtraction");
			System.out.println("Enter 3 for division");
			System.out.println("Enter 4 for multiplication");
			System.out.println("Enter 5 for division with floats");
			System.out.println("Enter 0 to exit");
			c = scan.nextInt();
			if(c == 1){
				System.out.println(sum(a, b));
			} else if(c == 2){
				System.out.println(sub(a, b));
			} else if(c == 3){
				System.out.println(div(a, b));
			} else if(c == 4){
				System.out.println(mul(a, b));
			} else if(c == 0){
				condition = false;
			} else if(c == 5){
				System.out.println(div2((float) a, b));
			} else{
				System.out.println("You gave the wrong command");
			}
		}
		
	}

}
