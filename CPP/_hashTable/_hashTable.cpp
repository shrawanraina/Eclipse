/*
 * main.cpp
 *
 *  Created on: Mar 6, 2014
 *      Author: shrawanraina
 */

#include <iostream>
#include <stdio.h>
#include <string>
#include <unordered_map>
using namespace std;
std::unordered_map<char,int> mymap;

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

hashTable::hashTable(){
	for(int i=0;i<tableSize;i++){
		hashTB[i] = new node();
		hashTB[i]->name = "null";
		hashTB[i]->marks = 0;
		hashTB[i]->next = NULL;
	}
}

int hashTable::hashkey(string s){
	int length = s.length();
		int hash = 0;
		int index;
		for(int i=0;i<length;i++){
			hash = hash + (int)s[i];
		}
		index = hash%tableSize;
		cout<<index<<endl;
		return index;
}

void hashTable::addNode(string name, int marks){
	int index = hashkey(name);
	if(hashTB[index]->name == "null"){
		hashTB[index]->name = name;
		hashTB[index]->marks = marks;
		hashTB[index]->next = NULL;
	}
	else{
		node* temp1 = new node();
		temp1->name = name;
		temp1->marks = marks;
		temp1->next = NULL;
		node* crnt = hashTB[index];
		while(crnt->next!=NULL){
			crnt=crnt->next;
		}
		crnt->next = temp1;
	}
}

void hashTable::printTable(){
	for(int i=0;i<tableSize;i++){
		int num = noOfItems(i);
		cout<<"Name: "<<hashTB[i]->name<<endl;
		cout<<"Marks: "<<hashTB[i]->marks<<endl;
		cout<<"No. of Items: "<<num<<endl;
		cout<<endl;
	}
}

int hashTable::noOfItems(int index){
	int count = 0;
	if(hashTB[index]->name == "null"){
		return count;
	}
	else{
		count++;
		node* ptr = hashTB[index];
		while(ptr->next!=NULL){
			count++;
			ptr = ptr->next;
		}
	}
	return count;
}

int main(){
	hashTable obj;
	//int hash = obj.hashkey("s");
	//cout<<hash<<endl;
/*
	obj.addNode("a",10);
	obj.addNode("a",20);
	obj.addNode("a",30);
	obj.addNode("b",40);
	obj.addNode("b",80);
	obj.addNode("c",50);
	obj.addNode("d",60);
	obj.printTable();
*/
	char first[] = {'a','b','c','d','e','e'};
	char second[] = {'a','b','d','e','e'};
	int length = sizeof(second)/sizeof(*second);
	for(int i=0; i<length; ++i){
		mymap[second[i]] += 1;
	}
	for ( auto it = mymap.begin(); it != mymap.end(); ++it )
	    std::cout << " " << it->first << ":" << it->second;
	cout<<endl;
	length = sizeof(first)/sizeof(*first);
	return 0;
}

