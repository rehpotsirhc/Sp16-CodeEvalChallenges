package HappyNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 12/23/2015.
 */
public class Main {




    private static class Happy
    {

        private List<Integer> history;
        private boolean isHappy;

        public Happy(int positiveNumber) {

            history = new ArrayList<>();
            history.add(positiveNumber);
            isHappy = findHappy(positiveNumber);

        }


        private boolean findHappy(int number)
        {

            if(number == 1) return true; //its a happy number :)

            char[] digits = String.valueOf(number).toCharArray();

            int sum = 0;
            for(char c : digits)
            {
                sum += Math.pow(Character.getNumericValue(c), 2);
            }

            if(history.contains(sum)) return false; //we've encountered a loop, so its not happy :(

            history.add(sum);

            return findHappy(sum);
        }

        public int isHappy()
        {
            if(isHappy) return 1;
            else return 0;
        }

    }




    /*
    finds happy numbers

    see https://www.codeeval.com/open_challenges/39/
     */


    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;



        while((line = br.readLine()) != null) {

            Happy h = new Happy(Integer.parseInt(line));
            System.out.println(h.isHappy());

        }

    }




}
