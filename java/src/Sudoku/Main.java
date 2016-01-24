package Sudoku;

import java.io.*;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;


        String[] parts;
        int      gridSize;
        int[][]  grid;
        int      next;
        while ((line = br.readLine()) != null) {


            parts = line.split(";");
            gridSize = Integer.parseInt(parts[0]);

            parts = parts[1].split(",");

            grid = new int[gridSize][gridSize];
            next = 0;
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    grid[i][j] = Integer.parseInt(parts[next++]);
                }
            }

            if (isValidSudoku(grid)) System.out.println("True");
            else System.out.println("False");


        }

    }


    static boolean isValidSudoku(int[][] grid) {


        boolean[][] ints;

        //check rows and columns
        for (int j = 0; j < grid.length; j++) {

            ints = new boolean[grid.length + 1][2];


            //check the jth row and jth column
            for (int i = 0; i < grid.length; i++) {

                ints[grid[j][i]][0] = true;
                ints[grid[i][j]][1] = true;
            }

            for (int i = 1; i < grid.length; i++) {
                if (!ints[i][0]) return false;
                if (!ints[i][1]) return false;
            }
        }


        //check squares

        int K = (int) Math.sqrt(grid.length);


        for (int ki = 1; ki <= K; ki++) {
            for (int kj = 1; kj < K; kj++) {
                //new box;
                ints = new boolean[grid.length + 1][1];
                ints[0][0] = true;
                for (int i = K * (ki - 1); i <= ki * K - 1; i++) {
                    for (int j = K * (kj - 1); j <= kj * K - 1; j++) {
                        ints[grid[i][j]][0] = true;
                    }
                }

                for (int i = 1; i < ints.length; i++) {
                    if (!ints[i][0]) return false;
                }


            }


        }


        return true;

    }


}
