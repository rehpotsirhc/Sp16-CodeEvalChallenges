package CapitalizeWords;

import java.io.*;

/**
 * Created by chris on 1/15/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File f = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(f));

       // BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));


        String        line;
        char          A    = 65;
        char          a    = 97;
        char          diff = 97 - 65;
        String[]      parts;
        StringBuilder sb;
        while ((line = br.readLine()) != null) {


            parts = line.split(" ");
            sb = new StringBuilder();

            for (int i = 0; i < parts.length; i++) {
                char[] chars = parts[i].toCharArray();

                //if is lowercase letter
                if (chars[0] >= a && chars[0] <= a + 25)
                    chars[0] -= diff;


                for (char c : chars) {
                    sb.append(c);
                }

                if (i < parts.length - 1)
                    sb.append(' ');
            }

            System.out.println(sb);

        }
    }
}
