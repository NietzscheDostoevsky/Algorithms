public class Example {
	private int var = 1; // instance variable 

	private void method1(){
		int var = 12; // local variable 

		this.var = 2; // referes to instance var
		System.out.println(var);
		System.out.println(this.var); 

	}

	private void method2(){
		//double var = 2.1;
		System.out.println(var);
	}

	public static void main(String[] args) {
		Example obj = new Example();

		obj.method1();
		obj.method2();
	}

}