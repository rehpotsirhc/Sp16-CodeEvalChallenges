package PrefixExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by chris on 1/5/2016.
 */
public class Main {



    /*

    Use two stacks




    Stack nums = add in reverse order;
    Stack ops = add;


    if(ops.size() + 1 != nums.size())
        //invalid expression

    while(nums.size() >= 2 && ops.size >=1)
    {

     double number1 = nums.pop();
     double number2 = nums.pop();

     String operator = ops.pop();

     double result;

     if(operator == '/') result = number1 / number2;
     if(operator == '+') result = number1 + number2;
     if(operator == '*') result = number1 * number2;
     else
     {
        //ivalid operator
     }

     nums.push(result);

     }

     System.out.println(nums.pop());



     */


    public static void main(String[] args) throws IOException {
        Stack<Double>    nums;
        Stack<Character> ops;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {

            nums = new Stack();
            ops = new Stack();


            String[] parts = line.split(" ");

            int i = 0;
            while(parseDouble(parts[i]) == null)
            {
                ops.add(parts[i].charAt(0));
                i++;
            }

            for(int a = parts.length -1; a >= i; a--)
            {
                nums.add(parseDouble(parts[a]));
            }


           // if (ops.size() + 1 != nums.size());
                //invalid expression

                while (nums.size() >= 2 && ops.size() >= 1) {

                    double number1 = nums.pop();
                    double number2 = nums.pop();

                    Character operator = ops.pop();

                    double result = 0;

                    if (operator == '/') result = number1 / number2;
                    if (operator == '+') result = number1 + number2;
                    if (operator == '*') result = number1 * number2;
                    else {
                        //ivalid operator
                    }

                    nums.push(result);

                }



            double result = nums.pop();
            if(Math.floor(result)== result) System.out.println((int)result);
            else System.out.println(result);

        }
    }


    private static Double parseDouble(String s) {
        Double d = null;
        try {
            d = Double.parseDouble(s);
        } catch (NullPointerException npe) {

        } catch (NumberFormatException nfe) {

        }

        return d;
    }


}
