//import java.util.ArrayList;
//import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main extends hashMap{
/*	public Main(){
		super();
	}
	public Main(int x){
		super(x);
	}*/

	public static void countLetters(String input){
		int[] letter = new int[256];
		for(int i = 0;i<input.length();i++){
			char ch = input.charAt(i);
			int value = (int)ch;
			letter[value]++;
		}
		for(int j=0;j<letter.length;j++){ 
			if(letter[j]>0){
				System.out.println((char)j+":"+j+":"+letter[j]);
			}
		}
	}
	
	public static String infixToPostfix(String input){
		char[] in = input.toCharArray();
		Stack<Character> operands = new Stack<Character>();
		String out = "";
		for(int i =0;i<in.length;i++){
			if(in[i] == ' ')
				continue;
			else if(in[i] >= '0' && in[i] <= '9'){
				out = out + in[i];
			}
			else if(in[i] == '*' || in[i] == '/' || in[i] == '+' || in[i] == '-'){
				while(!operands.empty() && !hasPrecedence(in[i],operands.lastElement())){
					out = out + operands.lastElement();
					operands.pop();
				}
				operands.push(in[i]);
				System.out.println(operands);
			}
		}
		while(!operands.empty()){
			out = out + operands.pop();
		}
		System.out.println(out);
		return out;
	}
	
	public static int getWeight(char x){
		int weight = -1;
		switch(x)
		{
		case '+':
		case '-':
			weight = 1;
			break;
		case '*':
		case '/':
			weight = 2;
		}
		return weight;
	}
	
	public static boolean hasPrecedence(char a,char b){
		int wt1 = getWeight(a);
		int wt2 = getWeight(b);
		//System.out.println(wt1);
		//System.out.println(wt2);
		if(wt1 > wt2)
			return true;
		else
			return false;
	}
	
	public static int performOp(int op1,int op2,char i){
		int res = 0;
		if(i == '+') 
			res =  op1+op2;
		else if(i == '*')
			res =  op1*op2;
		else if(i == '/')
			res =  op1/op2;
		else if(i == '-')
			res =  op1-op2;
		return res;
	}
	
	public static void evaluateExp(String s){
		int res = 0;
		int op1,op2;
		Stack<Integer> st = new Stack<Integer>();
		String input = infixToPostfix(s); 
		char[] a = input.toCharArray();
 		for(int i = 0;i<a.length;i++){
			if(a[i] == '+' || a[i] == '*' || a[i] == '/' || a[i] == '-'){
				op2 = st.pop();
				op1 = st.pop();
				res = performOp(op1,op2,a[i]);
				st.push(res);
			}
			else{
				Integer tmp = Character.getNumericValue(a[i]);
				st.push(tmp);
			}
		}
		System.out.println(st.lastElement());
	}
	
	public static void anagram(String a,String b){
		boolean res = true;
		if(a.length() != b.length())
			res = false;
		else{
			char[] x = a.toCharArray();
			char[] y = b.toCharArray();
			Arrays.sort(x);
			Arrays.sort(y);
			for(int i =0;i<a.length();i++){
				if(x[i] != y[i])
					res = false;
			}
		}
		if(res)
			System.out.println("Anagram");
		else
			System.out.println("Not Anagram");
	}
	
	public static void subSet(int[] a){
		int n = a.length;
		ArrayList<Integer> sum = new ArrayList<Integer>();
		int temp = 0;
		for(int i =0; i< n; i++){
			for(int j=0;j<=i;j++){
				temp = temp + a[j];
				sum.add(i, temp);
			}
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		countLetters("aaabbcccccc");
//		String input = "5 + 3 * 3 - 6 * 5";
		int[] a = {1,2,3,-5,6,7};
		//evaluateExp(input);
//		anagram("cay","rac");
//		infix_to_postfix(input);
//		int i = evaluateExp(a);
//		System.out.println(a);
//		hashMap obj = new hashMap();
//		obj.createDictionary();
//		obj.addHashMap();
//		Main obj = new Main(10);
//		int x = obj.XOR();
//		System.out.println(x);
	}
}

