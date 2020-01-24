package test3;

public class Employee {
	public String name;
	public double wage;
	
	Employee(){
		this.name = "Volunteer"; // this keyword means refer to the current object
		this.wage = 0.0;
	}
	
	Employee(String name1, double wage1){
		name = name1;
		wage = wage1;
	}
	
	String getName(){
		return name;
	}
	
	double getWage(){
		return wage;
	}
}
