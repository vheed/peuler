package ProcessingModel;

public final class Arithmetic {

    public static boolean isPalindrome(long n) {
        return ((n%10)!=0)  && (n==reverseDigits(n));
    }

    public static long reverseDigits(long num) {
        long rev_num = 0;
        while(num > 0)
        {
            rev_num = rev_num * 10 + num % 10;
            num = num / 10;
        }
        return rev_num;
    }
}
