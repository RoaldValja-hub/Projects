package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class test07 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//File file = new File("D:\\javaprogrammeerimine\\Lõputöö\\Java Basic Programming 2\\src\\readingFile.txt");

		String path = "D:\\javaprogrammeerimine\\Lõputöö\\Java Basic Programming 2\\src\\writingFile.txt";
		BufferedWriter file = new BufferedWriter(new FileWriter(path));
		
		file.write("Something is needed or maybe not.");
		file.append(" Hey, theres more");
		file.newLine();
		for(int i=0;i<30;i++){
			for(int j=0; j<i; j++){
				file.write("#");
			}
			file.newLine();
		}
		/*
		for(int i=0;i<10;i++){
			for(int j=i; j<10; j++){
				file.write(" ");
			}
			file.write("#");
			file.newLine();
		}
		*/
		/*
		for(int i=10;i>0;i--){
			
			for(int j=i; j<10; j++){
				file.write(" ");
			}
			file.write("#");
			file.newLine();
		}
		*/
		file.close();
		
		System.out.println("File created!");
	}

}
