package LongestWord;

import java.io.*;

/**
 * Created by chris on 1/15/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           f  = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(f));

       // BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));


        String   line;
        String[] parts;
        int      max;
        String   longest;

        while ((line = br.readLine()) != null) {

            max = 0;
            longest = "";


            parts = line.split(" ");

            for (String s : parts) {
                int tmp = s.length();
                if (tmp > max) {
                    max = tmp;
                    longest = s;
                }
            }

            System.out.println(longest);


        }

    }
}
