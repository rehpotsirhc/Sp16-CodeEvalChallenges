package MinimumCoins;

import java.io.*;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));

      //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;
        int    amount;
        int    coinCount;

        while ((line = br.readLine()) != null) {


            amount = Integer.parseInt(line);
            coinCount = 0;

            while (amount >= 5) {
                amount -= 5;
                coinCount++;
            }
            while (amount >= 3) {
                amount -= 3;
                coinCount++;
            }

            while (amount > 0) {
                amount -= 1;
                coinCount++;
            }


            System.out.println(coinCount);
        }

    }

}
