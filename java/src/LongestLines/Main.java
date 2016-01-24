package LongestLines;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Created by chris on 1/9/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int    maxLength = Integer.parseInt(br.readLine());
        String line;

        TreeMap<Integer, String> linesSorted = new TreeMap<>();

        while ((line = br.readLine()) != null && !line.isEmpty()) {

            linesSorted.put(line.length(), line);

        }


        while (maxLength-- > 0) {

            Integer i = linesSorted.lastEntry().getKey();

            System.out.println(linesSorted.lastEntry().getValue());
            linesSorted.remove(i);
        }
    }
}
