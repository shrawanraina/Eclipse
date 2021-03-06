package learn.java.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import learn.java.datastructure._sorting;

public class _arrays {
	static _sorting sorting = new _sorting();
	
	static class Result{
		int a;
		int b;
		Result(int a, int b){
			this.a=a;
			this.b=b;
		}
	}
	
	public static Result _pairSum(int[] input, int res){
		for(int i=0; i< input.length; ++i){
			System.out.print(input[i]+" ");
		}
		input = _sorting._mergeSort(input);
		System.out.println();
		int start = 0;
		int end = input.length - 1;
		Result pair = null;
		while(end > start){
			if(input[start] + input[end] == res){
				pair = new Result(input[start], input[end]);
				return pair;
			}
			else if(input[start] + input[end] < res){
				start++;
			}
			else if(input[start] + input[end] > res){
				end--;
			}
		}
		return pair;
	}
	
	public static int _noDuplicate(int[] list2) {
		// TODO Auto-generated method stub
		int res = 0;
		for(int i=0; i<list2.length; ++i){
			res = list2[i] ^ res;
		}
		return res;
	}
	
	public static Set<Integer> _removeDupFromList(int[] dupList) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> dupMap = new HashMap<Integer,Integer>();
		for(int i=0; i<dupList.length; ++i){
			Integer count = dupMap.get(dupList[i]);
			if(count == null){
				dupMap.put(dupList[i], 1);
			}
			else
				dupMap.put(dupList[i], count +1);
		}
		System.out.println(dupMap.keySet());
		Set<Integer> keys;
		keys = dupMap.keySet();
		return keys;
	}
	
	public static void _replaceSpace(String old){
		Integer count = 0;
		for(int i=0; i<old.length(); ++i){
			//System.out.println(a.charAt(i));
			if(old.charAt(i) == ' '){
				count++;
			}
		}
		int newLength = old.length()+(2 * count);
		char[] str = old.toCharArray();
		char[] strNew = new char[newLength];
		//String newString = old.replaceAll(" ", "%20");
		for(int i=str.length-1; i>=0; --i){
			if(str[i] == ' '){
				strNew[newLength - 1] = '%';
				strNew[newLength - 2] = '2';
				strNew[newLength - 3] = '0';
				newLength = newLength-3;
			}
			else{
				strNew[newLength - 1] = str[i];
				newLength--;
			}
			
		}
		System.out.println(strNew);
	}
	
	public static void _maxSum(int[] a, int size){
		int max = Integer.MIN_VALUE;
		int curSum = Integer.MIN_VALUE;
		int startIndex = 0;
		int endIndex = 0;
		for(int i=0; i<size; ++i){
			System.out.print(a[i]+" ");
			if(curSum < 0){
				curSum = a[i];
				startIndex = i;
				endIndex = i;
			}
			else{
				curSum += a[i];
				endIndex = i;
			}
			if(curSum > max){
				max = curSum;
			}
		}
		System.out.println();
		System.out.println("max:<<<"+max);
		System.out.println("startIndex:<<<"+startIndex);
		System.out.println("endIndex:<<<"+endIndex);
	}
	
	public static int _infixToPostFix(String input) {
		// TODO Auto-generated method stub
		System.out.println(input);
		char[] token = input.toCharArray();
		StringBuffer output = new StringBuffer();
		Stack<Integer> operand = new Stack<Integer>();
		Stack<Character> operator = new Stack<Character>();
		for(int i=0; i<token.length; i++){
			if(token[i] == ' ')
				continue;
			else if(token[i] >= '0' && token[i] <= '9'){
				StringBuffer number = new StringBuffer();
				while(i<token.length && token[i] >= '0' && token[i] <= '9'){
					number.append(token[i++]);
				}
				System.out.println("Number: "+number);
				output.append(number);
				operand.push(Integer.parseInt(number.toString()));
			}
			if(i < token.length){
				if(_isOpr(token[i])){
					System.out.println("opr: "+token[i]);
					while(!operator.empty() && _hasPrecedence(operator.peek(), token[i])){
						operand.push(_applyOp(operator.pop(), operand.pop(), operand.pop()));
						//output.append(operator.pop());
					}
					operator.push(token[i]);
				}
				else if(_isLeft(token[i])){
					operator.push(token[i]);
				}
				else if(_isRight(token[i])){
					while(!operator.empty() && !_equalParan(operator.peek(), token[i])){
						operand.push(_applyOp(operator.pop(), operand.pop(), operand.pop()));
						//output.append(operator.pop());
						//operator.pop();
					}
					//output.append(operator.pop());
					operator.pop();
				}
			}
		}
		while(!operator.empty())
			//output.append(operator.pop());
			operand.push(_applyOp(operator.pop(), operand.pop(), operand.pop()));
		//System.out.println(operand.pop());
		return operand.pop();
	}
	
	private static boolean _isRight(char c) {
		// TODO Auto-generated method stub
		if(c == ')' || c == '}' || c == ']')
			return true;
		else
			return false;
	}
	
	private static boolean _isLeft(char c) {
		// TODO Auto-generated method stub
		if(c == '(' || c == '{' || c == '[')
			return true;
		else
			return false;
	}
	
	private static boolean _isOpr(char c) {
		// TODO Auto-generated method stub
		if(c == '*' || c == '/' || c == '+' || c == '-')
			return true;
		else
			return false;
	}
	
	private static boolean _equalParan(Character peek, char c) {
		// TODO Auto-generated method stub
		if(peek == '(' && c == ')')
			return true;
		if(peek == '{' && c == '}')
			return true;
		if(peek == '[' && c == ']')
			return true;
		else
			return false;
	}
	
	private static boolean _hasPrecedence(char op1, char op2){
        if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-') || (op1 == '*' && op2 == '/') || (op1 == '/' && op2 == '*'))
        	return true;
        else
        	return false;
    }
	
	private static int _applyOp(Character op, Integer b, Integer a) {
		// TODO Auto-generated method stub
		switch (op){
			case '+':
				return a+b;
			case '-':
				return a-b;
			case '*':
				return a*b;
			case '/':
				if(a == 0)
					throw new UnsupportedOperationException("Cannot divide by 0");
				return a/b;
			}
			return 0;
	}
	
	public static void _coinChange(int[] coin,int size, int amt) {
	    // We need n+1 rows as the table is consturcted in bottom up manner using 
	    // the base case 0 value case (n = 0)
		int[] table = new int[amt+1];
	    System.out.println("n+1: "+(amt+1)+", m: "+size);
	    // Fill rest of the table enteries in bottom up manner
	    for(int k=0; k<table.length; ++k){
	    	table[k] = 100;
	    }
	    table[0] = 0;
	    for(int a=0; a<table.length; ++a){
	    	System.out.print(table[a]+" ");
	    }
	    System.out.println();
	    for(int i=1; i<=amt; i++){
	    	for(int j=0; j<size; j++){
	    		System.out.println("coin[j]: "+coin[j]+", "+"i: "+i);
	    		if(coin[j] <= i){
	    			int temp = i - coin[j];
		    		System.out.println("temp: "+temp);
		    		System.out.println("temp1: "+table[temp]);
	    			if((table[temp] + 1) < table[i]){
	    				table[i] = table[temp]+1;
	    				System.out.println("i: "+i+", table[i]: "+table[i]);
	    			}
	    		}
	    	}
	    }
	    for(int a=0; a<table.length; ++a){
	    	System.out.print(table[a]+" ");
	    }
	    System.out.println();    
	}
	
	public static ArrayList<Integer> _arrayListIntersection(ArrayList<Integer> x, ArrayList<Integer> y){
		ArrayList<Integer> z = new ArrayList<Integer>();
		HashSet<Integer> intersect = new HashSet<Integer>();
		System.out.println("x:"+x.size());
		System.out.println("x:"+y.size());
		for(Integer a : x){
			intersect.add(a);
		}
		for(Integer b : y){
			if(intersect.contains(b))
				z.add(b);
		}
		return z;
	}
	
	public static final int m = 2;
	public static final int n = 3;
	public static int [] [] _transposeMatrix(int input[][]){
		int [] [] transpose = new int[n][m];
		for(int i=0; i<m ; ++i){
			for(int j=0; j<n; ++j){
				transpose[j][i] = input[i][j];
			}
		}
		return transpose;
	}
}
