package NumberPairs;

import java.io.*;

/**
 * Created by chris on 1/21/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        File           f  = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(f));

       // BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));


        String   line;
        String[] parts;


        int[]         a;
        int           sum;
        int[][]       pairs;
        int           pairCounter;
        StringBuilder sb;
        while ((line = br.readLine()) != null) {
            {

                if (line.isEmpty()) continue;


                parts = line.split(";");

                sum = Integer.parseInt(parts[1]);

                if (sum <= 0) System.out.println("NULL");

                parts = parts[0].split(",");
                a = new int[parts.length];

                for (int i = 0; i < parts.length; i++) {

                    int tmp = Integer.parseInt(parts[i]);
                   // if (i > 0 && a[i - 1] == tmp) continue;

                    a[i] = tmp;
                }

                pairCounter = 0;
                sb = new StringBuilder();
                pairs = new int[a.length][2];


                for (int i = 0; i < a.length; i++) {

                    int target = sum - a[i];
                    if (target <= 0) break;

                    int index = -1;


                    if (a[i] != 0)
                        index = binarySearch(a, target, i);

                    if (index != -1) {
                        pairs[pairCounter][0] = a[i];
                        pairs[pairCounter][1] = a[index];
                        pairCounter++;
                        a[i] = 0;
                    }
                }

                if (pairs[0][0] == 0) System.out.println("NULL");
                else {

                    // sort(pairs);

                    for (int i = 0; i < pairs.length; i++) {

                        int a1 = pairs[i][0];
                        int a2 = pairs[i][1];

                        if (a1 == 0) break;


                        if (a1 < a2) sb.append(a1).append(',').append(a2);
                        else sb.append(a2).append(',').append(a1);


                        if (i < pairs.length - 1 && pairs[i + 1][0] > 0) sb.append(';');


                    }
                    System.out.println(sb.toString());

                }


            }

        }
    }


    // returns the index of a such that a[index] == target
    // returns -1 if no such integer exists
    // assumes a is in sorted order
    // if more than one such integer exists, it just returns the index of the first one it finds

    private static int binarySearch(int[] a, int target, int disallowedIndex) {
        return binarySearch(a, 0, a.length - 1, target, disallowedIndex);
    }


    private static int binarySearch(int[] a, int low, int high, int target, int disallowedIndex) {




        if (high < low) return -1;

        int mid = low + (high - low) / 2;

        if (a[mid] == target && mid != disallowedIndex) return mid;
        else if (target < a[mid]) return binarySearch(a, low, mid - 1, target, disallowedIndex);
        else return binarySearch(a, mid + 1, high, target, disallowedIndex);


    }


    //merge sort....
//
//    private static int[][] tmpCopy;
//
//    private static void sort(int[][] a) {
//        tmpCopy = new int[a.length][2];
//        sort(a, 0, a.length - 1);
//    }
//
//
//    private static void sort(int[][] a, int low, int high) {
//
//        if (high <= low) return;
//
//        int mid = low + (high - low) / 2;
//
//        sort(a, low, mid);//left
//        sort(a, mid + 1, high); //right
//
//        merge(a, low, mid, high);
//
//
//    }
//
//    private static void merge(int[][] a, int low, int mid, int high) {
//        int left  = low;
//        int right = mid + 1;
//
//
//        for (int i = low; i <= high; i++) {
//            tmpCopy[i] = a[i];
//        }
//
//        for (int i = low; i <= high; i++) {
//
//            if (left > mid) a[i] = tmpCopy[right++];
//            else if (right > high) a[i] = tmpCopy[left++];
//            else if (tmpCopy[right][0] < tmpCopy[left][0]) {
//                a[i] = tmpCopy[right++];
//            } else {
//                a[i] = tmpCopy[left++];
//
//            }
//
//        }
//
//    }


}
