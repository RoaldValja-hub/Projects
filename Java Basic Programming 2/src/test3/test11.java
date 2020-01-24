package test3;

import java.util.Scanner;

public class test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the name1: ");
		String name1 = scan.nextLine();
		
		System.out.println("Please specify the wage: ");
		double wage1 = scan.nextDouble();
		
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Please enter the name2: ");
		String name2 = scan2.nextLine();
		
		System.out.println("Please specify the wage: ");
		double wage2 = scan2.nextDouble();
		
		Employee e = new Employee(name1, wage1);
		System.out.println("name of employee is: " + e.getName());
		System.out.println("Wage is : " + e.getWage());
		
		Employee e2 = new Employee(name2, wage2);
		System.out.println("name of employee is: " + e2.getName());
		System.out.println("Wage is : " + e2.getWage());
		
		
	}

}
