package blatt03;

public class SchleifenUebung {

	public static void main(String[] args) {
        final float START = -4.f;
        final float END = 4.f;
        final float STEP = 0.5f;

        System.out.println("Alle Quadratzahlen von " + START + " ... " + END + " in " + STEP + "er-Schritten:");
        for (float i = START; i <= END; i+=STEP) {
            System.out.println("x, x^2: " + i + ", " + Math.pow(i, 2));
        }


        System.out.println("Alle Sinus, Cosinus von " + START + " ... " + END + " in " + STEP + "er-Schritten:");
        for (float i = START; i <= END; i+=STEP) {
            System.out.println("x, sin(x), cos(x): " + i + ", " + Math.sin(i) + ", " + Math.cos(i));
        }

	}

}
