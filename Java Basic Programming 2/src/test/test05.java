package test;

import java.util.Scanner;

public class test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		int i = 0;
		int something;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insert your number");
		number = sc.nextInt();
		sc.close();
		
		for(int j = 1; j < number + 1; j++){
			for(int k = 1; k < 11; k++){
				something = k * j;
				System.out.println(k + "x" + j + "=" + something);
			}
		}
		something = 1;
		while(i < number){
			something *= number - i;
			i++;
		}
		i=0;
		while(number!=0){
			if(number % 2 == 0){
				System.out.print(number + "\t");
			}
			number--;
		}
		System.out.println("Factorial: " + something);
	}

}
