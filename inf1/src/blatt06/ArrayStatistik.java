package blatt06;

import java.util.*;

public class ArrayStatistik {

	public static void main(String[] args) {
        int[] testarray = {35, 7, 90, 26, 92, 54, 24, 65, 2, 67, 43, 26, 80, 92, 7, 40, 67, 66, 31, 45, 7, 100, 96, 93, 12, 20, 57, 22, 62, 51};

        // TODO manually implement this
        System.out.println("Mittelwert: " + Arrays.stream(testarray).average());
        System.out.println("Summe: " + Arrays.stream(testarray).sum());

        float median;
        int tlen = testarray.length;
        Arrays.sort(testarray);
        if (tlen % 2 == 0) {
            median = (testarray[tlen / 2] + testarray[(tlen / 2) + 1]) / 2;
        } else {
            median = (testarray[(tlen / 2) + 1]);
        }
        System.out.println("Median: " + median);

        double[][] schadenstabelle= {
            {0, 0.744}, 
            {350, 0.182}, 
            {1500, 0.061}, 
            {5000, 0.013}, 
        };

        double erwartungsschaden = 0;
        for (double[] ds : schadenstabelle) {
            erwartungsschaden += ds[0] * ds[1];
        }
        System.out.println("Erwarteter Schaden: " + erwartungsschaden);

	}

}
