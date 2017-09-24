import java.io.*;
import java.util.*;

public class Haybales {

    public static void main(String[] args) throws IOException {

        String inputFile = "haybales.in";
        FileReader inFile = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(inFile);

        String[] tempArr = br.readLine().split(" ");
        long n = Long.parseLong(tempArr[0]);
        long q = Long.parseLong(tempArr[1]);

        String[] roadStrs = br.readLine().split(" ");
        ArrayList <Long> road = new ArrayList <Long>();
        for (String s: roadStrs) {
            Long toAdd = Long.parseLong(s);
            int ind = Collections.binarySearch(road, toAdd);
            if (ind < 0) {
               ind = -ind - 1;
            }
            road.add(ind, toAdd);
        }

        String currLine;
        PrintWriter pw = new PrintWriter("haybales.out", "UTF-8");

        while ((currLine = br.readLine()) != null) { 
            String[] tempLines = currLine.split(" ");
            long lRange = Long.parseLong(tempLines[0]);
            long rRange = Long.parseLong(tempLines[1]);
            int iLeft = searchLeft(road, lRange);
            int iRight = searchRight(road, rRange);
            int num = 0;
            if (iLeft == -1 || iRight == -1 || iLeft > iRight) {
                num = 0;
            } else {
                num = iRight - iLeft + 1;
            }

            pw.write(num + "\n");
        }
        br.close();
        pw.close();
    }

    private static int searchLeft(ArrayList <Long> a, long lRange) {
        if (a.get(a.size() - 1) < lRange) {
            return -1;
        }
        int low = 0;
        int high = a.size() - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (a.get(mid) >= lRange) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (high + 1);
    }


    private static int searchRight(ArrayList <Long> a, long rRange) {
        if (a.get(0) > rRange) {
            return -1;
        }
        int low = 0;
        int high = a.size() - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (a.get(mid) > rRange) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (low - 1);
    }

}