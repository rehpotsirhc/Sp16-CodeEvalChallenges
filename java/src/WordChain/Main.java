package WordChain;

import java.io.*;
/**
 * Created by chris on 1/13/2016.
 */
public class Main {


    static String[] words;
    static int      maxLength;


    public static void main(String[] args) throws IOException {

         File file = new File(args[0]);
          BufferedReader br   = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while ((line = br.readLine()) != null) {


            words = line.split(",");
            maxLength = 0;


            chain("");
            if (maxLength > 1)
                System.out.println(maxLength);
            else
                System.out.println("None");


        }

    }


    private static void chain(String c) {


        //  System.out.println(c);
        String[] parts = c.split(",");

        int len = parts.length;

        if (len > maxLength)
            maxLength = len;

        for (String word : words) {
            if (c.isEmpty() || c.charAt(c.length() - 1) == word.charAt(0)) {

                if (c.isEmpty())
                    chain(word);
                else if (!contains(parts, word))
                    chain(c + "," + word);


            }
        }

    }


    private static boolean contains(String[] parts, String word) {


        for (String part : parts) {

            if (part.equals(word)) return true;

        }

        return false;
    }


}
