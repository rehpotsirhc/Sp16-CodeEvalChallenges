package SelfDescribingNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 1/10/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;


        int[] nums;
        int[] numsCopy;

        boolean con;
        while ((line = br.readLine()) != null && !line.isEmpty()) {


            con = false;
            char[] chars = line.toCharArray();
            nums = new int[chars.length];
            numsCopy = new int[chars.length];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = Character.getNumericValue(chars[i]);
                numsCopy[i] = Character.getNumericValue(chars[i]);

            }

            for(int i = 0; i < nums.length;i++)
            {
                if(nums[i] <= nums.length-1) numsCopy[nums[i]]--;
                else
                {
                    System.out.println("0");
                    con = true;
                    break;
                }
            }
            if(con) continue;

            for(int i = 0; i < numsCopy.length;i++)
            {
                if(numsCopy[i] != 0)
                {
                    System.out.println("0");
                    con = true;
                    break;
                }
            }
            if(con) continue;
            System.out.println("1");
        }


    }
}
