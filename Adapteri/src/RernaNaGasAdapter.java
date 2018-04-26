

public class RernaNaGasAdapter implements UnivezalniUredjajZaPecenje {

	private RernaNaGas rerna;

	public RernaNaGasAdapter(RernaNaGas rerna) {
		this.rerna = rerna;
	}

	@Override
	public void iskljuci() {
		this.rerna.setTemparatura(0);
		this.rerna.setMod(Rerna.Mod.DOLE);
		this.rerna.zatvoriVentilZaGas();
	}	


	@Override
	public void zagrevanje() {
		this.rerna.setTemparatura(65);
		this.rerna.otvoriVentil();
		this.rerna.setMod(Rerna.Mod.DOLE);
	}

	@Override
	public void pecenje() {
		this.rerna.otvoriVentil();
		this.rerna.setTemparatura(175);
		this.rerna.setMod(Rerna.Mod.GORE_I_DOLE);
	}

	@Override
	public void susenje() {

		this.rerna.otvoriVentil();
		this.rerna.setTemparatura(105);
		this.rerna.setMod(Rerna.Mod.GORE_I_VENTILATOR);
	}

	@Override
	public void crisp() {
		this.rerna.otvoriVentil();
		this.rerna.setTemparatura(275);
		this.rerna.setMod(Rerna.Mod.GORE_I_DOLE);

	}

	@Override
	public String toString() {
		return "RernaAdapter [rerna=" + rerna + "]";
	}

}


