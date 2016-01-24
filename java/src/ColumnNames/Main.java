package ColumnNames;

import java.io.*;

/**
 * Created by chris on 1/15/2016.
 */
public class Main {


    static final int blank = -1;


    public static void main(String[] args) throws IOException {

       // File           f  = new File(args[0]);
     //   BufferedReader br = new BufferedReader(new FileReader(f));

       BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));


        String line;

        int[]  digits;
        String columnName;
        int    tmp;
        char   c;
        while ((line = br.readLine()) != null) {


            tmp = Integer.parseInt(line);

            digits = convertBase(tmp, 26);

            columnName = "";

            for (int i = 0; i < digits.length; i++) {
                tmp = digits[i];

                if (tmp == -1) break;


                c = Character.toChars(tmp + 65)[0];

                columnName = c + columnName;
            }

            System.out.println(columnName);


        }

    }


    /***
     * Variation of the algorithm that converts a number (n) to a different base (b)
     * Since the operators in Java operate on base 10 numbers, n is interpreted as a base 10 number
     *
     * @param n - the number to convert
     * @param b - the base to conver it to
     * @return the digits of the number least to most significant (left to right)
     */
    static int[] convertBase(int n, int b) {


        int   i      = 0;
        int[] digits = createEmptyDigitsArray(3);
        while (n != 0) {

            if (i >= digits.length) digits = expand(digits);
            digits[i] = (n-1) % b;

            n = (n - digits[i]) / b;

            i++;

        }

        return digits;


    }


    static int[] createEmptyDigitsArray(int size) {
        int[] digits = new int[size];
        for (int i = 0; i < size; i++) {
            digits[i] = blank;
        }

        return digits;
    }

    static int[] expand(int[] orig) {
        int[] newArray = new int[orig.length * 2];

        for (int i = 0; i < orig.length; i++) {
            newArray[i] = orig[i];
        }

        for (int i = orig.length; i < newArray.length; i++) {
            newArray[i] = blank;
        }

        return newArray;
    }
}
