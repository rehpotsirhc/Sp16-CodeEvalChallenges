package HexToDecimal;

import java.io.*;

/**
 * Created by chris on 1/12/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;
        while ((line = br.readLine()) != null) {


            System.out.println(hexToDecimal(line));

        }
    }

    static int hexToDecimal(String decimal) {

        int a = 97;

        int[] digits = new int[6];

        for (int i = 0; i < digits.length; i++) {
            digits[i] = i + 10;
        }

        char[] decChars = decimal.toCharArray();

        int mul = 1;
        int sum = 0;
        for (int i = decChars.length - 1; i >= 0; i--) {


            char tmp = decChars[i];

            if (tmp >= a)
                sum += mul * digits[tmp - a];
            else sum += mul * Character.getNumericValue(tmp);


            mul *= 16;


        }


        return sum;


    }

}    /*



    static int hexToDecimal(String decimal)
    {

        int a = 97;

        int[] digits = new int[6];

        for(int i = 0; i < digits.length;i++)
        {
            digits[i] = i + 10;
        }

        char[] decChars = decimal.toArrayList();

        int mul = 1;
        int sum;
        for(int i = decChars.length - 1; i >= 0; i--)
        {


            char tmp = decChars[i];

            if(tmp >=a)
                sum+= mul * digits[tmp - a];
            else sum+= mul * tmp;



            mul *= 16;


        }


        return sum;


    }





     */



