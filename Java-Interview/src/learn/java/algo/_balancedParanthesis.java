package learn.java.algo;
import java.util.*;

public class _balancedParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = new String();
		string = "1+2+3+4";
		String paran = new String();
		paran = "{(2+3)(4*[5-4]/(5-2)*1[4*2/2)}";
		//paran = "{{";
		boolean result = _checkBalancedParanthesis(paran);
		System.out.println(result);
		//stringAnswer(string);
	}
	
	public static void _stringAnswer(String string){
		char[] input = string.toCharArray();
		int result = 0;
		for(int i=0; i<input.length; ++i){
			result += (input[i]-'0');
			if(input[i] == '+')
				i++;
			//System.out.println(input[i]);
		}
		System.out.println(result);
	}
	
	public static boolean _checkBalancedParanthesis(String str){
		Stack<Character> s = new Stack<Character>();
		char[] string = str.toCharArray();
		for(int i=0; i< string.length; ++i){
			if(string[i] == '{' || string[i] == '[' || string[i] == '('){
				s.push(string[i]);
			}
			else if(string[i] == '}' || string[i] == ']' || string[i] == ')'){
				if(s.isEmpty() || !_checkStack(s.peek(), string[i])){
					return false;
				}
				else{
					s.pop();
				}
			}
			else
				continue;
			System.out.println(s);
		}
		return s.isEmpty() ? true:false;
	}
	
	public static boolean _checkStack(char s, char i){
		if(i == '}'){
			if(s == '{')
				return true;
			else
				return false;
		}
		if(i == ']'){
			if(s == '[')
				return true;
			else
				return false;
		}
		if(i == ')'){
			if(s == '(')
				return true;
			else
				return false;
		}
		return false;
	}
}
