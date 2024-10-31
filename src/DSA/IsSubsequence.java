package DSA;

public class IsSubsequence {
    public static void solver(String s, String t){
        int p = 0;
        for(int i=0;p<s.length() && i<t.length();i++){
            if(s.charAt(p) == t.charAt(i))
                p++;
        }
        if(p < s.length())
            System.out.println(s+" is not a subsequence of "+t);
        else
            System.out.println(s+" is a subsequence of "+t);
    }
    public static void main(String[] args) {
        solver("", "");
    }
}
