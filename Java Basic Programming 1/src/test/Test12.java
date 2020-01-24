package test;

import java.util.Scanner;

public class Test12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * ?: is a ternary	ex:	Condition?true:false;
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your Age: ");
		int age = scan.nextInt();
		int Minor=18;
		
		if(age < Minor){
			System.out.println("Youth is a wonderful thing. Enjoy.");
		}
		else{
			System.out.println("Age is a state of mind");
		}
		
		System.out.println("Enter a month number: ");
		int month = scan.nextInt();
		if(1 <= month && month <= 3)
		{
			System.out.println("This is the first quarter");
		} 
		else if(4 <= month && month <= 6)
		{
			System.out.println("This is the second quarter");
		} 
		else if(month < 1 || month > 12)
		{
			System.out.println("There is no such month");
		}
		else
		{
			System.out.println("This is the last half");
		}
		
		System.out.println("Enter a grade that is between 0 and 10");
		int grade = scan.nextInt();
		
		if(grade >= 0 && grade <= 4)
		{
			System.out.println("You have indominably failed");
		}
		else if(grade == 5)
		{
			System.out.println("You have done not good nor bad, just ok");
		}
		else if(grade == 6)
		{
			System.out.println("I guess you have done good");
		}
		else if(grade >= 7 && grade <= 8)
		{
			System.out.println("Congratulations, you have done fine");
		}
		else if(grade == 9)
		{
			System.out.println("You were almost there!");
		}
		else if(grade == 10)
		{
			System.out.println("You actually got excellent score, Congratulations, the cake was a lie!");
		}
		else
		{
			System.out.println("What kind of alien grade are you typing boy");
		}

		System.out.println("Enter a grade that is between 0 and 100");
		int grade2 = scan.nextInt();
		int category = grade2 / 10;
		System.out.println("That grade is ");
		switch (category)
		{
		case 10:
			System.out.println("a perfect score. Well done.");
			break;
		case 9:
			System.out.println("well above average. Excellent.");
			break;
		case 8:
			System.out.println("above average. Nice job.");
			break;
		case 7:
			System.out.println("average.");
			break;
		case 6:
			System.out.println("below average. You should see the");
			System.out.println("instructor to clarify the material "
					 + "presented in class.");
			break;
		default:
			System.out.println("not passing.");
		}
	}

}
