package SumOfDigits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 1/8/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        StringBuilder sb = new StringBuilder();


        while ((line = br.readLine()) != null && !line.isEmpty()) {


            int sum = 0;
            char[] chars = line.trim().toCharArray();

            for(char c : chars)
            {
                sum += Character.getNumericValue(c);
            }

            sb.append(sum);
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
