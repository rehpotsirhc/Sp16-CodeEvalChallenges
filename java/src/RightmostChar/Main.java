package RightmostChar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 1/10/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;


        char t;
        int  last;
        while ((line = br.readLine()) != null && !line.isEmpty()) {


            String[] parts = line.split(",");
            t = parts[1].charAt(0);
            last = -1;

            char[] chars = parts[0].toCharArray();


            for (int i = 0; i < chars.length; i++) {

                if (chars[i] == t) last = i;

            }

            System.out.println(last);

        }

    }

}
