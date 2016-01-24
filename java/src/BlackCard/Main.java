package BlackCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 1/6/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] line;
        int      testCases = 40;


        while (testCases-- > 0) {
            line = br.readLine().split("\\|");

            String[] namesS = line[0].trim().split(" ");
            int number = Integer.parseInt(line[1].trim());

            List<String> names = new ArrayList<>();


            for (String s : namesS) {
                names.add(s);
            }

            int counter = 1;
            int i = 0;
            while (names.size() > 1) {
                if (counter == number) {
                    names.remove(i);
                    counter = 0;
                    i = -1;
                }
                counter++;
                i++;
                if (i >= names.size()) i = 0;
            }

            System.out.println(names.get(0));

        }

    }


}
