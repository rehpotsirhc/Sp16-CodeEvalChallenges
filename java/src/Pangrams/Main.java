package Pangrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 1/8/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        int a = 97;

        boolean[]     letters;
        StringBuilder sb;

        while ((line = br.readLine()) != null && !line.isEmpty()) {

            letters = new boolean[26];

            line = line.toLowerCase();

            for (Character c : line.toCharArray()) {

                int index = ((int) c) - a;
                if (index >= 0 && index < 26)
                    letters[index] = true;
            }

            sb = new StringBuilder();
            boolean empty = true;
            for (int i = 0; i < letters.length; i++) {
                if (!letters[i]) {
                    empty = false;
                    sb.append((char) (i + a));
                }
            }

            if (empty)
                System.out.println("NULL");
            else
                System.out.println(sb.toString());
        }
    }


}
