
public class ProgramerFilter  implements KandidatFilter {

	@Override
	public boolean odgovara(Kandidat kandidat) {
		
		if(kandidat.getBrojMeseciRadnogIskustava("programiranje") < 12) {	
		return false;
		}
		if (kandidat.getBrojMeseciRadnogIskustava("baze podataka") < 12) {
			return false;
		}
		if (kandidat.getBrojMeseciRadnogIskustava("engleski") < 24) {
			return false;
		}
		return true;
	}

}
