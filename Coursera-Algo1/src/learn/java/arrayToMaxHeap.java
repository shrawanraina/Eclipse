package learn.java;

import java.util.Arrays;

public class arrayToMaxHeap {

	public static int input[]={4, 1, 3, 2, 16, 9, -1, 14, 8, 7};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(input));
		//System.out.println(input.length);
		for(int i = (input.length-1)/2;i>=0; --i){
			//System.out.println(i);
			getHeap(i);
		}
		System.out.println(Arrays.toString(input));	
	}
	
	
	public static void getHeap(int i){
		int largest = i;
		int left = 2*i+1;
		int right =  2*i+2;
		//System.out.println(left+":"+i+":"+right);
		if(left <= input.length-1 && input[left] > input[i]){
			largest = left;
		}
		if(right <= input.length-1 && input[right] > input[largest]){
			largest = right;
		}
		if(largest != i){
			swap(i,largest);
			getHeap(largest);
		}
	}
	public static void swap(int i, int largest){
		int temp = input[i];
		input[i] = input[largest];
		input[largest] = temp;
	}
}
