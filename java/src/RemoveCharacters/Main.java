package RemoveCharacters;

import java.io.*;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String   line;
        String[] parts;
        char[]   chars;
        char[]   sentence;
        char[]   sentenceNew;
        int      cRemoved;
        while ((line = br.readLine()) != null) {


            parts = line.split(",");

            sentence = parts[0].toCharArray();

            chars = parts[1].trim().toCharArray();

            cRemoved = 0;
            for (int i = 0; i < sentence.length; i++) {
                for (char c : chars) {
                    if (sentence[i] == c) {
                        cRemoved++;
                        sentence[i] = '\0';
                    }

                }

            }

            sentenceNew = new char[sentence.length - cRemoved];

            int index = 0;
            for (char c : sentence) {

                if (c != '\0') {
                    sentenceNew[index++] = c;
                }
            }


            System.out.println(String.valueOf(sentenceNew));
        }
    }
}
