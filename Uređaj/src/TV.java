
public class TV extends Ure�aj implements DaljinskiUpravlja� {
	
	
	private String  proizvo�a�;
	private int [] kanal;
	private int [] ton;
	protected boolean uklju�en;
	



	
	public TV( String proizvo�a�, int[] kanal, int[] ton) {
		super();
		this.proizvo�a� = proizvo�a�;
		this.kanal = kanal;
		this.ton = ton;
	}

	public  boolean uklju�iUre�aj() {
		uklju�en = !uklju�en;
		System.out.print("TV" + proizvo�a� + " je ");
		System.out.println((uklju�en ? "u" : "is") + "klju�en.");
		return uklju�en;
	
	}
	 
	public void isklju�iUre�aj() {
		System.out.println(proizvo�a� + " Goodbye...");
	}
	
	public  void promeniKanal(int n) {
		if (uklju�en) {
			if (n>=0 && n<=kanal[1])
				kanal[0] = n;
			System.out.println("TV " + proizvo�a� + " , kanal " + kanal[0]);
		}
	}
	
	public int poja�ajTon () {
		if (uklju�en) {
			ton[0] = Math.min(ton[0] + 1, ton[1]);
			System.out.println("TV " + proizvo�a� + " , ton " + ton[0]);
		}
		return ton[0];
	}
	
	public int smanjiTon() {
		if (uklju�en) {
			ton[0] = Math.max(ton[0] -1 , ton[1]);
			System.out.println("TV " + proizvo�a� + " , ton " + ton[0]);
		}
	return ton[0];
	
	}
	
	public void ugasiZvuk() {
		if (uklju�en) {
			ton[0] = 0;
			System.out.println("TV " + proizvo�a� + " , ton " + ton[0]);
		}
	}
	
	

	public void prika�i() {
		System.out.println("Proizvo�a�: " + proizvo�a�);
		System.out.println("Kanal:" + kanal);
		System.out.println("Ton: " + ton);
		
	}
	
}

