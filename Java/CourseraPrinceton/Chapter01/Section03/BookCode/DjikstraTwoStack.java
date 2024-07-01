import edu.princeton.cs.algs4.*;

// implement Dkikstra's two stack expression evaluatio algo 

class DjikstraTwoStack {
	public static void main(String[] args) {
		
		Stack<String> ops = new Stack<String>(); // opeartor stack
		Stack<Double> vals = new Stack<Double>(); // opearand stack 
		StdOut.println("Enter the expression now");
		while (!StdIn.isEmpty()) {
			// Read tokens, push if operator 

			String s = StdIn.readString();
			if( s.equals("("))                 ; // do nothing, ignore left parantheses
			else if (s.equals("+")) ops.push(s);// push in operator 
			else if (s.equals("-")) ops.push(s);
			else if (s.equals("*")) ops.push(s);
			else if (s.equals("/")) ops.push(s);
			else if (s.equals("sqrt")) ops.push(s);
			else if (s.equals(")")) {
				// perform opeartions when there is a right paranthesis. 
				String op = ops.pop(); // get an operator 
				double v = vals.pop(); // get an oparand

				if ( op.equals("+")) v = vals.pop() + v ;
				else if (op.equals("-")) v = vals.pop() - v ;
				else if (op.equals("*")) v = vals.pop() * v ; 
				else if (op.equals("/")) v = vals.pop() / v ;
				else if (op.equals("sqrt")) v = Math.sqrt(v);
				vals.push(v);

			} // token not operator or paranthesis, push double value

			else vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());

	}
}