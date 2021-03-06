package learn.java.datastructure;

public class _sorting {
	public static int[] _mergeSort(int[] list1) {
		// TODO Auto-generated method stub
		if(list1.length < 2)
			return null;
		int lengthL = list1.length/2;
		int lengthR = list1.length - lengthL;
		int[] left = new int[lengthL];
		int[] right = new int[lengthR];
		for(int i=0; i<lengthL; ++i){
			left[i] = list1[i];
		}
		for(int j=lengthL; j<list1.length; ++j){
			right[j-lengthL] = list1[j];
		}
		_mergeSort(left);
		_mergeSort(right);
		list1 = _merge(left,right,list1);
		return list1;
	}
	
	private static int[] _merge(int[] left, int[] right, int[] list1) {
		// TODO Auto-generated method stub
		int i,j,k;
		i=j=k=0;
		while(i<left.length && j<right.length){
			if(left[i] <= right[j]){
				list1[k] = left[i];
				++i;
				++k;
			}
			else{
				list1[k] = right[j];
				++k;
				++j;
			}
		}
		while(i<left.length){
			list1[k] = left[i];
			++k;
			++i;
		}while(j<right.length){
			list1[k] = right[j];
			++k;
			++j;
		}
		return list1;
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
