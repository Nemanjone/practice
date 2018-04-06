
public class NekiTip {
	
	private final String podatak1;
	private final Double podatak2;
	private final Integer podatak3;
	
	public NekiTip(String podatak1, Double podatak2, Integer podatak3) {
		super();
		this.podatak1 = podatak1;
		this.podatak2 = podatak2;
		this.podatak3 = podatak3;
	}

	public String getPodatak1() {
		return podatak1;
	}

	public Double getPodatak2() {
		return podatak2;
	}

	public Integer getPodatak3() {
		return podatak3;
	}

	@Override
	public String toString() {
		return "NekiTip [podatak1=" + podatak1 + ", podatak2=" + podatak2 + ", podatak3=" + podatak3 + "]";
	}
	
	
}
