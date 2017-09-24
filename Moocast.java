import java.io.*;
import java.util.*;

public class Moocast {

    private static boolean[] cowsSkipped;

    private static boolean calc(int x1, int y1, int x2, int y2, int p) {
        if(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) > (p * p)) {
            return false;
        } else {
            return true;
        }
    }

    private static int count(int N, int[][] cows, int cow) {
        cowsSkipped[cow] = true;
        int reached = 1;
        for (int i = 0; i < N; i++) {
            if (cowsSkipped[i]){
                continue;
            }
            if (calc(cows[cow][0], cows[cow][1], cows[i][0], cows[i][1], cows[cow][2])) {
                reached = reached + count(N, cows, i);
            }
        }
        return reached;
    }

    public static void main (String [] args) throws IOException {
        FileReader inFile = new FileReader("moocast.in");
        BufferedReader br = new BufferedReader(inFile);
        
        int N = Integer.parseInt(br.readLine());
        int[][] cows = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < cows[0].length; j++) {
                cows[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int mostNumReached = 0;
        for (int i = 0; i < N; i++) {
            cowsSkipped = new boolean[N];
            int reach = count(N, cows, i);
            if (reach > mostNumReached) {
                mostNumReached = reach;
            }
        }
        
        FileWriter outFile = new FileWriter("moocast.out");
        BufferedWriter bw = new BufferedWriter(outFile);
        PrintWriter pw = new PrintWriter(bw);
        pw.println(mostNumReached);
        pw.close();
    }

}