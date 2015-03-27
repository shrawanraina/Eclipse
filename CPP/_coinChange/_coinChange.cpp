/*
 * coinChange.cpp
 *
 *  Created on: Mar 12, 2014
 *      Author: shrawanraina
 */

#include <iostream>
#include <stdlib.h>
#define C 17

/* Minimum and maximum values a `signed int' can hold.  */
#  define INT_MIN   (-INT_MAX - 1)
#  define INT_MAX   2147483647

using namespace std;
// In this example we take the amount as 17, and a total of
// 4 denominations of coins

int main()
{
    int coins[]={1,2,5,10};
    int amount[C + 1];
    for(int i = 0; i < (C+1); ++i){
		amount[i] = INT_MAX;
		cout <<amount[i]<<" ";
	}
    amount[0] = 0;
    cout<<endl;
    for(int i=1; i<=C; i++){
        for(int c = 0; c < 4;c++){
            // if the value of the coin is less than the amount
        	if(coins[c] <= i && amount[i-coins[c]] + 1 < amount[i]){
				amount[i] = amount[i-coins[c]] + 1;
			}
        }
    }
    cout<<"The minimum number of coins to be used for amount "<<C<<" are "<<amount[C]<<endl;
    for(int i = 0; i < 18; ++i){
    	cout<<amount[i]<<" ";
    }
    return 0;
}


