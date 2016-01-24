package EvenNumbers;

import java.io.*;

/**
 * Created by chris on 1/15/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           f  = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(f));

      //  BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));


        String line;

        while ((line = br.readLine()) != null) {


            if (Integer.parseInt(line) % 2 == 0)
                System.out.println("1");
            else
                System.out.println("0");
        }



    }


}
