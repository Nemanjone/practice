package jedinica;

public class Lokacija {

	private Du�ina x, y;

	public Lokacija(Du�ina x, Du�ina y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Du�ina getX() {
		return x;
	}

	public Du�ina getY() {
		return y;
	}
	
	public void move  (Ugao ugao, Du�ina du�ina) {
		x.add(Du�ina.fromMeters(du�ina.toMeters()* Math.cos(ugao.toRadians())));
		y.add(Du�ina.fromMeters(du�ina.toMeters()* Math.sin(ugao.toRadians()))); 
		
	}
	
	
}
