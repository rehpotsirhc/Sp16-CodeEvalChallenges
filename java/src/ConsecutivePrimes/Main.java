package ConsecutivePrimes;

import java.io.*;
import java.util.Arrays;

/**
 * Created by chris on 1/13/2016.
 */
public class Main {


    static int count;


    public static void main(String[] args) throws IOException {

        // File file = new File(args[0]);
        // BufferedReader br   = new BufferedReader(new FileReader(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;
        int    N;
        while ((line = br.readLine()) != null) {
            N = Integer.parseInt(line);

            count = 0;


            boolean[] chars = new boolean[N];
            int[] perm = new int[N];

            permutation(perm, chars, 0);

            System.out.println(count / N);
        }

    }


    static void permutation(int[] perm, boolean[] chars, int index) {


        if (perm[perm.length - 1] != 0) {


          //  System.out.println(perm);
           // if (isConPrim(perm)) count++;

            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!chars[i]) {

                int tmp = i + 1;
                chars[i] = true;

                perm[index] = tmp;

                permutation(perm, chars, index + 1);
                chars[i] = false;
                perm[index] = 0;
            }

        }

    }

    static boolean isConPrim(int[] chars) {

        int     b;
        boolean isPrime;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length)
                b = chars[i + 1];
            else b = chars[0];

            isPrime = isPrime(chars[i] + b);

            if (!isPrime) return false;


        }

        return true;
    }


    static boolean isPrime(int a) {
        int start = a / 2;

        while (start > 1) {
            if (a % start == 0) return false;
            start--;
        }

        return true;
    }


}