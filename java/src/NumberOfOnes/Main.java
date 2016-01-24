package NumberOfOnes;

import java.io.*;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        //File           file = new File(args[0]);
        //BufferedReader br   = new BufferedReader(new FileReader(file));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;
        byte[] binary;
        int    count;
        while ((line = br.readLine()) != null) {

            binary = toBinary(Integer.parseInt(line));
            count = 0;
            for (int i = 0; i < binary.length; i++) {
                if (binary[i] == 1) count++;
            }

            System.out.println(count);


        }

    }

    static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }


    /*

    converts a decimal (10 based) number to a binary based number by counting in binary
     */
    static byte[] toBinary(int num) {


        byte[] a;

        if (num == 0) {
            a = new byte[0];
            return a;
        }

        num = Math.abs(num);

        int l = (int) Math.ceil(log(num, 2)) + 1;

        a = new byte[l];

        for (int i = 1; i <= num; i++) {

            int j = a.length - 1;
            if (a[j] == 0)
                a[j] = 1;
            else {


                while (j >= 0 && a[j] == 1) {
                    a[j--] = 0;
                }

                a[j] = 1;


            }


        }


        return a;
    }


    private static void printNum(byte[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
