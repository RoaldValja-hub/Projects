package test;

public class Test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Multidimensional arrays
		
		int box [][] = new int [4][4];
		
		box[0][0] = 6;
		box[0][1] = 2;
		box[0][2] = 15;
		box[0][3] = 7;
		box[1][0] = 666;
		box[1][1] = 69;
		box[1][2] = 41;
		box[1][3] = 2;
		box[2][0] = 0;
		box[2][1] = 123;
		box[2][2] = 312;
		box[2][3] = 321;
		box[3][0] = 64;
		box[3][1] = 112;
		box[3][2] = 911;
		box[3][3] = 654;
		
		for(int i = 0; i < box.length; i++){
			for (int j = 0; j < box[i].length; j++){
				System.out.println(box[i][j]);
			}
		}
	}

}
