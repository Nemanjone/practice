package jedinica;

public class Lokacija {

	private Dužina x, y;

	public Lokacija(Dužina x, Dužina y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Dužina getX() {
		return x;
	}

	public Dužina getY() {
		return y;
	}
	
	public void move  (Ugao ugao, Dužina dužina) {
		x.add(Dužina.fromMeters(dužina.toMeters()* Math.cos(ugao.toRadians())));
		y.add(Dužina.fromMeters(dužina.toMeters()* Math.sin(ugao.toRadians()))); 
		
	}
	
	
}
