/* 
* 1.1.14 Write a static method lg() that takes an 
* int value N as argument and returns
* the largest int not larger than the 
* base-2 logarithm of N. Do not use Math.
*/

class Logarithm{
	public static int Logarithm(int num){
		// returns largest integer not larger than log(2) base 2 

		int log = 0;
		while(num!=0){
			num = num / 2 ;
			if(num > 0){
				log++ ;
			}

		}

		return log ; 
	}

	public static void main(String[] args) {
		int num = 17 ;
		System.out.printf("%d's log base 2 is %d" , num, Logarithm(num));
	}
}
