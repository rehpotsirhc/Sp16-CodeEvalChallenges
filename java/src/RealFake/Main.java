package RealFake;

import java.io.*;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));

       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;


        char[] digits;
        int    sum;
        while ((line = br.readLine()) != null) {


            digits = line.toCharArray();
            sum = 0;

            int counter = 0;
            for (int i = 0; i < digits.length; i++) {

                if (digits[i] == ' ') continue;

                int mul = 1;

                if (counter % 2 == 0) mul = 2;

                sum += mul * Character.getNumericValue(digits[i]);

                counter++;
            }

            if (sum % 10 == 0) System.out.println("Real");
            else System.out.println("Fake");

        }
    }

}
