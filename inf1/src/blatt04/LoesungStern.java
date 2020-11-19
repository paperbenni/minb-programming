package blatt04;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Klasse für das Zeichnen eines Sterns
 */
public class LoesungStern extends JFrame {

    /** Konstruktor. Nichts zu ändern hier */
    public LoesungStern(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setTitle("Lösung in der Klasse " + this.getClass().getName()); 
        this.setVisible(true);
    }

    /** Main-Methode. Nichts zu ändern hier. */
    public static void main(String[] args){
    	new LoesungStern();
    }
   
    /** Paint-Methode. Nichts zu ändern hier. Diese Methode 
     *  wird beim Öffnen des Fensters automatisch aufgerufen. 
     *  Die Methode wird auch aufgerufen, wenn die Größe des Fensters
     *  verändert wird. 
     *  @param g Grafik, auf die gezeichnet wird.
     *  */
    public void paint(Graphics g){
    	/* Löschen des Fensterinhalts (wichtig bei erneutem Zeichnen): */
    	g.clearRect(0, 0, this.getWidth(), this.getHeight());
    	
    	this.meinStern(g); // Aufruf der selbst programmierten Methode
    }
	/**
	 * Hier bitte die Lösung, um den Stern zu zeichnen
	 * 
	 */
   public void meinStern(Graphics g){
       int middlex = this.getWidth() / 2;
       int middley = this.getHeight() / 2;
       double size = 2;
       double radius = ( middlex > middley ? middley / 2 : middlex / 2 ) * size;
       double r;

       g.setColor(Color.RED);
       boolean altcolor = false;
       for (double i = Math.PI / 24; i < Math.PI; i+= Math.PI / 24) {
           altcolor = !altcolor;
           g.setColor(altcolor ? Color.MAGENTA : Color.BLUE);
           r = radius * (altcolor ? 0.5 : 1);
           g.drawLine((int)( middlex + r * Math.cos(i) ), (int)( middley + r * Math.sin(i) ), (int)(middlex - r * Math.cos(i)), (int)(middley - r * Math.sin(i)));
       }
   } 
}
