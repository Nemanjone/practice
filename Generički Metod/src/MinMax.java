
public class MinMax {

	
	public static void main (String [] args) {
		
		int [] a = {17,5,1,41,8,23,11,5};
		Par <Integer> mm = minmax(a);
		System.out.println("min = " + mm.getPrvi());
		System.out.println("max = " + mm.getDrugi());
		
	}


	public static Par<Integer> minmax(int[] a) {
		
		if (a == null || a.length == 0)
			return null;
		
		int min = a[0], max = a[0];
		for (int i = 0; i < a.length; i++) {
			if(min > a[i])
				min = a[i];
			if(max < a[i])
				max = a[i];
			
		}
		
		return new Par(new Integer(min), new Integer(max));	
		
	} 
}