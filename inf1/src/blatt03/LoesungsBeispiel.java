package blatt03;
import java.awt.*;
import javax.swing.JFrame;

/**
 * Klasse für eine sehr einfache Zeichnung
 */
public class LoesungsBeispiel extends JFrame {

    /** Konstruktor. Nichts zu ändern hier */
    public LoesungsBeispiel(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setSize(600,400);
        this.setTitle("Lösung in der Klasse " + this.getClass().getName()); 
        this.setVisible(true);
    }

    /** Main-Methode. Nichts zu ändern hier. */
    public static void main(String[] args){
    	new LoesungsBeispiel();
    }
   
	/** 
	 * Beispiel für eine Lösung: Etwas wie ein "C" malen
	 * 
	 */
   public void paint(Graphics g){
		int x25 = this.getWidth() / 4; // green
		int x75 = this.getWidth() * 3 / 4; //red
		int y25 = this.getHeight() / 4; //yellow
		int y75 = this.getHeight() * 3 / 4; //blue

		g.setColor(Color.GREEN); 
		g.drawLine(x25, 0, x25, this.getHeight());

		g.setColor(Color.RED); 
		g.drawLine(x75, 0, x75, this.getHeight());

		g.setColor(Color.YELLOW); 
		g.drawLine(0, y25, this.getWidth(), y25);

		g.setColor(Color.BLUE); 
		g.drawLine(0, y75, this.getWidth(), y75);


    } 
}
