package FibonacciSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 1/10/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException{


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line;

        double sqrt5 = Math.sqrt(5);
        double s1 = 1 / sqrt5;
        double s2 = (1 + sqrt5) / 2;

    while((line=br.readLine())!=null&&!line.isEmpty())
    {


        System.out.println(fibonnacci(Integer.parseInt(line), s1, s2));

    }
}


    private static int fibonnacci(int n, double s1, double s2)
    {

        return (int)Math.round( s1 * Math.pow(s2, n));

    }

}
