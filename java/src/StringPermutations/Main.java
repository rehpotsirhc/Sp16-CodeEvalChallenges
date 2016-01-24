package StringPermutations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chris on 1/5/2016.
 */
public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb;
        String        line;
        while ((line = br.readLine()) != null) {
            List<String> perms = new ArrayList<>();
            perm("", line.toCharArray(), line.length(), perms);
            Collections.sort(perms);

            sb = new StringBuilder();

            for (int i = 0; i < perms.size(); i++) {
                sb.append(perms.get(i));
                if (i != perms.size() - 1) sb.append(",");
            }
            sb.append("\n");
            System.out.print(sb);
        }


    }

    static void perm(String s, char[] hat, int length, List<String> perms) {

        if (s.length() == length && !isAlreadyInPerms(s, perms)) perms.add(s);

        for (int i = 0; i < hat.length; i++) {

            char c = hat[i];
            if(c != ' ') {
                hat[i] = ' ';
                perm(s + c, hat, length, perms);
                hat[i] = c;
            }

        }


    }

    static boolean isAlreadyInPerms(String s, List<String> perms) {
        for (String alreadyIn : perms)
            if (s.equals(alreadyIn)) return true;
        return false;
    }


}
