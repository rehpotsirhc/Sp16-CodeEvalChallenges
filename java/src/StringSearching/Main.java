package StringSearching;

import java.io.*;

/**
 * Created by chris on 1/15/2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {


        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String   line;
        String[] parts;
        String   del = "$";


        String s;

        String t;

        while ((line = br.readLine()) != null) {
            parts = line.split(",");


            s = parts[0];

            s = s.replace("*", "#");

            t = parts[1];

            t = t.replace("\\*", "#");

            parts = t.split("\\*");

            boolean match = false;
            for (String tmp : parts) {
                int[] zs = computeZValues((tmp + del + s).toCharArray(), '*');
                match = false;
                for (Integer i : zs) {
                    match = i >= tmp.length();
                    if (match) break;
                }
                if (!match) break;
            }

            System.out.println(match);


        }

    }

    private static int[] computeZValues(char[] s, char wild) {
        int[] z = new int[s.length];
        int   l = 0, r = 0, p, i;

        for (int k = 1; k < z.length; k++) {

            if (r < k) {
                i = 0;
                while ((k + i) < z.length && (s[i] == s[k + i]) || s[i] == wild) i++;
                z[k] = i;

                if (i > 0) {
                    l = k;

                    r = l + i - 1;
                }

            } else {
                p = k - l;

                if (z[p] < r - k + 1) z[k] = z[p];
                else {
                    i = r + 1;
                    while (i < s.length && (s[i] == s[i - k] || s[i - k] == wild)) i++;
                    z[k] = i - k;
                    r = i - 1;
                    l = k;

                }
            }
        }
        return z;
    }


}
