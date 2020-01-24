package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class test08 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String [] randomArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "!", "\"", "#", "¤"};
		String path = "D:\\javaprogrammeerimine\\Lõputöö\\Java Basic Programming 2\\src\\writingFile2.txt";
		BufferedWriter file = new BufferedWriter(new FileWriter(path));
		
		file.write("Randomly generated password:");
		file.newLine();
		
		String password = "";
		for(int i=0; i<50;i++){
			double character = Math.random()*randomArray.length;
			int position = (int)character;
			password = password + randomArray[position];
		}
		file.write(password);
		file.close();
		System.out.println("Password generated");
		
		System.out.println(generatePassword());
	}
	
	//teachers solution:
	
	public static String generatePassword(){
		Random r [] = new Random[8];
		r[0] = new Random();
		r[1] = new Random();
		r[2] = new Random();
		r[3] = new Random();
		r[4] = new Random();
		r[5] = new Random();
		r[6] = new Random();
		r[7] = new Random();
		Random x = new Random();
		StringBuilder password = new StringBuilder();
		int length = 6;
		password.setLength(length);
		for(int i = 0; i < length; i++){
			x.setSeed(r[i % 8].nextInt(500) * r[4].nextInt(900));
			//setSeed allows you to initialize the random number generator
			password.setCharAt(i, (char) (r[x.nextInt(256) % 8].nextInt(95) + 32));
		}
		return password.toString();
	}

}
