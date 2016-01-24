package MthToLastElement;

import java.io.*;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));
        String         line;

        String[] chars;
        int      m;
        while ((line = br.readLine()) != null) {


            chars = line.split(" ");

            m = Integer.parseInt(chars[chars.length - 1]);

            if (chars.length - 1 - m < 0) continue;

            System.out.println(chars[chars.length - 1 - m]);


        }

    }

}
