package blatt08;

public class RecCounter {

    public static void prt1234(long n) {
        if (n != 0) {
            prt1234(n - 1);
            System.out.printf("%d, ", n);
        }
    }

	public static void main(String[] args) {
        prt1234(Long.parseLong(args[0]));
	}

}
