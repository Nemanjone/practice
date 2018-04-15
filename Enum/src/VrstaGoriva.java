
public enum VrstaGoriva {

	BENZIN, DIZEL, GAS, ELEKTRIÈNA_ENERGIJA;

	public String toString() {

		String gorivo= "";

		switch (this) {

		case BENZIN:
			gorivo = "benzin";
			break;
		case DIZEL:
			gorivo = "dizel";
			break;
		case GAS:
			gorivo = "gas";
			break;
		case ELEKTRIÈNA_ENERGIJA:
			gorivo = "elektrièna energija";
			break;
		default:
			break;
		}
		return gorivo;
	}

	public static VrstaGoriva fromSkracenica( String skracenica) {

		VrstaGoriva vrstaGoriva = null;

		switch (skracenica.toUpperCase().trim()) {

		case "B":
			vrstaGoriva = VrstaGoriva.BENZIN;
			break;
		case "D":
			vrstaGoriva = DIZEL;
			break;
		case "G":
			vrstaGoriva = GAS;
			break;
		case "E":
			vrstaGoriva = ELEKTRIÈNA_ENERGIJA;
			break;
		}
		return vrstaGoriva;
	}

}
