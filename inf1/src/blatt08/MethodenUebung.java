package blatt08;

public class MethodenUebung {

    public int Betrag(int number) {
        return number > 0 ? number : -number;
    }

    public int getFloor(float number) {
        return (int)Math.floor(number);
    }

    public int getCeil(float number) {
        return (int)Math.ceil(number);
    }

    public boolean isTeilbar(int x, int y) {
        return x % y == 0;
    }
    
    public double getDistance(double[] p1, double[] p2) {
        return Math.sqrt(Math.pow((p1[0] - p2[0]), 2));
    }

    public int maxNumber(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }

	public static void main(String[] args) {

	}

}
