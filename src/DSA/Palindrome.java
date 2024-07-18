package DSA;

public class Palindrome{

    public static boolean isPalindrome(int num, int digits) {
        if (digits == 1 || digits == 0)
            return true;
        return ((num % 10) == (num / (int) (Math.pow(10, digits - 1))))
                && isPalindrome((num % (int) (Math.pow(10, digits - 1))) / 10, digits - 2);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-123321, 6));
    }
}
