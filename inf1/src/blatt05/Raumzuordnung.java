package blatt05;

/** Beispiel für Referenzen: Klasse für Mitarbeiter-Raumzuordnung */
public class Raumzuordnung {
	private Raum raum;		// Referenz auf Raum
	private Person nutzer;	// Referenz auf Nutzer/in
    private String grund;
	
	/** Konstruktor */
	public Raumzuordnung(Raum raum, Person nutzer) {
        this.setRaum(raum);
        this.setNutzer(nutzer);
		this.raum = raum; this.nutzer = nutzer;
	}

    public void setNutzer(Person nutzer) {
        if (nutzer == null) {
            System.err.println("Error, bitte auf Nutzername achten");
        } else {
            this.nutzer = nutzer;
        }
    }

    public void setRaum(Raum raum) {
        if (raum == null) {
            System.err.println("Error, bitte auf Raumname achten");
        } else {
            this.raum = raum;
        }
    }

	public Raumzuordnung(Raum raum, Person nutzer, String zuordnungsgrund) {
        this(raum, nutzer);
        this.setGrund(zuordnungsgrund);
	}

    public String getGrund() {
        return this.grund;
    }
    public void setGrund(String zuordnungsgrund) {
        if (zuordnungsgrund.length() <= 3) {
            System.err.println("Raumname muss länger als 3 Zeichen sein");
        } else {
            this.grund = zuordnungsgrund;
        }
    }
	
	public void print() {
		this.getNutzer().print();
		System.out.print(" nutzt den Raum: ");
		this.getRaum().print();
	}
	
	Raum getRaum() {
		return this.raum;
	}
	
	Person getNutzer() {
		return this.nutzer;
	}
	
	public static void main(String[] a) { 
		// Bröckl nutzt den Raum E 212a
		Person ub = new Person("Ulrich", "Bröckl");
		Raum e212a = new Raum("e 212a", 2);
		Raumzuordnung ub2e212a = new Raumzuordnung(e212a, ub);
		ub2e212a.print();	

		// Bröckl nutzt außerdem den Raum E 201
		Raumzuordnung ub2e201 = new Raumzuordnung(
				new Raum("e 201", 77, true), // keine Zwischenvariable für e201 nötig...
				ub);
		// Den Raum dieser Zuordnung ausgeben:
		System.out.print("\n     Außerdem: ");
		ub2e201.getRaum().print();
		System.out.println("\n");
		
		// Vogelsang nutzt den Raum E 209
		Raumzuordnung hv2e209 = new Raumzuordnung(
				new Raum("e 209", 3),
				new Person("Holger", "Vogelsang"));
		hv2e209.print();
		
	}

}
