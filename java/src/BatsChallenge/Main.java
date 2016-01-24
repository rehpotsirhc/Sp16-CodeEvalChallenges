package BatsChallenge;

import java.io.*;

/**
 * Created by chris on 1/14/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {


        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;


        String[] parts;
        int      l, d, n;

        int batsRight;
        int batsLeft;
        while ((line = br.readLine()) != null) {
            parts = line.split(" ");

            l = Integer.parseInt(parts[0]);
            d = Integer.parseInt(parts[1]);
            n = Integer.parseInt(parts[2]);

            batsRight = 0;
            batsLeft = 0;

            int[] existingBats = null;
            if (n > 0) {
                existingBats = new int[n];

                for (int i = 3, index = 0; i < n + 3; i++, index++) {

                    existingBats[index] = Integer.parseInt(parts[i]);

                }


            }

            //go from left to right
            for (int i = 6; i <= l - 6; ) {

                if (existingBats != null) {
                    //check existing bats

                    int tmp = batExists(i, existingBats, d);
                    if (tmp > i) {
                        i = tmp;
                    } else {
                        if (tmp == -1)
                            batsRight++;

                        i += d;
                    }

                } else {
                    batsRight++;
                    i += d;
                }

            }

            System.out.println(batsRight);


            //go from right to left

        }


    }


    static int batExists(int batCoord, int[] existingBats, int d) {


        for (int i = batCoord - d + 1; i <= batCoord + d - 1; i++) {

            for (Integer bc : existingBats) {
                if (bc == i) return i;
            }
        }

        return -1;

    }


}
