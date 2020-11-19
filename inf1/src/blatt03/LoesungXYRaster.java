package blatt03;
import java.awt.*;
import javax.swing.JFrame;

/**
 * Klasse, um ein Raster zu malen
 */
public class LoesungXYRaster extends JFrame {

    /** Konstruktor. Nichts zu ändern hier */
    public LoesungXYRaster(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(604,417);
        this.setTitle("Lösung in der Klasse " + this.getClass().getName()); 
        this.setVisible(true);
    }

    /** Main-Methode. Nichts zu ändern hier. */
    public static void main(String[] args){
    	new LoesungXYRaster();
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
    	
    	
    	this.meinRaster(g); // Aufruf der selbst programmierten Methode
    }
   
	/** 
	 * Hier bitte die Lösung, um das Raster zu zeichnen
	 * 
	 */
   public void meinRaster(Graphics g){
        Boolean greyline = false;
        int x25 = this.getWidth() / 4;
        int x75 = this.getWidth() * 3 / 4;
        int y25 = this.getHeight() / 4;
        int y75 = this.getHeight() * 3 / 4;

        int x, y;
        float step = this.getWidth() / (2*10.f);

        for (int counter = 0; counter <= 10; counter++) {
            greyline = !greyline;
            g.setColor(greyline ? Color.BLACK : Color.LIGHT_GRAY);
            x = x25 + (int)(step * counter);
            g.drawLine(x, y25, x, y75);
        }

        step = this.getHeight() / (2*10.f);

        greyline = false;

        for (int counter = 0; counter <= 10; counter++) {
            greyline = !greyline;
            g.setColor(greyline ? Color.BLACK : Color.LIGHT_GRAY);
            y = y25 + (int)(step * counter);
            g.drawLine(x25, y, x75, y);
        }

   }
}
