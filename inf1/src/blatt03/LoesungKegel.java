package blatt03;
import java.awt.*;
import javax.swing.JFrame;

/**
 * Klasse, um ein Raster zu malen
 */
public class LoesungKegel extends JFrame {

    /** Konstruktor. Nichts zu ändern hier */
    public LoesungKegel(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(610,417);
        this.setTitle("Lösung in der Klasse " + this.getClass().getName()); 
        this.setVisible(true);
    }

    /** Main-Methode. Nichts zu ändern hier. */
    public static void main(String[] args){
    	new LoesungKegel();
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
    	
    	this.meinKegel(g); // Aufruf der selbst programmierten Methode
    }
   
	/** 
	 * Hier bitte die Lösung, um den Kegel zu zeichnen
	 * 
	 */
   public void meinKegel(Graphics g){
        int x25 = this.getWidth() / 4;
        int x75 = this.getWidth() * 3 / 4;
        int y25 = this.getHeight() / 4;
        int y75 = this.getHeight() * 3 / 4;
        g.setColor(Color.BLACK);

        // Kegel outline
        g.drawLine(x25, y25, x75, y25);
        g.drawLine(x25, y75, x75, y75);

        g.drawLine(x25, y25, x75, y75);
        g.drawLine(x25, y75, x75, y25);

        final int kegelcount = 40;

        g.setColor(Color.LIGHT_GRAY);

        float step = this.getWidth() / (float)(kegelcount - 1);
        for (int counter = 1; counter < kegelcount - 1; counter++){
            g.drawLine(x25 + (int)(counter * step / 2), y25, x75 - (int)(counter * step / 2), y75);
        }
    }
}
