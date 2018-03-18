
public class DVDPlayer extends Ure�aj implements DaljinskiUpravlja� {

	
	private String proizvo�a�;
	private int [] ton ;	
	protected boolean uklju�en;
	private String disk;


	public DVDPlayer(String proizvo�a�, int[] ton) {
		super();
		this.proizvo�a� = proizvo�a�;
		this.ton = ton;
		
	}

	public  boolean uklju�iUre�aj() {
		uklju�en = !uklju�en;
		System.out.print("Tv" + proizvo�a� + " je ");
		System.out.println((uklju�en ? "u" : "is") + "klju�en.");
		return uklju�en;
	
	}
	
	public void isklju�iUre�aj() {
		System.out.println(proizvo�a� + " Laku no�...");
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
			System.out.println("DVD " + proizvo�a� + " , ton " + ton[0]);
		}
		
	return ton[0];
	
	}
	public void ubaciDisk(String d) {
		if (uklju�en) {
			if (disk == null)
				disk =  d;
			System.out.println("DVD " + proizvo�a� + " , disk " + disk);
		}
	}
	
	public void prika�iDisk() {
		if (uklju�en) {
			if (disk == null) {
				System.out.println("DVD " + proizvo�a� + " nema diska!");
			}
		}
	}
	
	public void prika�i() {
		System.out.println("Proizvo�a�: " + proizvo�a�);
		System.out.println("Ton: " + ton);
		
	}
}
