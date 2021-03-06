package learn.java.algo;

public class _palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = new String("abcdef");
		System.out.println(_isPalindromeR(input));
		System.out.println(input);
	}
	
	public static boolean _isPalindromeI(String str){
		if(str.length() <= 1 || str == null)
			return true;
		int i = 0;
		int j = str.length()-1;
		char[] input = str.toCharArray();
		while(i<j){
			if(input[i] != input[j])
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static boolean _isPalindromeR(String str){
		if(str.length() <= 1){
			return true;
		}
		if(str.charAt(0) == str.charAt(str.length()-1)){
			return _isPalindromeR(str.substring(1, str.length()-1));
		}
		return false;		
	}
	
}
