package PrimePalindrome;

/**
 * Created by chris on 12/16/2015.
 */
class Main  {



    public static void main (String[] args)
    {
        for(int i = 999; i > 2; i--)
        {
            if(isPalindrom(i) && isPrime(i))
            {
                System.out.println(i);
                break;
            }
        }
    }


    private static boolean isPrime(int x)
    {
        for(int i = 2; i <= (x / 2); i++){

            if(x % i == 0) return false;
        }

        return true;
    }

    private static boolean isPalindrom(int x)
    {

        char[] sx = String.valueOf(x).toCharArray();

        for(int i = 0, j = sx.length - 1; ;i++, j--)
        {
            if(i > j) return true;
            if(sx[i] != sx[j]) return false;
        }
    }

}
