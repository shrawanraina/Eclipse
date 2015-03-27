/*
 * sorting.h
 *
 *  Created on: Jan 13, 2014
 *      Author: shrawanraina
 */

#ifndef CPP__DATASTRUCTURES_SORTING_H_
#define CPP__DATASTRUCTURES_SORTING_H_
#include <iostream>

void swap(int *a,int *b){
	*a = *a + *b;
	*b = *a - *b;
	*a = *a - *b;
}

void print(int a[],int size){
	std::cout << "Array:";
	for(int i=0;i<size;i++){
			std::cout << a[i];
		}
	std::cout << std::endl;
}

void bubbleSort(int a[],int size){
	for(int i=1;i<size-1;i++){
		int flag = 0;
		for(int j=0;j<size-i;j++){
			if(a[j] > a[j+1]){
				swap(&a[j],&a[j+1]);
				flag = 1;
			}
		}
		if (flag == 0){
			break;
		}
	}
}

void merge(int left[], int right[], int array[], int size, int nL, int nR){
	int i,j,k;
	i=j=k=0;
	while(i < nL && j<nR){
		if(left[i] <= right[j]){
			array[k] = left[i];
			i++;
			k++;
		}
		else{
			array[k] = right[j];
			k++;
			j++;
		}
	}
	while(i<nL){
		array[k]=left[i];
		i++;
		k++;
	}
	while(j<nR){
		array[k]=right[j];
		j++;
		k++;
	}
}

int* mergeSort(int a[],int size){
	if(size < 2){
		return 0;
	}
	int nL = size/2;
	int nR = size-nL;
	int  l[nL],r[nR];
	for(int i=0;i<nL;i++){
		l[i] = a[i];
	}
	for(int j=nL;j<size;j++){
		r[j-nL] = a[j];
	}
	mergeSort(l,nL);
	mergeSort(r,nR);
	merge(l,r,a,size,nL,nR);
	return a;
}

int quickPartition(int a[], int start, int end){ //2175364
	int pivot = a[end];
	int pIndex = start;
	for(int i=start;i<end;i++){
		if(a[i] < pivot){
			swap(&a[i], &a[pIndex]);
			pIndex++;
		}
	}
	swap(&a[pIndex],&a[pivot]);
	return pIndex;
}

void quickSort(int a[], int start, int end){
	if (start >= end){
		return;
	}
		int pIndex = quickPartition(a,start,end);
		quickSort(a,start,pIndex-1);
		quickSort(a,pIndex+1,end);
}

#endif /* CPP__DATASTRUCTURES_SORTING_H_ */

