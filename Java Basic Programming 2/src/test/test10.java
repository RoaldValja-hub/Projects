package test;

import java.util.Scanner;

public class test10 {

	private static int scanning(){
		Scanner Scan = new Scanner(System.in);
		int Num = Scan.nextInt();
		return Num;
	}
	private static int calcsum(int x, int y, String sign){
		if(sign.equals("+")){
			return x+y;
		}
		return 0;
	}
	private static int calcsub(int x, int y){
		return x-y;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter value1: ");
		System.out.println("Please enter value2: ");
		int value1 = scanning();
		int value2 = scanning();
		int sum = calcsum(value1, value2, "+");
		System.out.print(sum);
	}

}
