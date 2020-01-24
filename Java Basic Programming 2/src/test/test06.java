package test;

import java.io.*;

public class test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:\\javaprogrammeerimine\\Lõputöö\\Java Basic Programming 2\\src\\readingFile.txt");
		BufferedInputStream bis = null;
		FileInputStream fis = null;
		try{
			//fileinputstream to read the file
			fis = new FileInputStream(file);
			//for fast read using buffer array
			bis = new BufferedInputStream(fis);
			while(bis.available() > 0){
				System.out.print((char)bis.read());
			}
		}
		catch(FileNotFoundException fnfe){
			System.out.println("The specified file not found" + fnfe);
		}
		catch(IOException ioe){
			System.out.println("I/O Exception: " + ioe);
		}
		finally
		{
			try{
				if(bis != null && fis != null){
					fis.close();
					bis.close();
				}
			}
			catch(IOException ioe){
				System.out.println("Error in InputStream close(): " + ioe);
			}
		}
	}
}


