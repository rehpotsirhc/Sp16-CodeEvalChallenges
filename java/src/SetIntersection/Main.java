package SetIntersection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 12/23/2015.
 */
class Main {





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while ((line = br.readLine()) != null) {

            StringBuilder sb = new StringBuilder();
            String[] setsS = line.split(";");

            String[] set1S = setsS[0].split(",");
            String[] set2S = setsS[1].split(",");

            set set1 = new set();
            set set2 = new set();

            for (String s : set1S) {
                set1.add(Integer.parseInt(s));
            }

            for (String s : set2S) {
                set2.add(Integer.parseInt(s));
            }

            int[] intersection = set1.intersection(set2);



            for(int i = 0; i < intersection.length;i++)
            {
                sb.append(String.valueOf(intersection[i]));

                if(i  != intersection.length - 1)sb.append(',');
            }

            sb.append("\n");
            System.out.print(sb.toString());

        }


    }
    private static class set {


        private int[] pos;
        private int[] neg;


        public set() {

            pos = new int[10];
            neg = new int[10];
        }

        public void add(int num) {
            if (num >= 0) {

                pos = add(pos, num);

            } else {
                neg = add(neg, -num);
            }
        }

        public int count(int num) {
            if (num >= 0) {
                if (pos.length <= num) return 0;
                else return pos[num];
            } else {
                num = -num;
                if (neg.length <= num) return 0;
                else return neg[num];
            }
        }


        public int[] intersection(set set2) {

            int[] posIntersection = intersection(pos, set2.pos);
            int[] negIntersection = intersection(neg, set2.neg);


            int[] combined = new int[posIntersection.length + negIntersection.length];

            for(int i = 0; i <  negIntersection.length; i++)
            {
                combined[i] = negIntersection[i];
            }

            for(int i = negIntersection.length; i <  combined.length; i++)
            {
                combined[i] = posIntersection[i- negIntersection.length];
            }

            return combined;

        }

        private static int[] intersection(int[] set1, int[] set2)
        {
            int length = set2.length;

            if (set1.length < length) length = set1.length;

            int[] intersectionAll = new int[length];

            int count = 0;
            for (int i = 0; i < length; i++) {
                if (set1[i] > 0 && set2[i] > 0) {
                    count++;
                    intersectionAll[i] = 1;
                }
            }
            int[] intersection = new int[count];

            for (int i = 0, c = 0; i < intersectionAll.length && c< count; i++) {
                if (intersectionAll[i] == 1) intersection[c++] = i;
            }

            return intersection;
        }

        private static int[] add(int[] a, int num) {
            while (a.length <= num) {
                a = resize(a);
            }
            a[num]++;

            return a;
        }

        private static int[] resize(int[] oldA) {
            int[] newA = new int[oldA.length * 2];
            for (int i = 0; i < oldA.length; i++) {
                newA[i] = oldA[i];
            }

            return newA;
        }


    }

}
