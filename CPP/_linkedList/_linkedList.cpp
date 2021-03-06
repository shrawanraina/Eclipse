/*
 * CPP.cpp
 *
 *  Created on: Jan 21, 2014
 *      Author: shrawanraina
 */
#include <iostream>
#include <string>

//#include "sorting.hing.h"
//#include "linkedlist.h"

using namespace std;
struct nodeQ *frontQ;
struct nodeQ *rearQ;

struct nodell{
	int data;
	nodell* next;
};
nodell* head = new nodell();

void insertLL(int data, int n){
	nodell* temp = new nodell();
	temp->data = data;
	temp->next = NULL;
	if(n == 1){
		temp->next = head;
		head = temp;
		return;
	}
	nodell *temp2 = head;
	for(int i=1;i<n-1;i++){
		temp2 = temp2->next;
	}
	temp->next = temp2->next;
	temp2->next = temp;
}

void deleteLL(int n){
	nodell *temp = head;
	if (n == 1){
		head = temp->next;
		free(temp);
		return;
	}
	for(int i=1;i<n-1;i++){
		temp = temp->next;
	}
	nodell *temp2 = temp->next;
	temp->next = temp2->next;
	free(temp2);
}

void printLL(){
	nodell *temp = head;
	while(temp != NULL){
		std::cout<<temp->data<<" ";
		temp = temp->next;
	}
	std::cout<<std::endl;
}
/*
void deleteSPL(nodell* head, int n){
	int count = 0, mid = 0;
	nodell *temp = head;
	while(temp != NULL){
		temp = temp->next;
		count++;
	}
	if (count%2 == 0){
		mid = count/2;
		if(n < mid){

		}
	}
	else
		mid = (count/2)+1;
		if(n >= mid){

		}
	cout<<mid<<endl;

}
*/
void printLLR(nodell *temp){
	if(temp ==  NULL){
		return;
	}
	std::cout<<temp->data<<" ";
	printLLR(temp->next);
	//std::cout<<temp->data<<" ";
}

void reverseLL(nodell *temp){
	if(temp->next ==  NULL){
		head = temp;
		return;
	}
	reverseLL(temp->next);
	nodell* temp1 = temp->next;
	temp1->next = temp;
	temp->next = NULL;
}

nodell* reverseLLI(nodell *temp){
	struct nodell *curr, *prev, *next;
	curr = temp;
	prev = NULL;
	while(curr != NULL){
		next = curr->next;
		curr->next = prev;
		prev = curr;
		curr = next;
	}
	return prev;
}

void palindrome(nodell* temp){
	nodell *cur = temp;
	nodell *left = NULL;
	while(cur!= NULL){
		nodell* right = cur->next;
		cur->next = left;
		left = cur;
		cur = right;
	}
	head = left;
	//cout<<cur->data<<":"<<left->data<<":"<<right->data;
}

/*
void checkSyntax(char* s,int n){
	for(int i=0;i<n;i++){

	}
}*/

int main() {
/*
	frontQ = NULL;
	rearQ = NULL;
	enQueue(&frontQ,&rearQ,'a');
	enQueue(&frontQ,&rearQ,'b');
	//printQ(rearQ);
	enQueue(&frontQ,&rearQ,'c');
	enQueue(&frontQ,&rearQ,'d');
	printQ(frontQ);
	char temp = deQueue(&frontQ);
	cout<<temp<<endl;
	printQ(frontQ);
	//printQ(rearQ);
*/
/*
	nodeS* top = new nodeS();
	top = NULL;
	string maths = "{}[]";
	int length = maths.length();
	bool empty = isEmpty(top);
	cout<<empty<<endl;
	nodeS* temp = topStack(top);
	printS(temp);
	top = push('a',top);
	top = push('b',top);
	temp = topStack(top);
	top = push('c',top);
	printS(temp);
	top = push('d',top);
	printS(top);
	top = pop(top);
	printS(top);
*/
	head = NULL;
	insertLL(10,1);
	insertLL(20,2);
	insertLL(30,3);
	insertLL(40,4);
	insertLL(50,5);
	//printLL();
	//deleteLL(3);
	printLL();
	//palindrome(head);
	//printLL();
	//deleteSPL(head,4);
	//printLL();
	//reverseLL(head);
	//printLL();
	head = reverseLLI(head);
	printLL();
/*
*/
}
