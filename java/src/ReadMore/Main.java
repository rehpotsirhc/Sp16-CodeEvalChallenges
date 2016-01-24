package ReadMore;

import java.io.*;

/**
 * Created by chris on 1/14/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {
        String toAppend = "... <Read More>";


        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        int    leaveItLength = 55;
        int    trimLength    = 40;


        while ((line = br.readLine()) != null) {


            if (line.length() <= leaveItLength)
                System.out.println(line);
            else {

                line = line.substring(0, trimLength);

                int lastSpace = line.lastIndexOf(' ');
                if (lastSpace != -1)
                    line = line.substring(0, lastSpace);

                System.out.println(line + toAppend);
            }

        }
    }
}
