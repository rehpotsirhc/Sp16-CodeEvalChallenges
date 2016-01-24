package PointInCircle;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;

        //Center: (2.12, -3.48); Radius: 17.22; Point: (16.21, -5)


        Pattern p = Pattern.compile("([-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?)");

        Matcher m;

        double[] nums = new double[5];


        while ((line = br.readLine()) != null) {


            m = p.matcher(line);

            int i = 0;
            while (m.find()) {

                nums[i++] = Double.parseDouble(m.group());


            }

            System.out.println(insideCircle(nums[0], nums[1], nums[3], nums[4], nums[2]));


        }

    }

    static boolean insideCircle(double x1, double y1, double x2, double y2, double radius) {
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) <= Math.pow(radius, 2);
    }
}
