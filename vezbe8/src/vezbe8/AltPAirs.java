package vezbe8;


/*Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".


altPairs("kitten") → "kien"
altPairs("Chocolate") → "Chole"
altPairs("CodingHorror") → "Congrr"*/

public class AltPAirs {

	public static void main(String[] args) {
		
		
		public String altPairs(String str) {
			
			  
			   String rec = "";
			  
			  
			  for (int i = 0; i < str.length(); i += 4) {
			    
			    int endOfSubstring = i + 2;
			    if (endOfSubstring > str.length()) {
			      endOfSubstring = str.length();
			    }
			    rec = rec + str.substring(i, endOfSubstring);
			  }
			  
			  return rec;
		
  
		}
		  
	}

}
