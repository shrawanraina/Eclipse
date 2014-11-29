/*
 * main.cpp
 *
 *  Created on: Jan 21, 2014
 *      Author: shrawanraina
 */
#include <iostream>
#include <stdio.h>
#include <string.h>

using namespace std;

void reverseString(char *s){
	char *end = s;
	for(int i=0; s[i] != '\0'; ++i){
		++end;
	}
	--end;
	char temp;
	while(s < end){
		temp = *s;
		*s++ = *end;
		*end-- = temp;
	}
}

void reverseStringWord(char *str, int length){
	//reverseString(str);
	cout<<str<<endl;
	char *start, *end, *tempP;
	start = end = str;
	for(int i=0; i<=length; ++i){
		if(*end == ' ' || *end == '\0'){
			tempP = end;
			--tempP;
			cout<<*start<<endl;
			cout<<*tempP<<endl;
			char temp;
			while(start < tempP){
				temp = *start;
				*start++ = *tempP;
				*tempP-- = temp;
			}
			start = end;
			start++;
		}
		end++;
	}
	cout<<str<<endl;
}

void longestString(char* str){
	int i = 0;
	int max = 0;
	int maxIndex = 0;
	char currentChar = str[i];
	int currentCount = 0;
	while(str[i] != '\0'){
		if(str[i] == currentChar){
			currentCount++;
		}
		else{
			if (currentCount > max){
				max = currentCount;
				maxIndex = i - currentCount;
			}
			currentChar = str[i];
			currentCount = 1;
		}
		i++;
	}
	if (currentCount > max){
		max = currentCount;
		maxIndex = i - currentCount;
	}
	cout<<currentCount<<","<<max<<","<<maxIndex;
}

static void maxSumSub(int arr[], int n){
	int start,end;
	start = end = 0;
	int maxSum, currentSum;
	maxSum = currentSum = 0;
	for(int i=0; i<n; ++i){
		currentSum += arr[i];
		if(currentSum < 0){
			currentSum = 0;
		}
		else if(maxSum < currentSum){
			maxSum = currentSum;
			end = i;
		}
		cout<<"MaxSum:  "<<maxSum<<endl;
	}
	cout<<start<<endl;
	cout<<end<<endl;
}

int main(){
	string input = "hello how are you";
	char arr[] = "hello how are you";
	cout<<input<<endl;
	reverseString(&input[0]);
	cout<<input<<endl;
	//longestString(&input[0]);
	//reverseStringWord(&input[0], input.length());
	//int inp[] = {1,2,3,-4,0,-2,1,2,-1,5};
	//int n = sizeof(inp)/sizeof(*inp);
	//cout<<n<<endl;
	//maxSumSub(inp,n);
}



