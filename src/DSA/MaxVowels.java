package DSA;

public class MaxVowels {
    public static boolean isVowel(char c){
        return switch(c){
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }
    public static void solver(String s, int k){
        int left = 0, count = 0, maxCount = 0;
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i)))
                count++;

            maxCount = (maxCount < count) ? count: maxCount;
            
            if(count == k)
                break;

            if(i >= k-1){
                if(isVowel(s.charAt(left)))
                    count --;
                left++;
            }
        }
        System.out.println(maxCount);
    }
    public static void main(String[] args) {
        String s = "aeiou";
        int k = 3;
        solver(s, k);
    }
}
