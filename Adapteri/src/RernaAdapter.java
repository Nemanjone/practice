

public class RernaAdapter implements UnivezalniUredjajZaPecenje {

	private Rerna rerna;

	public RernaAdapter(Rerna rerna) {
		super();
		this.rerna = rerna;
	}

	@Override
	public void iskljuci() {
		this.rerna.setTemparatura(0);
		this.rerna.setMod(Rerna.Mod.DOLE);

	}

	@Override
	public void zagrevanje() {
		this.rerna.setTemparatura(75);
		this.rerna.setMod(Rerna.Mod.DOLE);
	}

	@Override
	public void pecenje() {
		this.rerna.setTemparatura(175);
		this.rerna.setMod(Rerna.Mod.GORE_I_DOLE);
	}

	@Override
	public void susenje() {
		this.rerna.setTemparatura(105);
		this.rerna.setMod(Rerna.Mod.GORE_I_VENTILATOR);
	}

	@Override
	public void crisp() {
		this.rerna.setTemparatura(250);
		this.rerna.setMod(Rerna.Mod.ROSTILJ);
	}

	@Override
	public String toString() {
		return "RernaAdapter [rerna=" + rerna + "]";
	}


}
