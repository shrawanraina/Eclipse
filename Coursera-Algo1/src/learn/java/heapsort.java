package learn.java;

import java.util.Arrays;

public class heapsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 23, 12, 9, 30, 2, 50};
		bubbleKSort(input,input.length,3);
		System.out.println(Arrays.toString(input));
	}
	public static void bubbleKSort(int a[],int size, int k){
		for(int i=1;i<k;i++){
			int flag = 0;
			int temp;
			for(int j=0;j<size-i;j++){
				if(a[j] > a[j+1]){
					//swap(&a[j],&a[j+1]);
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					flag = 1;
				}
			}
			if (flag == 0){
				break;
			}
		}
	}
}
