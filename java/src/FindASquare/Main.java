package FindASquare;

import java.io.*;

/**
 * Created by chris on 1/12/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));

      //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String   line;
        String[] parts;
        while ((line = br.readLine()) != null) {


            line = line.replace("(", "").replace(")", "").replace(" ", "");
            parts = line.split(",");

            System.out.println(

                    isSquare2(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2]), Double.parseDouble(parts[3]),
                            Double.parseDouble(parts[4]), Double.parseDouble(parts[5]),
                            Double.parseDouble(parts[6]), Double.parseDouble(parts[7]))

            );

        }

    }


    private static boolean isSquare(double loc1X, double loc1Y, double loc2X, double loc2Y,
                                    double loc3X, double loc3Y, double loc4X, double loc4Y)

    {

        //pick a location, call it location 1
        double oneX = loc1X;
        double oneY = loc1Y;
        double twoX;
        double twoY;
        double threeX;
        double threeY;
        double fourX;
        double fourY;


        //locate the point that shares the same y as location 1, call it location 2
        if (oneY == loc2Y) {
            twoX = loc2X;
            twoY = loc2Y;
        } else if (oneY == loc3Y) {
            twoX = loc3X;
            twoY = loc3Y;
        } else if (oneY == loc4Y) {
            twoX = loc4X;
            twoY = loc4Y;
        } else return false;


        //locate the point that shares the same x as location 1, call it location 3
        if (oneX == loc2X) {
            threeX = loc2X;
            threeY = loc2Y;
        } else if (oneX == loc3X) {
            threeX = loc3X;
            threeY = loc3Y;
        } else if (oneX == loc4X) {
            threeX = loc4X;
            threeY = loc4Y;
        } else return false;

        //make sure location 2 and location 3 don't share any coordinates in common
        if (twoX == threeX || twoY == threeY) return false;


        //locate the point that shares no coordinates in common with point 1, call it location 4

        if (oneX != loc2X && oneY != loc2Y) {
            fourX = loc2X;
            fourY = loc2Y;
        } else if (oneX != loc3X && oneY != loc3Y) {
            fourX = loc3X;
            fourY = loc3Y;
        } else if (oneX != loc4X && oneY != loc4Y) {
            fourX = loc4X;
            fourY = loc4Y;
        } else return false;

        // make sure points 2 and 3 line up with point 4
        if (twoX != fourX) return false;
        if (threeY != fourY) return false;


        //now make sure the four points form a square and not a rectangle


        double oneEdge = Math.abs(twoX - oneX);

        return oneEdge == Math.abs(twoY - fourY) && oneEdge == Math.abs(threeX - fourX) && oneEdge == Math.abs(threeY - oneY);


    }


    /*

    This algorithm computes the distances between all four points (that's 6 distances in total)
    It then compares all 6 distances to each other (that's 15 comparisons)
    For each of these 6 distances, it keeps track of how many are equal to it
    If 4 of these distances are equal to three others (the four sides of the square each need to be equal to the other 3)
    &&
    2 of these distances are equal to one other distance (the two diagonals each need to be equal to the other)

    then we have a square
     */
    private static boolean isSquare2(double aX, double aY, double bX, double bY,
                                     double cX, double cY, double dX, double dY)

    {

        double[] distances = new double[6];

        distances[0] = distsq(aX, bX, aY, bY);
        distances[1] = distsq(aX, cX, aY, cY);

        distances[2] = distsq(aX, dX, aY, dY);

        distances[3] = distsq(bX, cX, bY, cY);

        distances[4] = distsq(bX, dX, bY, dY);
        distances[5] = distsq(cX, dX, cY, dY);


        double[] equalDistances = new double[6];


        for (int i = 0; i < distances.length - 1; i++) {
            for (int j = i + 1; j < distances.length; j++) {

                if (distances[i] == distances[j]) {
                    equalDistances[i] += 1;
                    equalDistances[j] += 1;
                }
            }
        }

        int countEqualSides = 0;
        int countDiagSides  = 0;


        for (int i = 0; i < distances.length; i++) {

            if (equalDistances[i] == 3) countEqualSides++;
            else if (equalDistances[i] == 1) countDiagSides++;
        }


        return countDiagSides == 2 && countEqualSides == 4;

    }

    private static double distsq(double x1, double x2, double y1, double y2) {
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
    }
}
