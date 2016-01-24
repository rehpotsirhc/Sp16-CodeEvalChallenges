package LuckyTickets;

import java.io.*;

/**
 * Created by chris on 1/13/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        // File           file = new File(args[0]);
        //  BufferedReader br   = new BufferedReader(new FileReader(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;
        int    length;
        int    sum;
        while ((line = br.readLine()) != null) {
            length = Integer.parseInt(line);


            sum = 1;
            int[] num = new int[length];

            for (int i = 0; i < num.length; i++) {
                if (i != (num.length / 2) - 1)
                    num[i] = 0;
                else num[i] = 1;
            }


            int i = num.length - 1;
            boolean end = false;

            while (!end) {

                if (num[i] < 9) num[i]++;
                else {

                    int j = i - 1;


                    while (j >= 0) {
                        if (j == 0 && num[j] == 9)
                        {
                            end = true;
                            break;
                        }

                        if (num[j] == 9) num[j] = 0;
                        else {
                            num[j]++;
                            break;
                        }
                        j--;
                    }

                    num[i] = 0;
                }

//                int lefthalf = 0;
//                int righthalf = 0;
//                for(int a = 0; a < num.length / 2;a++)
//                {
//                    lefthalf += num[a];
//                }
//
//                for(int a = num.length / 2; a < num.length;a++)
//                {
//                    righthalf += num[a];
//                }
//
//                if(righthalf == lefthalf) sum++;


            }

            System.out.println(sum);


        }

    }



}
