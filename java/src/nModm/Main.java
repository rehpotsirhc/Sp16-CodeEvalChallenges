package nModm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 12/23/2015.
 */
public class Main {

    /*
    Find modulo(remainder) without modulo operator
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        int n, d;


        while((line = br.readLine()) != null) {
            String[] parts = line.split(",");

            n = Integer.parseInt(parts[0]);
            d = Integer.parseInt(parts[1]);


            // (n/d) is the integer part of the division, any remainder is lost
            // (n/d) * d is the biggest multiple of d less than n (the biggest number less than n that d divides cleanly into)
            // n - (n/d) * d is the remainder

            int r = n - (n/d) * d;

            System.out.println(r);


        }
    }
}
