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

        for (double i = Math.PI / 24; i < Math.PI; i+= Math.PI / 24) {
            tmpr = r * (altcolor ? 1.1 : 1);
            altcolor = !altcolor;
            g.setColor(altcolor ? Color.MAGENTA : Color.BLUE);
            g.drawLine((int)( midX + tmpr * Math.cos(i) ), (int)( midY + tmpr * Math.sin(i) ), (int)(midX - tmpr * Math.cos(i)), (int)(midY - tmpr * Math.sin(i)));
        }
    }
    
    /**
     * Zweite Teilaufgabe: Sterne zufällig platzieren mit zufälligem Radius
     */
    public void paint(Graphics g){
        final boolean random = false;
        if (random) {
            g.clearRect(0, 0, this.getWidth(), this.getHeight());

            for (int i = 0; i < 30; i++) {
                double x = Math.random() * this.getWidth();
                double y = Math.random() * this.getWidth();
                int r = (int)(Math.random() * (this.getWidth() / 10));
                zeichneEinenStern(g, (int)x, (int)y, r);
            }
        } else {
            int spiralradius = 10;
            int midx = this.getWidth() / 2;
            int midy = this.getHeight() / 2;
            for (double i = Math.PI / 24; i < Math.PI * 6; i+= Math.PI / 12) {
                spiralradius += 10;
                zeichneEinenStern(g, midx + (int)(Math.cos(i) * spiralradius), midy + (int)(Math.sin(i) * spiralradius), spiralradius);
            }
        }
   } 


}
