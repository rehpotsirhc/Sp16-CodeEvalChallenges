package RacingCars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 1/3/2016.
 */
public class Main {


    //https://www.codeeval.com/open_challenges/136/

    /*
    BASIC ALGORITHM:

    Represent track as matrix (M) of characters
    Goal is to get the car the last row of M
    Current (location of car) row index is i
    Current column index is j

    Set i = 0 and j = 0 initially

    Recursively:
        find nearest checkpoint and gate by looking at higher and lower values for i
        if checkpoint found and its location is greater than i, replace characters in between with / (right turn), if lower replace with \ (left turN0
        if no checkpoint found, use the closest gate, but do the same thing
        increment j


    PSEUDO CODE (for practicing for interview questions):

        M = (populate M from input)


        void start()
        {
            go(0, 0);
        }

        void go(int i, int j)
        {


            int inxOfCP = -1;
            int indxOfG = -1;


            //search right from i to find
            for(int a = i; a < M.length;a++)
            {

                if(M[a][j] == 'C')
                {
                    indxOfCP = a;
                    break;
                }
               if(M[a][j] == 'C' && indxOfG != -1)
                {
                    indxOfG = a;
                }
            }
            for(int a = i-1; a> 0; a--)
             {
                if(closer(j, i, a, indxOfCP)
                {
                    indxOfCP = a;
                    break;
                }
                if(closer(j, i, a, indxOfG) indxOfG = a;
             }



            int indexToGoTo = -1;

            if(indxOfCP == -1) indexToGoTo = indxOfG;
            else indexToGoTo = inxOfCP;

            if(indexToGoTo == -1) return;


            if(indexToGoTo == i) M[i][j] = '|';
            else if(indexToGoTo > i)
            {

                    for(int a = i+1; a <=indexToGoTo; a++)
                    {
                        M[i][j] = '/';
                    }


            }
             else
                {
                 for(int a = i-1; a >= indexToGoTo; a++)
                    {
                        M[i][j] = '\';
                    }
                }

            go(i, j++);

        }

        boolean closer(int j, int i, int newI, int oldI, char c)
        {
         return (M[newI][j] == c && (oldI == -1 || Math.abs(i - newI) < Math.abs(i - oldI));
        }





     */


    static int lineCount = 50;
    static int charCount = 12;

    static char[][] M = new char[lineCount][charCount];


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        for (int j = 0; j < lineCount; j++) {
            M[j] = br.readLine().toCharArray();
        }

        start();

        StringBuilder sb = new StringBuilder();


        for (int j = 0; j < M.length; j++) {
            for (int i = 0; i < M[0].length; i++) {
                sb.append(M[j][i]);
            }
            if(j < M.length - 1) sb.append("\n");
        }


        System.out.print(sb.toString());


    }


    static void start() {
        go(0, 0);
    }

    static void go(int i, int j) {


        if (j == lineCount) return;

        int indxOfCP = -1;
        int indxOfG  = -1;


        //search right from i to find
        for (int a = i; a < M[0].length; a++) {

            if (M[j][a] == 'C') {
                indxOfCP = a;
                break;
            }
            if (M[j][a] == '_' && indxOfG == -1) {
                indxOfG = a;
            }
        }
        if (indxOfCP != i) {
            //search left from i to find a closer one
            for (int a = i - 1; a >= 0; a--) {
                if (closer(j, i, a, indxOfCP, 'C')) {
                    indxOfCP = a;
                    break;
                }
                if (closer(j, i, a, indxOfG, '_')) indxOfG = a;
            }
        }


        int prevI = i;

        if (indxOfCP == -1) i = indxOfG;
        else i = indxOfCP;

        if (i == -1) return;


        if (prevI == i || j == 0 || j == lineCount - 1) M[j][i] = '|';
        else if (i > prevI) {

            for (int a = prevI + 1; a <= i; a++) {
                M[j][a] = '\\';
            }


        } else {
            for (int a = prevI - 1; a >= i; a--) {
                M[j][a] = '/';
            }
        }

        go(i, ++j);

    }

    static boolean closer(int j, int i, int newI, int oldI, char c) {
        return (M[j][newI] == c && (oldI == -1 || Math.abs(i - newI) < Math.abs(i - oldI)));
    }


}
