package blatt08;

public class RecCounter {

    public static void prt1234(long n) {
        if (n != 0) {
            prt1234(n - 1);
            System.out.printf("%d, ", n);
        }
    }

    // Tiefe = sqrt(n*n)
    public static void prtSqr1234(long n) {
        if (n != 0) {
            prtSqr1234(n - 1);
            System.out.printf("%d, ", n*n);
        }
    }
    public static void prt2468(long n) {
        if ((n % 2) == 1)
            n -= 1;
        if (n != 0) {
            prt2468(n - 2);
            System.out.printf("%d, ", n);
        }
    }

	public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println("1234:");
        prt1234(n);
        System.out.println("\nsquare:");
        prtSqr1234(n);
        System.out.println("\n2468:");
        prt2468(n);
	}

}
