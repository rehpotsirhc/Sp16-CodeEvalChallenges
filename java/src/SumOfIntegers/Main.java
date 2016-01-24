package SumOfIntegers;

import java.io.*;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {



    /*

    https://www.codeeval.com/open_challenges/17/


    this is a maximum contiguous subarray problem


    solve using Kadane's algorithm:




    static int kadane(int[] a)
    {

    if(a.length == 0) return 0;
    if(a.length == 1) return a[0];

        int maxEndingAt = a[0];
        int max = maxEndingAt;

        for(int i = 1; i < a.length;i++)
        {

            //take just new integer or add it to the running sum
            maxEndingAt = Math.max(a[i], maxEndingAt + a[i]);

            //keep track of overall maximum;
            max = Math.max(max, maxEndingAt);

        }

        return max;

    }



     */

    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;


        while ((line = br.readLine()) != null) {
            System.out.println(kadane(line.split(",")));


        }

    }


    static int kadane(String[] a) {

        if (a.length == 0) return 0;
        if (a.length == 1) return Integer.parseInt(a[0]);

        int maxEndingAt = Integer.parseInt(a[0]);
        int max         = maxEndingAt;
        int tmp;
        for (int i = 1; i < a.length; i++) {

            //take just new integer or add it to the running sum
            tmp = Integer.parseInt(a[i]);
            maxEndingAt = Math.max(tmp, maxEndingAt + tmp);

            //keep track of overall maximum;
            max = Math.max(max, maxEndingAt);

        }

        return max;

    }
}
