package ValidParenTheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 1/8/2016.
 */
public class Main {


    //https://www.codeeval.com/open_challenges/68/

    /*

    solution:
    push to stack each time ( { or [ is encountered
    pop from stack each time ) } or ] is encountered
    make sure the bracket that comes off the stack matches the one encountered,e.g., if we see ) make sure the bracket popped is a (

    it's  not well formed if:
     1) at the end of the string there are items still on the stack
     2) the stack is empty before the end of the string is reached
     3) the popped bracket doesn't match, as described above



     private static class Stack
     {


       List<Character> s;
       int end = -1;


       public Stack()
       {
            s = new ArrayList();
       }

       public void push(Character c)
       {

            s.add(c);
            end++;

       }

       public char pop()
       {

            if(end >=0)
               return s.get(end--);
            else
                //error condition

       }

       public int size()
       {
            return end + 1;
       }

       public boolean isEmpty()
       {
            return size() <= 0;
       }



     }


     public static void main(String[] args)
     {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        Stack s;

        while((line = br.readline()) != null && !line.isEmpty())
        {

            char[] chars = line.toCharArray();
            s = new Stack();
            boolean wellFormed = true;
            for(char c: chars)
            {
                if(char == '(' || char == '[' || char== '{')
                    s.push(c);
                else if(char == ')' || char == ']' || char== '}')
                {

                    if(stack.isEmpty() || s.pop() != c)
                    {
                        wellFormed = false;
                        break;
                    }
                 }

            }

            wellFormed = s.isEmpty();

            if(wellFormed)
                System.out.println("True");
            else
                System.out.println("False");

        }
     }



     */

    private static class Stack {


        List<Character> s;
        int end = -1;


        public Stack() {
            s = new ArrayList();
        }

        public void push(Character c) {

            s.add(c);
            end++;

        }

        public char pop() {

            if (end >= 0)
                return s.remove(end--);
            else
                //error condition
                return 0;

        }

        public int size() {
            return end + 1;
        }

        public boolean isEmpty() {
            return size() <= 0;
        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        Stack  s;

        while ((line = br.readLine()) != null && !line.isEmpty()) {

            char[] chars = line.toCharArray();
            s = new Stack();
            boolean wellFormed = true;
            for (char c : chars) {
                if (c == '(' || c == '[' || c == '{')
                    s.push(c);
                else if (c == ')' || c == ']' || c == '}') {

                    if (s.isEmpty() || !bracketMatch(s.pop(), c)) {
                        wellFormed = false;
                        break;
                    }
                }

            }

            if(wellFormed)
                wellFormed = s.isEmpty();

            if (wellFormed)
                System.out.println("True");
            else
                System.out.println("False");

        }
    }

    private static boolean bracketMatch(char c1, char c2)
    {
        return  (c1== '{' && c2== '}') || (c1== '[' && c2== ']') || (c1== '(' && c2== ')');
    }


}
