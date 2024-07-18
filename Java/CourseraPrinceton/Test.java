

class Test {
	public static void main(String[] args) {
		
		 Object obj = java.lang.Void.TYPE;
		 System.out.println(obj);
		 //System.out.println(m1());

	}

	public static void m1(){
		System.out.println("print");
		int a = 5; 
		if(a == 4){
			return;
		} else {
			System.out.println("HAHA");
		}
	}
}