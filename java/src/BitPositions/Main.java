package BitPositions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 12/23/2015.
 */
class Main {



    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while((line = br.readLine()) != null)
        {
            String[] sepLine = line.split(",");

            int num = Integer.parseInt(sepLine[0]);
            int p1 = Integer.parseInt(sepLine[1]) -1;
            int p2 = Integer.parseInt(sepLine[2]) -1;



            System.out.println(String.valueOf(getBit(num, p1) == getBit(num, p2)).toLowerCase());



        }
    }

    private static byte getBit(int num, int position)
    {
        //the >> operator shifts the bits of "num" #positions to the right
        //this will result in the bit at #position in num being in the furthest right position
        //&(AND) bitwise operator returns a string of bits with 1s in the positions where both operands have 1s and with 0s in the positions where either operands have 0
        //combining these two operators, the returned byte will have a 1 in the last position iff num has a 1 in the last position
        //because the integer 1 has a 1 in the last position of its bit representation
        return (byte)((num >> position) & 1);
    }
}
