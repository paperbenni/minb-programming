package blatt05;

public class Huhn {

    private String name;
    private boolean hungrig = true;
    private static int anzahlHuehner = 0;

    public Huhn(String name) {
        anzahlHuehner++;
        this.name = name;
    }
    
    public void setHungrig(Boolean hunger) {
        this.hungrig = hunger;
    }

    public Boolean getHungrig() {
        return this.hungrig;
    }

    public String getName() {
        return this.name;
    }

    public static int getAnzahlHuehner() {
        return anzahlHuehner;
    }


}
