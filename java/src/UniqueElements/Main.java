package UniqueElements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by chris on 1/10/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;


        Set<Integer>  set;
        StringBuilder sb;
        while ((line = br.readLine()) != null && !line.isEmpty()) {

            sb = new StringBuilder();
            set = new TreeSet<>();
            String[] parts = line.split(",");
            for (String s : parts) {
                set.add(Integer.parseInt(s));
            }

            int i = 0;
            for (Integer m : set) {

                i++;
                sb.append(m);

                if (i < set.size()) sb.append(',');

            }
            sb.append('\n');
            System.out.print(sb);

        }




    }
}
