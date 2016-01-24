package ToPiOrNotToPi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {
//        File           file = new File(args[0]);
//        BufferedReader br   = new BufferedReader(new FileReader(file));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String         line;


        int index;


        while ((line = br.readLine()) != null)
        {

            System.out.println(BPP(Integer.parseInt(line)));

        }
    }


    private static int BPP(int n) {
        int    sum          = 0;

        for (int k = 0; k <= n; k++) {
            int ek = 8 * k;

            sum += ((4 / (ek + 1)) - (2 / (ek + 4)) - (1 / (ek + 5)) - (1 / (ek + 6))) / Math.pow(16, k);

        }

        return sum;

    }


//    private static int convertBase(double num, int K) {
//        int index = 0;
//        List<Integer> digit = new ArrayList<>();
//        while (num != 0) {
//           double remainder = num % K;  // assume K > 1
//            num = num / K;  // integer division
//            digit.add(index, remainder);
//            index++;
//        }
//
//        String newNumS = "";
//        for(Integer i : digit)
//        {
//            newNumS += i;
//        }
//
//        return Integer.parseInt(newNumS);
//
//
//    }

}
