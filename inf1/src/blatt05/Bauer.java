package blatt05;

public class Bauer {

    private String name;
    private static int anzahlGefuetterterHuehner = 0;

    public Bauer(String name) {
        this.name = name;
    }
    
    public void fuettern(Huhn huhn) {
        if (huhn.getHungrig())
            return;
        anzahlGefuetterterHuehner++;
        huhn.setHungrig(true);
    }

    public void rufeHuhn(Huhn huhn) {
        System.out.println(huhn.getName());
    }

    public static void berechneAnzahlHungrigerHuehner() {
        System.out.println((Huhn.getAnzahlHuehner() - anzahlGefuetterterHuehner) + " Huehner gefuettert");
    }

    public static void main(String[] args)  {
        Bauer walter = new Bauer("Walter");
        Huhn[] huehner = {
            new Huhn("Heidrun"), 
            new Huhn("Heike"), 
            new Huhn("Hannelore")
        };

        for (Huhn huhn : huehner) {
            walter.rufeHuhn(huhn);
            walter.fuettern(huhn);
        }
        berechneAnzahlHungrigerHuehner();
    }


}
