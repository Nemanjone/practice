
public class TV extends Ureðaj implements DaljinskiUpravljaè {
	
	
	private String  proizvoðaè;
	private int [] kanal;
	private int [] ton;
	protected boolean ukljuèen;
	



	
	public TV( String proizvoðaè, int[] kanal, int[] ton) {
		super();
		this.proizvoðaè = proizvoðaè;
		this.kanal = kanal;
		this.ton = ton;
	}

	public  boolean ukljuèiUreðaj() {
		ukljuèen = !ukljuèen;
		System.out.print("TV" + proizvoðaè + " je ");
		System.out.println((ukljuèen ? "u" : "is") + "kljuèen.");
		return ukljuèen;
	
	}
	 
	public void iskljuèiUreðaj() {
		System.out.println(proizvoðaè + " Goodbye...");
	}
	
	public  void promeniKanal(int n) {
		if (ukljuèen) {
			if (n>=0 && n<=kanal[1])
				kanal[0] = n;
			System.out.println("TV " + proizvoðaè + " , kanal " + kanal[0]);
		}
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
			System.out.println("TV " + proizvoðaè + " , ton " + ton[0]);
		}
	return ton[0];
	
	}
	
	public void ugasiZvuk() {
		if (ukljuèen) {
			ton[0] = 0;
			System.out.println("TV " + proizvoðaè + " , ton " + ton[0]);
		}
	}
	
	

	public void prikaži() {
		System.out.println("Proizvoðaè: " + proizvoðaè);
		System.out.println("Kanal:" + kanal);
		System.out.println("Ton: " + ton);
		
	}
	
}

