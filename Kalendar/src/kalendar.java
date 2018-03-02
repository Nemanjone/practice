import java.util.*;

public class kalendar {

	public static void main(String [] args)	{
		
		Scanner tastatura = new Scanner(System.in);
		
		System.out.println("Izaberite mesec: ");
		int mesec = tastatura.nextInt();
		System.out.println("Izaberite godinu: ");
		int godina = tastatura.nextInt();
		System.out.println();
		
        GregorianCalendar kalendar = new GregorianCalendar();
        
        int brojDana = 0;
        
        switch (mesec) {
        case 1:case 3:case 5:case 7:case 8:case 10:case 12:
            brojDana = 31;
            break;
        case 4:case 6:case 9:case 11:
        	brojDana = 30;
        	break;
        case 2:
        	if (kalendar.isLeapYear(godina))
        	brojDana = 29;
        	else
        		brojDana = 28;
        	break;
        	default:
        		System.out.println("Greška! Pogrešno ste uneli mesec. ");
           System.exit(-1);
          }
   kalendar.set(godina, mesec-1, 0); //meseci poèinju od nule
   
   int prviDan = kalendar.get(Calendar.DAY_OF_WEEK);
   System.out.println("   PON  UTO  SRE  ÈET  PET  SUB NED");
   
   int k = 0; //trenutni dan kalendara; Sunday = 1...Saturday = 7;
	
   for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i ++) {
	   if (prviDan == i)
		   break;
	   System.out.print("     ");
	k++;
   }
   for (int d = 1; d <= brojDana; d++) {
	   System.out.printf("%5d", d);
	   k++;
	   if (k == 7) {
		   System.out.println();
		   k = 0;
	   } 
	   
   }
   System.out.println();
   
	}
}
	
