
public class Rerna {
	
	public enum Mod { GORE, DOLE, GORE_I_DOLE, ROSTILJ, GORE_I_VENTILATOR}
	
	private Mod mod;
	private int temparatura;
	
	public Rerna () {}
	
	public void setMod(Mod mod) {
		this.mod = mod;
	}

	public void setTemparatura(int temparatura) {
		this.temparatura = temparatura;
	}

	public Mod getMod() {
		return mod;
	}

	public int getTemparatura() {
		return temparatura;
	}

	@Override
	public String toString() {
		return "Rerna [mod=" + mod + ", temparatura=" + temparatura + "]";
	}
	
}
