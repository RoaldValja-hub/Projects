package test;

public class test13 {
	public static void main(String[] args) {
		int marks [] = {50, 70, 90, 10};
		System.out.println("Array Elements are: ");
		for (int x:marks){
			if(x==90){
				continue;
			}
			System.out.println(x);
		}
	}
}
