package rs.nemke.mvn.test;

import org.apache.commons.lang3.StringUtils;

public class Test {

	//1

	boolean daLiJeStringPrazan(String str) {
		if (StringUtils.isEmpty(str)) 
			return true; 
		else 
			return false;
	}

	//2
	/*String str1 = "nemanjaprogramer";
	String str2 = "programer";
	String str3 = "odlicanprogramer";
	 */
	String zameniString(String str1, String str2, String str3) {
		return StringUtils.replaceOnce(str1, str2, str3);
	}

	//3
	// Stringu "nemanjaucijavu"; zadrzi substring "javu"

	String zadrziSubstring(String string, int len) {
		return StringUtils.right(string, len);  //("nemanjaucijavu", 10); moze ovo i bolje... 
	}

	//4
	//String "nemanjauci"

	boolean imaLiCifara(String string) {
		return StringUtils.isNumeric(string); 
	}

	//5
	//String [] niz = {"JavaYES", "C++", "C", "JavaScript"};

	String dodajYes(String [] niz) {
		String rezultat = null;
		for (int i = 0; i < niz.length; i++) {
			if ( ! StringUtils.endsWithIgnoreCase(niz[i], "YES") ) 	
				rezultat = niz[i] + "YES";	
		}
		return rezultat;
	}

	//6
	//String "nemanjauciuvaj"

	String obrniSlova(String string) {
		return StringUtils.reverse(string);
	}

	//7
	//Stringovi "markoinemanja", "nemanjaimarko"

	int levenstajnovaDistanca(String str1, String str2) {
		return StringUtils.getLevenshteinDistance(str1, str2);  //zastareo metod, ima nova klasa
	}

	//8
	//String "nemanja uci javu"

	boolean imaLiBelinu(String string) {
		return StringUtils.containsWhitespace(string);
	}

	//9
	//String  "nemanjaucijavu", "a";

	int brojPonavljanjaSlovaUStringu(String string, char ch) {
		int brojac = 0;
		for (int j = 0; j < string.length(); j++) {
			if (StringUtils.contains(string, ch)) {
				brojac++;
			}
		}
		return brojac;
	}
	//ili:

	int brojPonavljanjaSlovaUStringu1(String string, char ch) {
		return StringUtils.countMatches(string, ch);
	}

	//10
	//Stringovi "igra fudbal" i "igra kosarku" -> "igra "

	String vratiPrefiks(String [] nizStringova, String prefiks) { 
		int brojac = 0;
		String rezultat = null;
		for (String string : nizStringova) {
			if(StringUtils.startsWith(string, prefiks))
				brojac++;
		}
		if (brojac == nizStringova.length)                   //ako svaki ima prefiks
			rezultat = prefiks;
		return rezultat;
	}

	//ili:

	String vratiPrefiks1(String [] niz) {
		return StringUtils.getCommonPrefix(niz);
	}
}

