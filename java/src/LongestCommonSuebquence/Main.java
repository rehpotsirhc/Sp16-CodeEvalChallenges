package LongestCommonSuebquence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 1/8/2016.
 */
public class Main {


    static String matchLCS;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;


        while ((line = br.readLine()) != null) {

         //   if (line.isEmpty()) continue;

            String[] parts = line.split(";");

         //   if (parts[0].isEmpty() || parts[1].isEmpty()) continue;

            System.out.println(LCSDynamicsProgramming(parts[0].toCharArray(), parts[1].toCharArray(), parts[0].length(), parts[1].length()).trim());
        }
    }


    private static int LCSRecursive(String match, char[] s1, char[] s2, int s1L, int s2L) {

        if (s1L == 0 || s2L == 0)
            return 0;

        char f = s1[s1L - 1];
        if (f == s2[s2L - 1]) {
            match = f + match;
            if (match.toString().length() > matchLCS.length())
                matchLCS = match.toString();
            return 1 + LCSRecursive(match, s1, s2, s1L - 1, s2L - 1);
        } else {
            return Math.max(LCSRecursive(match, s1, s2, s1L - 1, s2L), LCSRecursive(match, s1, s2, s1L, s2L - 1));
        }
    }


    private static String LCSDynamicsProgramming(char[] s1, char[] s2, int s1L, int s2L) {


        if (s1L == 0 || s2L == 0)
            return "";

        int[][] memory = new int[s1L][s2L];

        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory[0].length; j++) {
                int max;
                int prev1 = 0;
                int prev2 = 0;
                if (s1[i] == s2[j]) {
                    if (i > 0 && j > 0) prev1 = memory[i - 1][j - 1];
                    max = prev1 + 1;
                } else {
                    if (i > 0)
                        prev1 = memory[i - 1][j];
                    if (j > 0)
                        prev2 = memory[i][j - 1];

                    max = Math.max(prev1, prev2);

                }
                memory[i][j] = max;

            }
        }


        char[] lcs = new char[memory[s1L - 1][s2L - 1] + 1];

        int k = lcs.length - 1;

        int i = memory.length - 1;
        int j = memory[0].length - 1;

        while (i >= 0 && j >= 0) {

            if (s1[i] == s2[j]) {
                lcs[k] = s1[i];
                i--;
                j--;
                k--;
            } else {

                int prev1 = 0;
                int prev2 = 0;

                if (i > 0)
                    prev1 = memory[i - 1][j];

                if (j > 0)
                    prev2 = memory[i][j - 1];

                if (prev1 >= prev2) i--;
                else j--;

            }


        }

        return String.valueOf(lcs);
    }


}
