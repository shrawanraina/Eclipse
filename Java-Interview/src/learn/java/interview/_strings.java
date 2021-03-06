package learn.java.interview;

public class _strings {
	
	public static void _reverseWord(String str) {
		// TODO Auto-generated method stub
		//str = _reverse(str.toCharArray(),0,str.length()-1);
		if(str.length() <=1)
			return;
		//str = _reverse1(str);
		char[] strArr = str.toCharArray();
		int i = 0;
		int j = strArr.length - 1;
		char temp;
		while(j > i){
			temp = strArr[i];
			strArr[i] = strArr[j];
			strArr[j] = temp;
			i++;
			j--;
		}
		int end = 0;
		int start = 0;
		for(int k=0; k<strArr.length; ++k){
			//System.out.println(strArr[k]);
			if(strArr[k] == ' ' || k == strArr.length-1){
				if(strArr[k] == ' ')
					end = k-1;
				else
					end = k;
				while(end > start){
					temp = strArr[start];
					strArr[start] = strArr[end];
					strArr[end] = temp;
					start++;
					end--;
				}
				start = k;
				start++;
			}	
		}
		for(int z=0; z<strArr.length; ++z){
			System.out.println(strArr[z]);
		}
		String output = new String(strArr);
		System.out.println(output);
		
		/*
		for(int k=0,start=0,end=0; k<strArr.length; ++i){
			if(strArr[k] == ' ' || k == strArr.length-1){
				if(strArr[k] == ' ')
					end = k-1;
				else
					end = k;
				while(start < end){
					char temp = strArr[start];
					strArr[start] = strArr[end];
					strArr[end] = temp;
					start++;
					end--;
				}
				start = k;
				start++;
			}
		}
		*/
		//System.out.println(strArr);
	}
	
	public static String _reverseCharArray(char[] strArr, int start, int end) {
		// TODO Auto-generated method stub
		while(start < end){
			char temp = strArr[start];
			strArr[start] = strArr[end];
			strArr[end] = temp;
			//System.out.println(strArr[start]+" "+strArr[end]+" "+temp);
			start++;
			end--;
		}
		return new String(strArr);
	}
	
	public static String _reverseString1(String str) {
		// TODO Auto-generated method stub
		if(str == null || str.length() <=1)
			return null;
		char[] strArr  = str.toCharArray();
		char temp;
		int length = strArr.length - 1;
		for(int i = 0; i < length; ++i){
			temp = strArr[i];
			strArr[i] = strArr[length];
			strArr[length--] = temp;
		}
		return new String(strArr);
	}
	
	public static String _reverseString2(String input){
		if(input.length() <= 1)
			return input;
		char[] inpArr = input.toCharArray();
		int i=0;
		int j=inpArr.length-1;
		char temp;
		while(i<j){
			temp = inpArr[i];
			inpArr[i] = inpArr[j];
			inpArr[j] = temp;
			i++;
			--j;
		}
		return new String(inpArr);
	}
	
	public static int _atoiStrToInt(String input) throws Exception {
		// TODO Auto-generated method stub
		char [] strArr = input.toCharArray();
		int flag = 1;
		int res = 0;
		int i = 0;
		if(strArr[0] == '-'){
			flag = -1;
			i++;
		}
		while(i<strArr.length){
			
			if(strArr[i] < '0' || strArr[i] > '9'){
				throw new Exception("Invalid Number");
				//System.out.println("Invalid Numebr");
				//return 0;
			}
			res = res * 10 + (strArr[i] - '0');
			System.out.println("Res: "+res);
			i++;
		}
		return res * flag;
	}
	
	private static final String[] _units = {
		""," one"," two"," three"," four"," five"," six"," seven"," eight"," nine"," ten"," eleven",
		" twelve"," thirteen"," fourteen"," fifteen"," sixteen"," seventeen"," eighteen"," nineteen",
	};
	
	private static final String [] _tens = {
		""," ten"," twenty"," thirty"," fourty"," fifty",
		" sixty"," seventy"," eighty"," nighty"
	};
	
	private static final String [] _thousands = {
		""," thousand"," million"
	};
	
	public static String _numToWord(int num) {
		// TODO Auto-generated method stub
		int length = String.valueOf(num).length();
		System.out.println(length);
		String output = "";
		int pos = 0;
		
		do{
			int n = num % 1000;
			if(n != 0){
				String out1 = _convertHundred(n);
				output = out1 + _thousands[pos] + output; 
			}
			pos++;
			num = num / 1000;
		}while(num > 0);
		return output;
	}
	
	public static String _convertHundred(int num) {
		// TODO Auto-generated method stub
		String out;
		if(num % 100 <20){
			out = _units[num % 100];
			num = num/100;
		}
		
		else{
			out = _units[num % 10];
			num = num/10;
			
			out = _tens[num % 10] + out;
			num = num/10;
		}
		if(num == 0)
			return out;
		else
			return _units[num] + " hundered" + out;
	}
}
