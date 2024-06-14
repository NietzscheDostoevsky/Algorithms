class BooleanArray{
	public static void printBool2DArray(boolean[][] b){

		int rows = b.length ; 
		int cols = b[0].length ;

		for(int i = 0 ; i < rows ; i++ ){
			for(int j = 0; j<cols; j++){
				if(b[i][j] == true){
					System.out.print("t ");
				}else{
					System.out.print("f ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		boolean[][] boo = {
			{true, false, true}, 
			{false, false, true}, 
			{true, true, false}, 
			{false, true, true}
		} ;//4x3 

		printBool2DArray(boo);
	}
}