import java.util.*;

public class zmijskeOèi {
	
public static void main(String args[]) {
	
	int brojBacanja = 0;
	int prvaKocka;
	int drugaKocka;
	
	do {
	prvaKocka = (int)(6*Math.random())+1;
	drugaKocka = (int)(6*Math.random())+1;
	brojBacanja++;
    System.out.printf("%4d.bacanje: prvaKocka = %d, drugaKocka = %d\n",
    		brojBacanja, prvaKocka, drugaKocka);		
		
	  	
	}while ((prvaKocka !=1) || ((drugaKocka !=1)));
	
	
	
}
	
}
