package DSA;

public class LongestPalindromicSubstring {
    public static void getLPS(String str) {
        String result = "";
        int maxLength = 0;
        for (int i = 0; i < str.length(); i++) {
            int left = i, right = i;
            while ((left >= 0 && right < str.length()) && (str.charAt(left) == str.charAt(right))) {
                left--;
                right++;
            }
            
            left++;
            right--;

            if (maxLength < (right - left + 1)) {
                maxLength = right - left + 1;
                result = str.substring(left, right+1);
            }

            left = i;
            right = i+1;
            while ((left >= 0 && right < str.length()) && (str.charAt(left) == str.charAt(right))) {
                left--;
                right++;
            }

            left++;
            right--;

            if (maxLength < (right - left + 1)) {
                maxLength = right - left + 1;
                result = str.substring(left, right+1);
            }
        }
        System.out.println("The longest palindromic substring is : "+result);
        System.out.println(maxLength);
    }

    public static void main(String[] args) {
        String input = "bababaa";
        getLPS(input);
    }
}
