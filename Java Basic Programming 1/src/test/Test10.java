package test;

public class Test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String phrase = "Change is inevitable";
		String mutation1, mutation2, mutation3, mutation4;
		System.out.println("original string: \"" + phrase + "\"");
		System.out.println("length of string: " + phrase.length());
		
		
		mutation1 = phrase.concat(", except from vending machines.");
		mutation2 = mutation1.toUpperCase();
		mutation3 = mutation2.replace('E', 'X');
		mutation4 = mutation3.substring(3, 30);
		System.out.println("mutation #1: " + mutation1);
		System.out.println("mutation #2: " + mutation2);
		System.out.println("mutation #3: " + mutation3);
		System.out.println("mutation #4: " + mutation4);
		System.out.println("Mutation Length: " + mutation4.length());
	}

}
