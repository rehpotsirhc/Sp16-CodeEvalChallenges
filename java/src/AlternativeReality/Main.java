package AlternativeReality;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 1/7/2016.
 */
public class Main {


    //https://www.codeeval.com/open_challenges/223/



    static List<Integer> denominations;
    static int           count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        denominations = new ArrayList<>();

        denominations.add(50);
        denominations.add(25);
        denominations.add(10);
        denominations.add(5);
        denominations.add(1);


        while ((line = br.readLine()) != null && !line.isEmpty()) {

            countTree(Integer.parseInt(line.trim()), Integer.MAX_VALUE);
            System.out.println(count);
            count = 0;
        }

    }


    private static void countTree(int curAmount, int curDenom) {


        if (curDenom < Integer.MAX_VALUE)
            curAmount = curAmount - curDenom;

        if (curAmount == 0) {
            count++;
            return;
        }


        for (Integer denom : denominations) {
            if (curAmount >= denom && denom <= curDenom) {
                countTree(curAmount, denom);
            }
        }

    }



}
