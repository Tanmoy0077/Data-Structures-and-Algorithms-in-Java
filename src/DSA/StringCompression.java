package DSA;

import java.util.Arrays;

public class StringCompression {
    public static void solver(char[] chars){
        int w=0, len = chars.length, i=0, r, count=0;
        while(i < len){
            r = i;
            count=0;
            while(r < len && chars[i] == chars[r]){
                r++;
                count++;
            }
            chars[w++] = chars[i];
            if(count > 1)
                for(char c: String.valueOf(count).toCharArray()){
                    chars[w++] = c;
                }
            i = r;
        }
        System.out.println(w);
        System.out.println(Arrays.toString(chars));
    }
    public static void main(String[] args) {
        char[] chars = {'a','a','b','c'};
        solver(chars);
    }
    
}
