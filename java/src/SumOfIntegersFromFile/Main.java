package SumOfIntegersFromFile;

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


        int sum = 0;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            sum += Integer.parseInt(line.trim());
        }

        System.out.print(sum);
    }
}
