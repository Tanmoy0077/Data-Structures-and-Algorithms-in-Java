package DSA;


public class DecodeStrings {
    public static void solver(String s){
        StringBuilder result = new StringBuilder();
        StringBuilder charBuffer = new StringBuilder();
        StringBuilder numBuffer = new StringBuilder();
        int i,top=0, slen = s.length(), rep;
        for(i=0;i<slen;i++){
            if(s.charAt(i) == ']'){
                top = result.length()-1;
                while(result.charAt(top) != '['){
                    charBuffer.append(result.charAt(top));
                    result.setLength(result.length()-1);
                    top--;
                }
                result.setLength(result.length()-1);
                top--;
                while(top >= 0 && result.charAt(top) >= 48 && result.charAt(top) <= 57){
                    numBuffer.append(result.charAt(top));
                    result.setLength(result.length()-1);
                    top--;
                }
                rep = Integer.parseInt(numBuffer.reverse().toString());
                System.out.println(numBuffer.toString());
                numBuffer.setLength(0);
                charBuffer = charBuffer.reverse();
                while(rep > 0){
                    result.append(charBuffer);
                    rep--;
                }
                charBuffer.setLength(0);
            }
            else
                result.append(s.charAt(i));
        }
        System.out.println(result.toString());
    }
    public static void main(String[] args) {
        String s = "";
        solver(s);
    }
}
