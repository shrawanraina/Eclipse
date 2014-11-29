package learn.java;

public class misc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = new String("abcdef");
//		System.out.println(_isPalindromeR(input));
		System.out.println(input);
		String output = _stringReverseI(input);
		System.out.println(output);
	}
	public static String _stringReverseI(String str){
		if(str.length() < 1){
			System.out.println("Empty String");
			return str;
		}
		char[] input = str.toCharArray();
		int len = input.length;
		char temp;
		for(int i=0; i<=len/2; i++){
			temp = input[i];
			input[i] = input[--len];
			input[len] = temp;
		}
		return new String(input);
	}
	
	public static String _stringReverseR(String str){
		if(str.length() < 1){
			return str;
		}
		return _stringReverseR(str.substring(1))+str.charAt(0);
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
