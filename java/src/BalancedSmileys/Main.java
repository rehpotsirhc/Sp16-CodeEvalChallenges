package BalancedSmileys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chris on 1/9/2016.
 */
public class Main {

    /*


     static boolean balancedOneExists;

    public static void main(String[] args) throws IOException
    {


        BufferedReader br = new BufferedReader(new InputStreamRader(System.in));

        String line;

        while((line = br.readLine()) != null & !line.isEmpty())
        {

            balancedOneExists = false;


            isBalanced(0, line.toCharArray());

            if( balancedOneExists) System.out.println("YES");
            else System.out.println("NO");

        }

    }




    private static boolean isBalanced(int count, char[] sub)
    {

        for(int i = 0; i < sub.length;i++)
        {

            if(i < sub.length - 1 && sub[i] == ':' && (sub[i+1] == ')' || sub[i+1] == '('))
            {

                //treat it like a paren
                int newCount = count;
                if(sub[i+1] == ')')  newCount--;
                else newCount++;

                isBalanced(newCount, Arrays.copyOfRange(sub, i+2, sub.length));


                //treat it like a smiley or frowney
                isBalanced(count, Arrays.copyOfRange(sub, i+2, sub.length))

            }
            else if(sub[i] == ')') count--;
            else if(sub[i] == '(') count++;


            //not balanced
            if(count < 0) return false;

        }


        if(count==0) balancedOneExists = true;

        return count ==0;

    }


    */


    static boolean balancedOneExists;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        List<String> lines = new ArrayList<>();

        while ((line = br.readLine()) != null && !line.isEmpty()) {


            lines.add(line);



        }

        for(int i = 0; i < lines.size();i++)
        {
            balancedOneExists = false;


            isBalanced(0, lines.get(i).toCharArray());

            String toPrint;



            if (balancedOneExists) toPrint = "YES";
            else toPrint = "NO";

            if(i < lines.size() - 1) System.out.println(toPrint);
            else System.out.print(toPrint);
        }

    }


    private static boolean isBalanced(int count, char[] sub) {

        for (int i = 0; i < sub.length; i++) {

            if (i < sub.length - 1 && sub[i] == ':' && (sub[i + 1] == ')' || sub[i + 1] == '(')) {

                //treat it like a paren
                int newCount = count;
                if (sub[i + 1] == ')') newCount--;
                else newCount++;

                isBalanced(newCount, Arrays.copyOfRange(sub, i + 2, sub.length));


                //treat it like a smiley or frowney
                isBalanced(count, Arrays.copyOfRange(sub, i + 2, sub.length));

            } else if (sub[i] == ')') count--;
            else if (sub[i] == '(') count++;


            //not balanced
            if (count < 0) return false;

        }


        if (count == 0) balancedOneExists = true;

        return count == 0;

    }
}
