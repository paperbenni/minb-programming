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

       double radius = ( middlex > middley ? middley / 2 : middlex / 2 );
   } 

   public void meineZufallsSterne() {
       
   }

   public void zeichneEinenStern(Graphics g, int midX, int midY, int r) {
       double tmpr;
       boolean altcolor = false;

       tmpr = r * (altcolor ? 0.5 : 1);

       for (double i = Math.PI / 24; i < Math.PI; i+= Math.PI / 24) {
           altcolor = !altcolor;
           g.setColor(altcolor ? Color.MAGENTA : Color.BLUE);
           g.drawLine((int)( midX + tmpr * Math.cos(i) ), (int)( midY + tmpr * Math.sin(i) ), (int)(midX - tmpr * Math.cos(i)), (int)(midY - r * Math.sin(i)));
       }

   }
}
