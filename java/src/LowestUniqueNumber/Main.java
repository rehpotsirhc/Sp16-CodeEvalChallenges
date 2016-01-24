package LowestUniqueNumber;

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


        int[] counts;
        int[] nums;
        while ((line = br.readLine()) != null && !line.isEmpty()) {


            counts = new int[10];

            String[] parts = line.split("\\s");
            nums = new int[parts.length];

            for (int i = 0; i < nums.length; i++) {

                int tmp = Integer.parseInt(parts[i]);
                counts[tmp]++;
                nums[i] = tmp;
            }

            String toPrint = "";

            for (int i = 0; i < counts.length; i++) {
                if (counts[i] == 1) {

                    int index = 0;
                    for(int a = 0; a<nums.length;a++)
                    {
                        if(nums[a] == i) index = a;

                    }

                    toPrint = String.valueOf(index+1);
                    break;
                }
            }

            if (!toPrint.isEmpty()) System.out.println(toPrint);
            else System.out.println("0");


        }


    }
}
