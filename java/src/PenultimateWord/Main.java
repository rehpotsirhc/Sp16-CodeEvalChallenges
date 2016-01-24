package PenultimateWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by chris on 1/10/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String   line;
        String[] words;

        while ((line = br.readLine()) != null && !line.isEmpty()) {


            words = line.split("\\s");

            System.out.println(words[words.length - 2]);

        }


    }
}
