import java.io.*;
import java.util.*;

public class Citystate {

    public static void main (String [] args) throws IOException {
        
        String inputFile = "citystate.in";
        FileReader inFile = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(inFile);
        
        int N = Integer.parseInt(br.readLine());
        String[] cityAB = new String[N];
        String[] stateAB = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            cityAB[i] = str.substring(0, 2);
            stateAB[i] = str.substring(str.indexOf(" ") + 1);
        }

        int found = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (stateAB[i].equals(cityAB[j]) && cityAB[i].equals(stateAB[j]) && !stateAB[i].equals(stateAB[j])) {
                    found++;
                }
            }
        }
        
        String outputFile = "citystate.out";
        FileWriter outFile = new FileWriter(outputFile);
        BufferedWriter bw = new BufferedWriter(outFile);
        PrintWriter pw = new PrintWriter(bw);
        pw.println(found);
        pw.close();
    }

}