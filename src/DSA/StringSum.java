package DSA;

public class StringSum {
	public static String stringConcat(String num1, String num2, int carry){
		int len1 = num1.length();
		int len2 = num2.length();
		if(carry == 0){
			if(len1 == 0)
				return num2;
			if(len2 == 0)
				return num1;
		}

		int sum = carry;
		if(len1 != 0)
			sum += Integer.parseInt(num1.substring(len1-1));
		if(len2 != 0)
			sum += Integer.parseInt(num2.substring(len2-1));
		
		if(sum >= 10)
			return stringConcat(num1.substring(0, Math.max(0, len1-1)), num2.substring(0, Math.max(0, len2-1)), sum/10) + Integer.toString(sum%10);
		else
			return stringConcat(num1.substring(0, Math.max(0, len1-1)), num2.substring(0, Math.max(0, len2-1)), 0) + Integer.toString(sum);

	}
    public static void main(String[] args) {
        String num1 = "23";
        String num2 = "77";
		System.out.println(stringConcat(num1, num2, 0));
    }    
}
