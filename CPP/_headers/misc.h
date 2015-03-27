/*
 * misc.h
 *
 *  Created on: Mar 6, 2014
 *      Author: shrawanraina
 */
#include <stdio.h>
#include <string>

using namespace std;

#ifndef MISC_H_
#define MISC_H_

int atoi(string s){
	int res;
	int i = 0;
	int sign = 1;
	if(s[i] == '-'){
		sign = -1;
		i++;
	}
	while(s[i] != '\0'){
		res = res * 10 + s[i] - '0';
		i++;
	}
	return res*sign;
}

bool uniqueString(string s){
	bool ascii[256];
	for(int i=0;s[i]!= '\0';i++){
		if(ascii[i]){
			return false;
		}
		ascii[i] = true;
	}
	return true;
}

void find_missing_number(int *v, int v_length) {
    // Write your code here
    // To print results to the standard output you can use printf()
    // Example: printf("%s", "Hello world!");
    int sum = 0;
    int sumS = 0;
	for(int i=0;i<v_length;i++){
    	sum = sum + v[i];
    	sumS = sumS+v[i]*v[i];
    }
	int totalSum = (v_length+2)*(v_length+3)/2;
	int totalSquare = ((v_length+2)*(v_length+3)*(2*(v_length+2)+1))/6;
	cout<<v_length<<":"<<sum<<":"<<totalSum<<":"<<totalSquare<<":"<<sumS;
}

void power(int n, int x){
	float res = 1;
	bool val = true;
	if(x < 0){
		x = -x;
		val = false;
	}
	if(x == 0){
		res = 1;
	}
	else{
		for(int i=0;i< x;i++){
			res = res * n;
		}
	}
	if(val)
		cout<<res<<endl;
	else
		cout<<1/res<<endl;
}

void number_to_string(int val){
	const char* Ones[20] = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen",
	"Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	const char* Tens[10] = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	if(val < 0){
		cout<<"minus ";
		number_to_string(-val);
	}
	else if(val >= 1000){
		number_to_string(val/1000);
		cout<<" thousand";
		if(val%1000){
			cout<<" ";
			number_to_string(val%1000);
		}
	}
	else if(val >= 100){
		number_to_string(val/100);
		cout<<" hundred";
		if (val%100){
			cout<<" and ";
			number_to_string(val%100);
		}
	}
	else if(val >= 20){
		int t = val/10;
		cout<<Tens[t];
		if(val%10){
			cout<<" ";
			number_to_string(val%10);
		}

	}
	else{
		cout<<Ones[val];
	}
}

void swap(char *x,char *y){
	char temp;
	temp = *x;
	*x = *y;
	*y = temp;
}

void permutation(char *a, int i, int n){
	if( i == n){
		cout<<a<<endl;;
	}
	for(int j = i;j<n;j++){
		swap((a+i),(a+j));
		permutation(a,i+1,n);
		//swap((a+i),(a+j));
	}
}

#endif /* MISC_H_ */
