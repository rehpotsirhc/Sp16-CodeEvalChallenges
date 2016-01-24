package OverlappingRectangles;

import java.io.*;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {



    public static void main(String[] args) throws IOException {
        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));

       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String         line;
        String[] parts;
        boolean over;
        while ((line = br.readLine()) != null)
        {

            parts = line.split(",");

            over = recOverlap(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]),
                    Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]),
                    Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));


         if(over)System.out.println("True");
            else System.out.println("False");





        }
    }


    private static boolean recOverlap(int aLowX, int aHighY, int aHighX, int aLowY, int bLowX, int bHighY, int bHighX, int bLowY) {


        return ((aHighX >= bLowX && bHighX >= aLowX) && (aHighY >= bLowY && bHighY >= aLowY))

                || ((bHighX >= aLowX && aHighX >= bLowX) && (bHighY >= aLowY && aHighY >= bLowY));

    }


}
