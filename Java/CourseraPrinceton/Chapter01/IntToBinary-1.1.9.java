class IntToBinary{

	public static String binaryConvert(int num){
		String returnString = "" ;
		int count = 0  ; // count multiples of 4, for better printing 
		while(num != 0){

			int rem = num % 2 ; 
			returnString = rem + returnString ; 
			num = num / 2 ;
			count++;
			if(count % 4 == 0 ){
				returnString = " " + returnString ;
			}
		}

		return returnString ;

	}
	public static void main(String[] args) {

		int num = 8 ; 
		System.out.printf("%d is %s in binary ", num, binaryConvert(num));
		
	}
}