
public class DVDPlayer extends Ureðaj implements DaljinskiUpravljaè {

	
	private String proizvoðaè;
	private int [] ton ;	
	protected boolean ukljuèen;
	private String disk;


	public DVDPlayer(String proizvoðaè, int[] ton) {
		super();
		this.proizvoðaè = proizvoðaè;
		this.ton = ton;
		
	}

	public  boolean ukljuèiUreðaj() {
		ukljuèen = !ukljuèen;
		System.out.print("Tv" + proizvoðaè + " je ");
		System.out.println((ukljuèen ? "u" : "is") + "kljuèen.");
		return ukljuèen;
	
	}
	
	public void iskljuèiUreðaj() {
		System.out.println(proizvoðaè + " Laku noæ...");
	}
	

	public int pojaèajTon () {
		if (ukljuèen) {
			ton[0] = Math.min(ton[0] + 1, ton[1]);
			System.out.println("TV " + proizvoðaè + " , ton " + ton[0]);
		}
		return ton[0];
	}
	
	public int smanjiTon() {
		if (ukljuèen) {
			ton[0] = Math.max(ton[0] -1 , ton[1]);
			System.out.println("DVD " + proizvoðaè + " , ton " + ton[0]);
		}
		
	return ton[0];
	
	}
	public void ubaciDisk(String d) {
		if (ukljuèen) {
			if (disk == null)
				disk =  d;
			System.out.println("DVD " + proizvoðaè + " , disk " + disk);
		}
	}
	
	public void prikažiDisk() {
		if (ukljuèen) {
			if (disk == null) {
				System.out.println("DVD " + proizvoðaè + " nema diska!");
			}
		}
	}
	
	public void prikaži() {
		System.out.println("Proizvoðaè: " + proizvoðaè);
		System.out.println("Ton: " + ton);
		
	}
}
