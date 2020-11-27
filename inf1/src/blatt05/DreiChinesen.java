package blatt05;

public class DreiChinesen {
	static final String text = 
			  "Drei Chinesen mit dem Kontrabass\n" 
			+ "saßen auf der Straße und erzählten sich was.\n"
			+ "Da kam ein Mann: Ja was ist denn das?\n"
			+ "Drei Chinesen mit dem Kontrabass.\n\n"
			;

	/**
	 * Einen Text zentriert ausgeben. Es genügt eine Lösung für nichtproportionale
	 * Schriftarten.
	 * 
	 * @param text
	 *            Text mit mehreren Zeilen (durch '\n' abgetrennt)
	 */
	static void printCentered(String text) {
        String[] lines = text.split("\n");

        int maxlength = 0;
        for (String line : lines) {
            if (line.length() > maxlength)
                maxlength = line.length();
        }
        
        for (int i = 0; i < lines.length; i++) {
            int paddingl = (maxlength - lines[i].length()) / 2;
            lines[i] = " ".repeat(paddingl) + lines[i] + " ".repeat(lines[i].length());
        }

        for (String line : lines) {
            System.out.println(line);
        }
	}

	/**
	 * Vokale in Text ersetzen.
	 * 
	 * @param text
	 *            Text mit Vokalen
	 * @param replacement
	 *            Ersatz für Vokale
	 * @return Text mit geänderten Vokalen
	 */
	static String changeVowels(String text, String replacement) {
		return text.replaceAll("[aeiouöäü]", replacement);
	}

	public static void main(String[] args) {
		DreiChinesen.printCentered(text);
		DreiChinesen.printCentered(DreiChinesen.changeVowels(text, "i"));
		DreiChinesen.printCentered(DreiChinesen.changeVowels(text, "ü"));
		DreiChinesen.printCentered("");
		DreiChinesen.printCentered("Hello World");
	}

}
