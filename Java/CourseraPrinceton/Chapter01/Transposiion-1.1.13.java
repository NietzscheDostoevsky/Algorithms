class Transposition2DArray{

	public static void transposeArray(int[][] a){

		int[][] b = new int[a.length][a[0].length]; 
		for(int i = 0; i<a.length; i++){
			for(int j = 0; j<a[0].length; j++){
				b[j][i] = a[i][j];
			}
		}
		print2DArray(b); 

	}

	public static void main(String[] args) {

		int[][] a = {
			{11, 12, 13, 14, 15}, 
			{16, 17, 18, 19, 20},
			{21, 22, 23, 24, 25},
			{26, 27, 28, 29, 30},
			{31, 32, 33, 34, 35}
		}; // 5x5

		transposeArray(a); 
	}

	public static void print2DArray(int[][] a){
		// takes a 2d array a and prints it on terminal 
		for(int i = 0; i<a.length; i++){
			for(int j = 0; j<a[0].length; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}