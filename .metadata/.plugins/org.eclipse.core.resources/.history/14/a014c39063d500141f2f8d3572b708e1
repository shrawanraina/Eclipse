/*
 * hash.h
 *
 *  Created on: Mar 6, 2014
 *      Author: shrawanraina
 */
#include <stdio.h>
#include <iostream>
#include <string>

using namespace std;

#ifndef HASH_H_
#define HASH_H_

class hashTable{
	static const int tableSize = 10;
	struct node{
		string name;
		int marks;
		node* next;
	};
	node* hashTB[tableSize];
public:
	hashTable();
	int hashkey(string s);
	void addNode(string name, int marks);
	void printTable();
	int noOfItems(int index);
};

#endif /* HASH_H_ */
