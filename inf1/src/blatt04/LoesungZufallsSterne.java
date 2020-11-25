package blatt04;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Klasse für das zufällige Zeichnen von Sternen
 */
public class LoesungZufallsSterne extends JFrame {

    /** Konstruktor. Nichts zu ändern hier */
    public LoesungZufallsSterne(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1024,768);
        this.setTitle("Lösung in der Klasse " + this.getClass().getName()); 
        this.setVisible(true);
    }

    /** Main-Methode. Nichts zu ändern hier. */
    public static void main(String[] args){
    	new LoesungZufallsSterne();

    }
   
	/** 
	 * Bitte ab hier Lösung zum Zeichnen der zufälligen Sterne entwickeln.
	 */
    /**
     * 1. Teilaufgabe: Methode, um einen Stern zu zeichnen.
     * 
     * @param g	Grafikbereich, auf dem gezeichnet wird
     * @param midX	x-Koordinate des Mittelpunkts des Sterns
     * @param midY y-Koordinate des Mittelpunkts des Sterns
     * @param r Radius des Sterns
     */
    public void zeichneEinenStern(Graphics g, int midX, int midY, int r){
        double tmpr;
        boolean altcolor = false;

        tmpr = r * (altcolor ? 0.5 : 1);

        for (double i = Math.PI / 24; i < Math.PI; i+= Math.PI / 24) {
            altcolor = !altcolor;
            g.setColor(altcolor ? Color.MAGENTA : Color.BLUE);
            g.drawLine((int)( midX + tmpr * Math.cos(i) ), (int)( midY + tmpr * Math.sin(i) ), (int)(midX - tmpr * Math.cos(i)), (int)(midY - r * Math.sin(i)));
        }
    }
    
    /**
     * Zweite Teilaufgabe: Sterne zufällig platzieren mit zufälligem Radius
     */
    public void paint(Graphics g){

        for (int i = 0; i < 30; i++) {
            double x = Math.random() * this.getWidth();
            double y = Math.random() * this.getWidth();
            int r = (int)(Math.random() * (this.getWidth() / 10));
            zeichneEinenStern(g, (int)x, (int)y, r);
        }
   } 


}
