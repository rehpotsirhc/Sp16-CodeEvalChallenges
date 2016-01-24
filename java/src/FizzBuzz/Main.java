package FizzBuzz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 1/10/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        int     X;
        int     Y;
        int     n;
        String  game;
        boolean byX;
        boolean byY;
        while ((line = br.readLine()) != null && !line.isEmpty()) {


            String[] parts = line.split(" ");

            X = Integer.parseInt(parts[0]);
            Y = Integer.parseInt(parts[1]);
            n = Integer.parseInt(parts[2]);

            game = "";
            for (int i = 1; i <= n; i++) {

                byX = i % X == 0;
                byY = i % Y == 0;
                if (byX && byY) game += "FB ";
                else if (byX) game += "F ";
                else if (byY) game += "B ";
                else game += i + " ";

            }

            System.out.println(game.trim());

        }
    }
}
