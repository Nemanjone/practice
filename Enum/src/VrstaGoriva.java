
public enum VrstaGoriva {

	BENZIN, DIZEL, GAS, ELEKTRI�NA_ENERGIJA;

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
		case ELEKTRI�NA_ENERGIJA:
			gorivo = "elektri�na energija";
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
			vrstaGoriva = ELEKTRI�NA_ENERGIJA;
			break;
		}
		return vrstaGoriva;
	}

}
