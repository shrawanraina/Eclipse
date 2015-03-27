/*
 * searching.h
 *
 *  Created on: Jan 21, 2014
 *      Author: shrawanraina
 */

#ifndef CPP__DATASTRUCTURES_SEARCHING_H_
#define CPP__DATASTRUCTURES_SEARCHING_H_
int binarySearch(int a[],int x, int high){
	int low = 0;
	while (low <= high){
		int mid = (low+high)/2;
		if (x == a[mid]){
			return 1;
		}
		else if(x < a[mid]){
			high = mid-1;
		}
		else
			low = mid+1;
	}
	return 0;
}

int binarySearchR(int a[],int n, int low, int high){
	if (low > high){
		return -1;
	}
	int mid = (low+high)/2;
	std::cout<<mid<<","<<a[mid]<<std::endl;
	if (n == a[mid]){
		return mid;
	}
	else if(n < a[mid]){
		return binarySearchR(a,n,low,mid-1);
	}
	else
		return binarySearchR(a,n,mid+1,high);
}

int binarySearchFL(int a[],int x, int high, bool flag){
	int low = 0;
	int result = -1;
	while (low <= high){
		int mid = (low+high)/2;
		if (x == a[mid]){
			result = mid;
			if(flag){
				high = mid-1;
			}
			else
				low = mid+1;
		}
		else if(x < a[mid]){
			high = mid-1;
		}
		else
			low = mid+1;
	}
	return result;
}

int findRotationCount(int a[], int size){
	int low = 0;
	int high = size-1;
	while(low < high){
		if(a[low] < a[high])
			return low;
		int mid = (low+high)/2;
		int prev = (mid+size-1)%size;
		int next = (mid+1)%size;
		if(a[mid] < a[prev] && a[mid] < a[next])
			return mid;
		else if (a[mid] < a[high])
			high = mid - 1;
		else if (a[mid] > a[low])
			low = mid-1;
	}
	return -1;
}




#endif /* CPP__DATASTRUCTURES_SEARCHING_H_ */
