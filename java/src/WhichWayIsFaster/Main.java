package WhichWayIsFaster;

import java.io.*;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {


    //   https://www.codeeval.com/open_challenges/207/


    static char[][] map;

    static int[][] travelCost;


    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] rows;

        int startI = 0;
        int startJ = 0;
        int endI   = 0;
        int endJ   = 0;


        int count = 40;

        while (count-- > 0) {


            rows = br.readLine().trim().split("\\|");
            map = new char[rows.length][rows[0].trim().length()];

            char[] row;
            for (int i = 0; i < rows.length; i++) {

                row = rows[i].trim().toCharArray();

                for (int j = 0; j < row.length; j++) {

                    if (row[j] == 'F') {
                        endI = i;
                        endJ = j;
                    } else if (row[j] == 'S') {
                        startI = i;
                        startJ = j;
                    }

                    map[i][j] = row[j];
                }

            }

            travelCost = new int[map.length][map[0].length];
            travel(startI, startJ, -1, -1, 0, true, "");
            System.out.println(travelCost[endI][endJ]);

        }


    }


    static void travel(int i, int j, int prevI, int prevJ, int prevDist, boolean onLand, String breadCrumbs) {

        if (map[i][j] == '^') return;


        String squareName = String.valueOf(i) + String.valueOf(j);

        if (breadCrumbs.contains(squareName)) return;
        else {

            breadCrumbs += squareName + " ";

            int addedDist = 0;

            if (prevI != -1 && prevI != -1) {
                if (onLand) addedDist += 2;
                else addedDist += 1;

                if (map[i][j] == 'P') {
                    addedDist += 1;
                    onLand = !onLand;
                }
            }


            int newPending = prevDist + addedDist;

            //if we haven't been at i, j or going through prevI, prevJ gets us to i, j faster than whatever way we took before
            if (travelCost[i][j] == 0 || newPending < travelCost[i][j]) {
                travelCost[i][j] = newPending;


                //go down
                if (i + 1 < map.length && (i + 1 != prevI || prevI == -1))
                    travel(i + 1, j, i, j, prevDist + addedDist, onLand, breadCrumbs);


                //go left
                if (j - 1 >= 0 && (j - 1 != prevJ || prevJ == -1))
                    travel(i, j - 1, i, j, prevDist + addedDist, onLand, breadCrumbs);


                //go up
                if (i - 1 >= 0 && (i - 1 != prevI || prevI == -1))
                    travel(i - 1, j, i, j, prevDist + addedDist, onLand, breadCrumbs);

                //go right
                if (j + 1 < map[0].length && (j + 1 != prevJ || prevJ == -1))
                    travel(i, j + 1, i, j, prevDist + addedDist, onLand, breadCrumbs);
            }


        }


    }
}

//    static void printTravel() {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < travelCost.length; i++) {
//            for (int j = 0; j < travelCost.length; j++) {
//                sb.append(travelCost[i][j]).append("\t");
//            }
//            sb.append("\n");
//        }
//
//        System.out.println(sb.toString());
//    }
//
//    static void printMap() {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map.length; j++) {
//                sb.append(map[i][j]).append("\t");
//            }
//            sb.append("\n");
//        }
//
//        System.out.println(sb.toString());
//    }



