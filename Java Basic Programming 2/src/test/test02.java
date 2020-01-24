package test;

import java.util.Scanner;

public class test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		int b = 0;
		int c = 0;
		try {
			c = a / b;
		} catch(ArithmeticException e){
			System.out.println("Did you divide by zero??");
		} catch(Exception e){
			System.out.println("You got an error:" + e);
		} finally{
			System.out.println("Catch block over!");
		}
		System.out.println(c);
		
		Scanner scan = new Scanner(System.in);
		test02 test = new test02();
		String question;
		int month;
		boolean doLoop = true;
		while(doLoop){
			question = scan.nextLine();
			if(question.equals("quit")){
				doLoop = false;
			} else{
				//month = Integer.parseInt(question);
				try{
					test.isMonth(Integer.parseInt(question));
				} catch(NumberFormatException e){
					
				}catch(ArithmeticException e){
					System.out.println(e);
				}
			}
			
			
			/*
			if(month == "quit"){
				break;
			}
			*/
		}
		
		int d = -5;
		
		try{
			test.isMonth(d);
		} catch(ArithmeticException e){
			System.out.println(e);
		}
		
		//teachers solution:
		
		String birthMonth;
		boolean condition = true;
		Scanner sc = new Scanner(System.in);
		String numbers[] = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve"};
		
		while(condition){
			System.out.println("What is your birth month?(1-12)");
			birthMonth = sc.nextLine();
			try{
				birthMonth = numbers[Integer.parseInt(birthMonth)-1];
			}catch(NumberFormatException e){
				
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("This month does not exist");
			}
			switch(birthMonth){
			case "one":
				System.out.println("You we're born in January");
				break;
			case "two":
				System.out.println("You we're born in February");
				break;
			case "three":
				System.out.println("You we're born in March");
				break;
			case "four":
				System.out.println("You we're born in April");
				break;
			case "five":
				System.out.println("You we're born in May");
				break;
			case "six":
				System.out.println("You we're born in June");
				break;
			case "seven":
				System.out.println("You we're born in July");
				break;
			case "eight":
				System.out.println("You we're born in August");
				break;
			case "nine":
				System.out.println("You we're born in September");
				break;
			case "ten":
				System.out.println("You we're born in October");
				break;
			case "eleven":
				System.out.println("You we're born in November");
				break;
			case "twelve":
				System.out.println("You we're born in December");
				break;
			case "quit":
				System.out.println("Ok, Goodbye");
				condition = false;
				break;
			default: 
				System.out.println("Invalid input");
				break;
			}
		}
		sc.close();
	}
	public void isMonth(int month){
		if(month < 0 || month > 12){
			throw new ArithmeticException("This aint a month!");
		} else {
			System.out.println("It's a month");
		}
	}

}
