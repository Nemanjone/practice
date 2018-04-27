import java.io.File;
import java.util.Scanner;

public class ListaDirektorijuma {

	public static void main(String[] args) {

		String imeDirektorijuma;
		File direktorijum;
		String datoteke[];

		Scanner tastatura = new Scanner(System.in);

		System.out.println("Unesite ime direktorijuma: ");
		imeDirektorijuma = tastatura.nextLine().trim();

		direktorijum = new File(imeDirektorijuma);

		if(direktorijum.isDirectory() == false) {
			if(direktorijum.exists() == false)
				System.out.println("Ne postoji takav direktorijum!");
		}
		else {
			izlistajSadrzajDirektorijuma(direktorijum, "");
		}
	}


	private static void izlistajSadrzajDirektorijuma (File dir, String indent) {
		String [] datoteke;
		System.out.println(indent + "Direktorijum \"" + dir.getName()+ "\":");
		indent +="   ";
		datoteke = dir.list();
		for (int i = 0; i < datoteke.length; i++) {
			File f = new File(dir, datoteke[i]);
			if(f.isDirectory())
				izlistajSadrzajDirektorijuma(f, indent);
			else
				System.out.println(indent + datoteke[i]);

		}
	}
}

