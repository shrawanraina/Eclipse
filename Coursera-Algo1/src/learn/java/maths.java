package learn.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class maths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter number: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i=0; i<n; i++){
			System.out.print(maths.fibonacci(i)+" ");
		}
//		fibonacciI(n);
	}
	public static int fibonacciR(int n){
/*		if(n==0)
			return 0;
		if(n==1)
			return 1;*/
		if(n<2)
			return 1;
		else if(n>1)
			return fibonacciR(n-1)+fibonacciR(n-2);
		else
			return -1;
	}
	
	public static int fibonacci(int n){
		//List<Integer> fibTable = new ArrayList<Integer>();
		int[] fibTable = new int[46];
		if(n==0){
			return fibTable[0] = 1;
		}
		if(n==1){
			return fibTable[1] = 1;
		}
		else if(n>1){
			if(fibTable[n] != 0){
				return fibTable[n];
			}
			return fibTable[n] = fibonacci(n-1) + fibonacci(n-2);
		}
		else
			return -1;
	}
	
	public static void fibonacciI(int n){
		int a = 1;
		int b = 0;
		for(int i=0; i<n; i++){
			int c = a+b;
			a = b;
			b = c;
			System.out.print(b+" ");
		}
	}
}
