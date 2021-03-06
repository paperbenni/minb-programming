package blatt02;

import java.util.Scanner;

public class Konto {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double guthaben = 0.0;
        double zins = 2.0;
        int weihnachtsgeld = 1000;
        int jahre = 30;

        System.out.println("Bitte geben Sie Ihr Startguthaben ein: ");
        guthaben = sc.nextInt();
        System.out.println("Bitte geben Sie den Zinssatz (in %) ein: ");
        zins = sc.nextInt();
        System.out.println("Bonus am Ende des Jahres nach Abrechnung?");
        weihnachtsgeld = sc.nextInt();

        double abgehoben = 0.0;
        System.out.println("");

        System.out.println("Bitte entscheiden Sie welche der folgenden Berechnung Sie ausführen möchten:");
        System.out.println("1) Sparplan mit Zinseszins");
        System.out.println("2) Sparplan ohne Zinseszins");
        System.out.println("3) Erforderliche Dauer eines Sparziels mit Zinseszins");

        int choice = sc.nextInt();
        
        if (choice < 3 && choice > 0) {
            System.out.println("Bitte geben Sie die Laufzeit (in Jahren) ein: ");
            jahre = sc.nextInt();
        } else if (choice != 3) {
            System.err.println("Eine Nummer zwischen 1 und 3 eingeben bitte");
            sc.close();
            System.exit(1);
        }

        switch (choice) {
            case 1:
                // TM1 : Jakob
                for (int i = 1; i <= jahre; i++) {
                    guthaben += guthaben * (zins / 100);
                    guthaben += weihnachtsgeld;
                    System.out.println("Guthaben nach dem " + i + ". Jahr: " + guthaben);
                }
                break;
            case 2:
                // TM2 : Benjamin
                for (int i = 1; i <= jahre; i++) {
                    abgehoben += guthaben * (zins / 100);
                    guthaben += weihnachtsgeld;
                    System.out.println("Guthaben einschließlich des abgehobenen Betrags nach dem " + i + ". Jahr: " + (guthaben + abgehoben));
                }
                break;
            case 3:
                // TM3 : Albin
                int year = 0;
                double ziel;

                System.out.println("Bitte geben Sie ihr Sparziel ein: ");
                ziel = sc.nextDouble();
                
                while(guthaben < ziel) {
                    guthaben += guthaben * (zins / 100) + weihnachtsgeld;
                    year++;
                }

                System.out.println("Guthaben nach dem " + year + ". Jahr: " + guthaben);
                break;
        }

        sc.close();
	}
}

