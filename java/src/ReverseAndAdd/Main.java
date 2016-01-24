package ReverseAndAdd;

import java.io.*;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {


    static int count;

    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));

       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;
        while ((line = br.readLine()) != null) {

            count = 0;
            String s = reverseAndAdd(line);


            System.out.println(count + " " + s);


        }

    }

    static String reverseAndAdd(String numS) {

        count++;

        StringBuilder sb = new StringBuilder();

        for (int i = numS.length() - 1; i >= 0; i--) {
            sb.append(numS.charAt(i));
        }

        long sum = Long.parseLong(numS) + Long.parseLong(sb.toString());

        String reversedSum = String.valueOf(sum);

        if (isPalindrome(reversedSum)) return reversedSum;
        else {
            return reverseAndAdd(reversedSum);
        }


    }

    static boolean isPalindrome(String s) {

        int a = 0;
        int z = s.length() - 1;
        while (a < z) {

            if (s.charAt(a) != s.charAt(z)) return false;
            else {
                a++;
                z--;
            }


        }

        return true;


    }
}
