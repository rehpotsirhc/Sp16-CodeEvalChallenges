package SwapCase;

import java.io.*;

/**
 * Created by chris on 1/15/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           f  = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(f));

        // BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));


        String        line;
        char          A    = 65;
        char          a    = 97;
        char          diff = 97 - 65;
        StringBuilder sb;
        char[]        chars;
        while ((line = br.readLine()) != null) {


            chars = line.toCharArray();
            sb = new StringBuilder();

            for (int i = 0; i < chars.length; i++) {
                //lower to upper
                if (chars[i] >= a && chars[i] <= a + 25) {
                    chars[i] -= diff;
                }

                //upper to low
                else if (chars[i] >= A && chars[i] <= A + 25) {
                    chars[i] += diff;
                }

                sb.append(chars[i]);
            }

            System.out.println(sb);


        }
    }
}
