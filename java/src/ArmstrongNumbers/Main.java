package ArmstrongNumbers;

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


        int    n;
        char[] chars;
        int    num;
        int    sum;
        while ((line = br.readLine()) != null && !line.isEmpty()) {


            chars = line.toCharArray();
            n = chars.length;

            num = Integer.parseInt(line);
            sum = 0;

            for (int i = 0; i < n; i++) {
                sum += Math.pow(Character.getNumericValue(chars[i]), n);
            }

            if (num == sum) System.out.println("True");
            else System.out.println("False");


        }


    }
}

