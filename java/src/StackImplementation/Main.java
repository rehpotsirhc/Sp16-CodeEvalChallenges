package StackImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 1/6/2016.
 */
public class Main {


    static class Stack {

        List<Integer> a;
        int           end;

        public Stack() {
            a = new ArrayList<>();
            end = -1;
        }

        public void push(int i) {
            a.add(i);
            end++;
        }

        public int pop() throws Exception {
            if (end >= 0) {
                return a.get(end--);
            } else {
                throw new Exception();
            }
        }

        public boolean isEmpty() {
            return end < 0;
        }

        public int size() {
            return end + 1;
        }


    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String   line;
        String[] parts;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            parts = line.split(" ");

            Stack stack = new Stack();

            for (String s : parts) {
                stack.push(Integer.parseInt(s.trim()));
            }

            StringBuilder sb = new StringBuilder();


            int initialSize = stack.size();

            for (int i = 0; i < initialSize; i++) {
                int num = stack.pop();
                if (i % 2 == 0) {
                    sb.append(num);
                    if (i < initialSize - 1) sb.append(" ");
                }
            }

            System.out.println(sb);
        }

    }
}
