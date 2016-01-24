package FirstNonRepeatedCharacter;

import java.io.*;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));

        //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;


        int[]  alphabetCount;
        char[] s;

        while ((line = br.readLine()) != null) {

            alphabetCount = new int[127];
            s = line.toCharArray();

            for (char c : s) {
                alphabetCount[c]++;
            }

            for (char c : s) {
                if (alphabetCount[c] == 1) {
                    System.out.println(c);
                    break;
                }
            }


        }

    }
}
