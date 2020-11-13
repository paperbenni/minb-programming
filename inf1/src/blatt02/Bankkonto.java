package blatt02;
import java.util.Scanner;

public class Bankkonto
{
 public static void main(String[] args)
    {
        double zins;
        double erhoeung;
        double start;
        double end;
        int year = 0;



        System.out.println("Bitte geben Sie ihr Startguthaben ein: ");
        Scanner sc = new Scanner(System.in);
        start = sc.nextDouble();
        System.out.println("Bitte geben Sie den Zinssatz (in%) ein: ");
        zins = sc.nextDouble();
        System.out.println("Bitte geben Sie ihr Sparziel ein: ");
        end = sc.nextDouble();
        System.out.println("Bitte geben Sie an wie viel Sie am Ende des Jahres einzahlen wollen: ");
        erhoeung = sc.nextDouble();

        while (start <= end)
        {
            System.out.println("Guthaben nach dem " + year + ". Jahr: " + start);
            start = start + start * zins + erhoeung;
            year++;

            sc.close();
        }

    }
}
