package blatt08;

// A 8.8
public class Xxx {

    void xxx(long n) {
        if (n > 0L) {
            System.out.println(n);
            xxx(n - 1); // rekursionsfortsetzung
        } else {
        } // rekursionsbasis
    }

    void iterxxx(long n) {
        for (; n > 0L; n--) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        Xxx testx = new Xxx();
        System.out.println("xxx");
        testx.xxx(10);
        System.out.println("iterxxx:");
        testx.iterxxx(10);
    }
}
