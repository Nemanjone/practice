package vezbe5;

/*Given a string, return true if the first instance of "x" in the string 
 * is immediately followed by another "x".


doubleX("axxbb") → true
doubleX("axaxax") → false
doubleX("xxxxx") → true*/

public class doubleX {

	boolean doubleX(String str) {

		  
		boolean doubleX = false;

				int n = str.indexOf('x');
				
			if (n == -1) doubleX = false;
			if (n + 1 >= str.length()) doubleX = false;
			
	       String x = str.substring(n);
	       return x.startsWith("xx");

	}

}
