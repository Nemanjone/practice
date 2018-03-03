import java.util.Arrays;

public class Loto {

	public static void main(String args[]) {
		
		final int N = 39; //ukupno brojeva u bubnju
		final int K = 7;// broj izvuèenih brojeva
		int bubanj[] = new int[N];
		
		for(int i = 0; i < N;i++)
			bubanj[i] = i+1;
				
		int m; //granica levog i desnog dela bubnja
		
		for(m = N-1; m > N-K-1;m--) {
			int i = (int)(Math.random()*(m + 1));
			
			int broj = bubanj[i];
			bubanj[i] = bubanj[m];
			bubanj[m] = broj; // zamena izvuèenog broja i poslednjeg u nizu
		}
			
			int[] kombinacija = Arrays.copyOfRange(bubanj, m+1, N);
			
			Arrays.sort(kombinacija);

			System.out.print("Dobitna kombinacija izvuèenih brojeva je: ");
			for (int i = 0; i < kombinacija.length; i++)
				System.out.print(kombinacija[i] + " ");
			System.out.println();
		
	}
	
}
