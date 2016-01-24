package BeautifulStrings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by chris on 1/7/2016.
 */
public class Main {


    //https://www.codeeval.com/open_challenges/83/


    /*

    Strings will be cleaned (removing all non letters) using regular expression
    Letters a-z will be held in an integer array 26 chars long. Withe A,a --> 0, B,b --> 1... Z,z --> 26
    Using the ASCII decimal values of these characters, this can be done in O(N), where N is the length of the string
    The values in this array will be the frequency of occurence
    Then do 26 scans over this array to find the biggest, then the next biggest...etc.




    public static void main(String[] args)
    {



        int a = '97';
        int A = '65';
        //holds letter frequency counts
        int[] letters = new int[26];

        //holds the frequency counts in reverse-order, without knowing which letter belongs to which frequency
        int[] counts = new int[26];

        char[] sentence = (populate sentence and remove all non-letters);

        for(char c : sentence)
        {

            //upper and lowercase letters get mapped to same index
            int asciiC = (int)c;
            int offset = 0;
            if(asciiC > A + 25) //is lower case
                offset = a;
            else
                offset = A;

            letters[asciiC - offset] += 1;

        }


        for(int i = 0; i < letters.length;i++)
        {

            for(int j = counts.length-1; j >=0;j--)
            {

                if(letters[i] > counts[j])
                {

                counts[j] = letters[i];
                break;

                }

            }
        }


        int beauty = 0;

        for(int j = 0; j < counts.length;j++)
        {

            beauty += counts[j] * (j+1);

        }

        System.out.prtinln(beauty);






    }



     */


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {


            int a = 97;
            int A = 65;
            //holds letter frequency counts
            int[] letters = new int[26];


            char[] sentence = line.replaceAll("[^A-Za-z]", "").toCharArray();


            for (char c : sentence) {

                //upper and lowercase letters get mapped to same index
                int asciiC = (int) c;
                int offset = 0;
                if (asciiC > A + 25) //is lower case
                    offset = a;
                else
                    offset = A;

                letters[asciiC - offset] += 1;

            }


            int beauty = 0;
          //  int lastMax = Integer.MAX_VALUE;
            int currentMax = 0;
            int maxIndex = 0;

            int value = 26;

            while (value > 0) {
                for (int i = 0; i < letters.length; i++) {
                    if (letters[i] > currentMax) {
                        currentMax = letters[i];
                        maxIndex = i;
                    }
                }


                letters[maxIndex] = 0;
                beauty += currentMax * value;

                currentMax = 0;
                maxIndex = 0;
                value--;
            }


            System.out.println(beauty);
        }


    }


}
