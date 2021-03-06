package learn.java.algo;

import java.util.Stack;

public class _reverseStringWordStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello how are you";
		System.out.println(str);
		char[] output = _reverseStrWord(str);
		for(int i=0; i<output.length; i++){
			System.out.print(output[i]);
		}
		Integer age = Integer.valueOf(30);
		Integer num = Integer.valueOf(4);
		System.out.println(age/num);
	}
	
	public static char[] _reverseStrWord(String str){
		char[] input = str.toCharArray();
//		System.out.println(Arrays.toString(input));
		int lIndex = 0, rIndex = input.length-1;
		input = _reverseArray(input,lIndex,rIndex);
//		System.out.println(Arrays.toString(input));
		for(rIndex=0; rIndex <input.length; rIndex++){
			if(rIndex == input.length || input[rIndex] == ' '){
//				System.out.println(lIndex);
//				System.out.println(rIndex);
//				System.out.println(Arrays.toString(input));
				input = _reverseArray(input,lIndex,rIndex-1);
//				System.out.println(Arrays.toString(input));
				lIndex = rIndex+1;
			}
		}
		input = _reverseArray(input,lIndex,rIndex-1);
//		System.out.println(lIndex);
//		System.out.println(rIndex);
//		System.out.println(Arrays.toString(input));
		return input;
	}
	
	public static String _reverseStr(String str){
		if(str.length() <=1){
			return str;
		}
		return _reverseStr(str.substring(1))+str.charAt(0);
	}
	
	public static char[] _reverseArray(char[] input, int i, int j){
		char temp;
		while(i<j){
			temp = input[i];
			input[i] = input[j];
			input[j] = temp;
			i++;
			j--;
		}
		return input;
	}
	
	public static void _reverseStrWordStack(String str){
		String input[] = str.split(" ");
		Stack<String> stck = new Stack<String>();
		for(int i=0; i<input.length; i++){
			stck.add(input[i]);
		}
		while(!stck.empty()){
			System.out.print(stck.pop());
		}
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
	
}
