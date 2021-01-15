package blatt08;

class CallTree {
    public static int f() {
        System.out.print("f()");
        g();
        h();
        return 1;
    }

    public static int g() {
        System.out.print("g()");
        return 2;
    }

    public static void h() {
        System.out.print("h()");
    }

    public static void b() {
        System.out.print("b()");
        f();
        h();
    }

    public static void main(String[] args) {
        b();
    }
}
