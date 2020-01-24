package test;

import java.math.BigInteger;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello There!");
		
		String name = "Roald";
		String company = "TTU";
		
		System.out.println(name + " is an employee of " + company);
		System.out.println("The addition is: " + 5 + 5);
		System.out.println("The addition is: " + (5 + 5));
		
		name = "Jack";
		System.out.println(name);
		
		int side = 10;
		System.out.println(side * 2);
		System.out.println(side / 2);
		System.out.println(side * 2+22/3);
		
		int a = 3;
		int b = 7;
		int c = 2;
		
		float rand = (float) 2.4; // casting or converting
		float rand2 = 2.4f;
		rand = (float) 5.5;
		System.out.println(rand * 2);
		
		
		System.out.println(a+b*c+a*a+c+b*c*b*a*a*a*a*b*b*b*c*c*c*a*b*b*c*b*c*a*a);
		
		int intA = 7;
		int intB = 2;
		int intC = 9;
		
		BigInteger bigA = BigInteger.valueOf(7);
		BigInteger bigB = BigInteger.valueOf(2);
		BigInteger bigC = BigInteger.valueOf(9);
		
		Test2 test = new Test2();
		
		test.integerMultiplication(intA, intB, intC);
		test.bigIntegerMultiplication(bigA, bigB, bigC);
	}
	
	public void integerMultiplication(int a, int b, int c){
		System.out.println(a+b*c+a*a+c+b*c*b*a*a*a*a*b*b*b*c*c*c*a*b*b*c*b*c*a*a);
	}
	public void bigIntegerMultiplication(BigInteger a, BigInteger b, BigInteger c){
		System.out.println(a.add(b).multiply(c).add(a).multiply(a).add(c).add(b).multiply(c).multiply(b)
				.multiply(a).multiply(a).multiply(a).multiply(a).multiply(b).multiply(b).multiply(b)
				.multiply(c).multiply(c).multiply(c).multiply(a).multiply(b).multiply(b).multiply(c)
				.multiply(b).multiply(c).multiply(a).multiply(a));
		System.out.println(a.add(b).multiply(c));
		
	}

}
