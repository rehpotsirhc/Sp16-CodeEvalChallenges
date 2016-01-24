package Footbal;

import java.io.*;
import java.util.*;

/**
 * Created by chris on 1/11/2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        File           file = new File(args[0]);
        BufferedReader br   = new BufferedReader(new FileReader(file));

        //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;


        while ((line = br.readLine()) != null) {

            String[] parts = line.split("\\|");

            String[] numsS;

            TreeMap<Integer, Set<Integer>> set = new TreeMap<>();

            for (int i = 0; i < parts.length; i++) {
                numsS = parts[i].trim().split("\\s");

                for (String ns : numsS) {
                    int tmp = Integer.parseInt(ns);

                    Set<Integer> subSet = set.get(tmp);

                    if (subSet == null) {
                        subSet = new TreeSet<>();
                        set.put(tmp, subSet);
                    }

                    subSet.add(i + 1);

                }
            }

            StringBuilder sb = new StringBuilder();

            Set<Integer> ks = set.keySet();

            Iterator itr2 = ks.iterator();

            for (int j = 0; j < ks.size(); j++) {
                int top = (int) itr2.next();
                sb.append(top).append(":");

                Set<Integer> subSet = set.get(top);
                Iterator itr = subSet.iterator();

                for (int i = 0; i < subSet.size(); i++) {
                    sb.append(itr.next());
                    if (i < subSet.size() - 1) sb.append(',');

                }
                if (j < ks.size() - 1) sb.append("; ");
                else sb.append(";");
            }

            System.out.println(sb);
        }


    }


}
