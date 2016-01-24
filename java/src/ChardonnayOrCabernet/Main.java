package ChardonnayOrCabernet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 1/10/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] words;
        String[] parts;
        char[]   chars;

        List<String> w;


        for (int count = 1; count <= 40; count++) {

            w = new ArrayList<>();

            parts = br.readLine().split("\\|");

            chars = parts[1].trim().toCharArray();
            words = parts[0].trim().split("\\s");


            for (int i = 0; i < words.length; i++) {

                boolean contains = false;
              //  String toAdd = words[i];
                char[] tmp = words[i].toCharArray();
                for (char c : chars) {
                    contains = false;

                    for (int a = 0; a < tmp.length; a++) {
                        if (c == tmp[a]) {

                            String tmpS = "";
                            for (int b = 0; b < words[i].length(); b++) {
                                if (a != b) tmpS += words[i].charAt(b);
                            }

                           // words[i] = tmpS;
                            tmp = tmpS.toCharArray();

                            contains = true;
                            break;
                        }
                    }

                    if (!contains) break;
                }

                if (contains) w.add(words[i]);

            }


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < w.size(); i++) {


                sb.append(w.get(i));
                if (i < w.size() - 1) sb.append((' '));


            }

            String toPrint;

            if (sb.toString().isEmpty()) toPrint = "False";
            else toPrint = sb.toString();

            if (count < 40) System.out.println(toPrint);
            else System.out.print(toPrint);


        }


    }
}
