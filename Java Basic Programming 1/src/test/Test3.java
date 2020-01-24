package test;

public class Test3 {

	public static void main(String[] args) {
		int iResult, num1 = 25, num2 = 40, num3 = 17, num4 = 5;
		double fResult, val1 = 17.0, val2 = 12.78;
		
		int value = 10;
		value = value + 1;
		value += 1;
		value++;
		++value;
		
		value = value - 1;
		value -= 1;
		value--;
		--value;
		
		/*
		 * * multiplication
		 * / division
		 * addition +
		 * subtraction -
		 * % modulus or remainder
		 */
		
		String iResultT = "the iResult value is: ";
		String fResultT = "the fResult value is: ";
		
		iResult = num1 / num4;
		System.out.println(iResultT + iResult);
		fResult = num1 / num4;
		System.out.println(fResultT + fResult);
		iResult = num3 / num4;
		System.out.println(iResultT + iResult);
		fResult = num3 / num4;
		System.out.println(fResultT + fResult);
		fResult = val1 / num4;
		System.out.println(fResultT + fResult);
		fResult = (double) num1 / num2;
		System.out.println(fResultT + fResult);
		fResult = num1 / (double) num2;
		System.out.println(fResultT + fResult);
		fResult = (double) (num1 / num2);
		System.out.println(fResultT + fResult);
		iResult = (int) (val1 / num4);
		System.out.println(iResultT + iResult);
		fResult = (int) (val1 / num4);
		System.out.println(fResultT + fResult);
		fResult = (int) ((double) num1 / num2);
		System.out.println(fResultT + fResult);
		iResult = num3 % num4;
		System.out.println(iResultT + iResult);
		iResult = num2 % num3;
		System.out.println(iResultT + iResult);
		iResult = num3 % num2;
		System.out.println(iResultT + iResult);
		iResult = num2 % num4;
		System.out.println(iResultT + iResult);
	}
}
