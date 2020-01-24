package test;

import java.util.Scanner;

public class Test14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number ");
		x = scan.nextDouble();
		System.out.println("The square route of "+ x +" is " + Math.sqrt(x));
		System.out.println(x+" raised to the power of 2 is "+ Math.pow(x, 2));
		
		int maximumHours = 40;
		int salary = 10;
		int bonus = 100;
		System.out.println("Enter a number of hours worked: ");
		int worked = scan.nextInt();
		if(worked < maximumHours){
			System.out.println("Salary is " + (worked * salary));
		}else{
			System.out.println("Salary is " + (worked * salary + bonus));
		}
		
		// teachers solution
		
		System.out.println("Enter hours of work: ");
		int hours = scan.nextInt();
		int standard;
		double rate, pay;
		pay = 0.0; rate=8.25; standard = 40;
		
		if(hours > standard)
		{
			pay = standard * rate + (hours - standard) * (rate* 1.5);
			System.out.println("Your earning is" + pay + " Euros");
		}
		else
		{
			pay = hours * rate;
			System.out.println("Gross earnings: " + pay + " Euros");
		}
		
		System.out.println("Enter three numbers: ");
		int first, second, third;
		first = scan.nextInt();
		second = scan.nextInt();
		third = scan.nextInt();
		
		
		int [] nums = {first, second, third};
		
		int lowest;
		lowest = nums[0];
		for(int i = 1; i < nums.length; i++){
			if(nums[i] < lowest){
				lowest = nums[i];
			}
		}
		System.out.println("Lowest number was: " + lowest);
		
		//Teachers solution
		
		int num1, num2, num3, min;
		min = 0;
		System.out.print("Enter three integers: ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		num3 = scan.nextInt();
		if (num1 < num2)
		{
			if (num1 < num3)
				min = num1;
			else
				min = num3;
		}
		else if (num2 < num3)
		{
			min = num2;
		}
		else 
		{
			min = num3;
		}
		System.out.println("Minimum value: " + min);
	}

}
