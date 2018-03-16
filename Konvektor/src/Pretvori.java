
public interface Pretvori {

	                                    //kilogrami = funte/2.2046;  cm = inè/ 0,39370
	double CENTIMETAR_INÈ = 0.39370;
	double INÈ_CENTIMETAR = 2.54;
	double FUNTA_KILOGRAM = 0.45;
	double KILOGRAM_FUNTA = 2.2046;
	
	double pretvoriInèe(double inè);
	double pretvoriCentimetre(double centimetar);
	double pretvoriFunte(double funta);
	double pretvoriKilograme(double kilogram);
}
