package blatt11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Klasse, um Mittelwert zu berechnen
 * 
 * @author Ulrich.Broeckl@hs-karlsruhe.de
 *
 */
public class Statistik {
    private double summe;

    protected double n;

    String name;

    /**
     * Konstruktor
     * 
     * @param name Identifikator/Name für die Statistik
     */
    public Statistik(String name) {
        if (name == null) {
            NullPointerException e = new NullPointerException("Statistic name may be uninitialized");
            throw e;
        } else if (name.length() == 0) {
            RuntimeException e = new RuntimeException("Empty name not allowed");
            throw e;
        } else if (!name.matches("^[a-zA-Z].*")) {
            RuntimeException e = new RuntimeException("Name must start with a letter");
            throw e;
        }
        this.name = name;
        this.summe = this.n = 0.;
    }

    /**
     * Einen neuen Wert der Statistik hinzufügen
     * 
     * @param wert
     */
    public void addWert(double wert) {
        this.n++;
        this.summe += wert;
    }

    /**
     * * Zwei Werte dividieren * @param z, Zahl die dividiert wird (Zähler) * @param
     * n, Zahl durch die dividiert wird (Nenner) * @return z / n
     */
    public static double div(int z, int n) {
        try {
            return z / n;
        } catch (ArithmeticException e) {
            System.err.println("Error: division by 0");
            e.printStackTrace();
            return Double.POSITIVE_INFINITY;
        }
    }

    /**
     * Durchschnitt berechnen
     * 
     * @return Durchschnitt aller Werte
     */
    double getDurchschnitt() {
        if (this.n == 0) {
            RuntimeException e = new RuntimeException("empty statistic cannot be serialized");
            throw e;
        }
        return this.summe / this.n;
    }

    /**
     * Statistik in Zeichenkette ausgeben
     * 
     */
    @Override
    public String toString() {
        if (this.n == 0) {
            RuntimeException e = new RuntimeException("empty statistic cannot be serialized");
            throw e;
        }
        return String.format("%12s: n==%10.0f, µ==%8f", this.name, this.n, this.getDurchschnitt());
    }

    public static void main(String[] args) {
        System.out.println("test: " + div(1, 0));
    }

    /**
     * Statistik in Datei mit dem Namen der Statistik und der Endung ".statistik"
     * ausgeben
     * 
     * @throws IOException
     * 
     * @see https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
     */
    public void writeToFile() throws IOException {
        try {
            Files.write(Paths.get(this.name + ".statistik"), this.toString().getBytes());
        } catch (IOException e) {
            throw e;
        }
    }

}
