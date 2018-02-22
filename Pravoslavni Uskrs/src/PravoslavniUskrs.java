import java.util.Scanner;

public class PravoslavniUskrs {
	
	public static void main(String args[]) {
	
    System.out.println("Unesite godinu izmeðu 1900. i 2099: ");
    Scanner tastatura = new Scanner(System.in);
    
    int god = tastatura.nextInt();
    
    int a = god%4;
    int b = god%7;
    int c = god%19;
    int d = (19*c + 15)%30;
    int e = (2*a + 4*b - d + 34)%7;
    int f = d + e + 114;
    
    int mesecJulijanskogKalendara = f/31;
    int danJulijanskogKalendara = (f%31) +1;
    
    		
    int maxbrojDana = 30; // biæe april ili maj; april ima 30 dana;
    
    if (mesecJulijanskogKalendara == 4 && (danJulijanskogKalendara + 13) < maxbrojDana )  {
    		System.out.println("Godine " + god + "." + " Uskrs pada " + (danJulijanskogKalendara + 13) + "." +
    				mesecJulijanskogKalendara + ".");
    	}
    		else { danJulijanskogKalendara = (13 - (maxbrojDana - danJulijanskogKalendara));
    		mesecJulijanskogKalendara = 5;
    			System.out.println("Godine " + god + "." + " Uskrs pada " + danJulijanskogKalendara + "." +
    					mesecJulijanskogKalendara + "." );
    		} 
    		
    	}
    	
    } 
