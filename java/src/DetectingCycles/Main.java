package DetectingCycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 1/5/2016.
 */
public class Main {





    /*
    https://www.codeeval.com/open_challenges/5/



    Pseudo code:

    Read line character by character and save them in a string
    For each new character, check from the beginning of the string to see if the new character matches
        if it does, a cycle has been detected so check subsequent characters for matches to see how long the cycle is


    Detailed pseudo code


    String line = (read in line);

    if(line == null || line.isEmpty() || line.length == 1) //no cycle can be found


    StringBuilder cycle;
    for(int i = 1;int a=0; i < line.length;i++){

        char c = line.charAt[i];
        if(c == line[a])
        {
            cycle.append(c).append(' ');
            a++;
        }
        else if(a >0) break;

    }


     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        String cycle;
        while ((line = br.readLine()) != null && !line.isEmpty() && line.length() > 1) {

            cycle = "";
            String[] parts = line.split(" ");

            boolean stop = false;
            for (int i = 0; i < parts.length - 1; i++) {


                if (cycle.isEmpty()) {
                    for (int j = i + 1; j < parts.length; j++) {

                        int num = Integer.parseInt(parts[i].trim());
                        String numS = String.valueOf(num);

                        if (String.valueOf(Integer.parseInt(parts[j].trim())).equals(numS) && !cycle.contains(numS)) {
                            cycle += numS + " ";
                            i++;
                        } else if (!cycle.isEmpty()) {
                            stop = true;
                            break;
                        }
                        if (i >= parts.length - 1) {

                            stop = true;
                            break;
                        }

                    }
                }

                if (stop) break;


            }

            cycle = cycle.trim();
            if (!cycle.isEmpty()) System.out.println(cycle);
        }
    }


}
