package test;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		while(x < 10){
			System.out.println("Hola");
			x++;
		}
		
		int y = 0;
		do {
			System.out.println("Hola");
			y++;
		}while(y<10);
		
		int i = 1;
		System.out.println("First 20 numbers are:");
		for(i=1;i<=20;i++){
			System.out.println(+i);
		}
		i = 1;
		System.out.println("Table of 2:");
		for(i=1;i<=20;i++){
			if(i%2==0){
				System.out.println("\t"+i);
			}
		}
		
		//enhanced for loop
		
		int marks[] = {50, 70, 90, 10};
		System.out.println("Array Elements are: ");
		for(int z:marks){
			System.out.println(z);
		}
		System.out.println("Array length is: " + marks.length);
		for(i=0;i<marks.length;i++){
			System.out.println(marks[i]);
		}
	}

}
