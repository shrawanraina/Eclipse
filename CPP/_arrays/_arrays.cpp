/*
 * Misc.cpp
 *
 *  Created on: Feb 20, 2014
 *      Author: shrawanraina
 */
#include <iostream>
#include <stdio.h>
//#include <string>
//#include <iso646.h>
//#include <map>
//#include "hash.h"
//#include "misc.h"
//#include <climits>

using namespace std;
/*
class Animal{
public:
	void virtual eat(){
		std::cout<<"Animal Class"<<endl;
	}
};

class Cat : public Animal{
public:
	void eat(){
		std::cout<<"Cat Class"<<endl;
	}
};
*/

void maxSubset(int a[], int length){
	int start;
	int end;
	int startTemp;
	int sum = 0;
	int sumFinal = 0;
	for(int i=0; i<length; ++i){
		if(sum < 0){
			sum = a[i];
			startTemp = i;
		}
		else{
			sum+=a[i];
		}
		if(sumFinal <= sum){
			sumFinal = sum;
			end = i;
			start = startTemp;
		}
		cout<<i<<":"<<sum<<endl;
	}
	cout<<endl<<"start: "<<start<<endl<<"end: "<<end<<endl;
}
/*
void func(Animal *abc){
	abc->eat();
}
*/
void insertElement(int arr[], int length, int pos, int data){
	if(length == 0){
		return;
	}
	for(int i=length-1; i>=pos-1; --i){
		arr[i+1] = arr[i];
	}
	arr[pos-1] = data;
	for(int i=0; i< length; ++i){
		std::cout<<arr[i]<<" ";
	}
}

int main(){
/*
	string input = "abcd";
	int a[] = {-1, 3, -4, -6, -3, -8};
	int length = sizeof(a)/sizeof(int);
/*	int pwr;
	int value = atoi(input);
	uniqueString(input);
	cout<<value;
	find_missing_number(a,length);
	maxSubset(a,length);
//    power(2,-2);
/*	number_to_string(1000);
	char s[] = "abc";
	int n = 0;
	for(int i=0;s[i]!='\0';i++){
		n++;
	}
	permutation(s,0,n);
	int a,b;
	cin>>a;
	cin>>b;
	cout<<a<<":"<<b<<":"<<a^b;

	Animal *animal = new Animal();
	Cat *cat = new Cat();
	//animal->eat();
	//cat->eat();
	func(animal);
	func(cat);
    return 0;
*/
	int arr[8] = {10, 5, 46, 2, 100, 97};
    int length = sizeof(arr)/sizeof(*arr);
    //std::cout<<length<<endl;
    insertElement(arr,length,3,12);
    return 0;
}


