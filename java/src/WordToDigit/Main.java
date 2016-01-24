package WordToDigit;

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

        StringBuilder sb;
        while ((line = br.readLine()) != null) {

            parts = line.split(";");
            sb = new StringBuilder();

            for (String s : parts) {

                sb.append(toDigit(s));


            }
            System.out.println(sb);

        }

    }

    static int toDigit(String s) {
        if (s.equals("zero")) return 0;
        if (s.equals("one")) return 1;
        if (s.equals("two")) return 2;
        if (s.equals("three")) return 3;
        if (s.equals("four")) return 4;
        if (s.equals("five")) return 5;
        if (s.equals("six")) return 6;
        if (s.equals("seven")) return 7;
        if (s.equals("eight")) return 8;
        if (s.equals("nine")) return 9;
        return 0;

    }

}
