package BlackorWhite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 1/9/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;

        boolean[][] carPark;

        while ((line = br.readLine()) != null && !line.isEmpty()) {


            String[] parts = line.split("\\|");

            int n = parts.length;

            carPark = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                char[] temp = parts[i].trim().toCharArray();

                for (int j = 0; j < n; j++) {

                    carPark[i][j] = (temp[j] == '1');
                }

            }

            int startI = 0;
            int startJ = 0;
            int boxSize = 1;


            int prevCount = 0;
            int curCount = 0;
            int savedCount = 0;
            boolean first = true;
            boolean atLeastOne1 = false;
            while (boxSize <= n) {


                for (int i = startI; i < startI + boxSize; i++) {
                    for (int j = startJ; j < startJ + boxSize; j++) {

                        if (carPark[i][j]) {
                            atLeastOne1 = true;
                            curCount++;
                        }

                    }
                }


                if (!first && curCount != prevCount) {
                    //increase box size and keep looking
                    boxSize++;
                    startI = 0;
                    startJ = 0;
                    prevCount = 0;
                    first = true;
                } else {
                    //keep box at current size and just move it

                    //try incrementing i, then j

                    startI++;

                    if (startI + boxSize > n) {
                        startJ++;
                        startI = 0;

                        if (startJ + boxSize > n) {
                            savedCount = curCount;
                            break;
                        }
                    }

                    first = false;
                    prevCount = curCount;


                }

                curCount = 0;


            }

            if (!atLeastOne1) {
                boxSize = 1;
            }
            String size = String.valueOf(boxSize);

            System.out.println(size + "x" + size + ", " + savedCount);


        }

    }


}
