package MultiplesOfANumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by chris on 12/23/2015.
 */
class Main {



    /*
    CAN'T USE DIVISION OR MODULO
     */



    public static void main(String[] args) throws IOException
    {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        int x, n;


        while((line = br.readLine()) != null)
        {
            String[] parts = line.split(",");

            x = Integer.parseInt(parts[0]);
            n = Integer.parseInt(parts[1]);
            System.out.println(smallestMultBigger(n, n, x));
        }


    }


    /*
    returns the smallest multiple of nOrig which is bigger than or equal to x
    nOrig is a multiple of 2
     */
    private static int smallestMultBigger(int nOrig, int n, int x)
    {


        if(n >= x || n <=0) return n;
        else return smallestMultBigger(nOrig, n + nOrig, x);
    }

}
