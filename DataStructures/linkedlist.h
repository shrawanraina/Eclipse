/*
 * linkedlist.h
 *
 *  Created on: Jan 21, 2014
 *      Author: shrawanraina
 */

#ifndef LINKEDLIST_H_
#define LINKEDLIST_H_
#include <stdlib.h>
struct nodell{
	int data;
	nodell* next;
};

nodell* insertLL(int data, int n){
	head = NULL;
	nodell* temp = new nodell();
	temp->data = data;
	temp->next = NULL;
	if(n == 1){
		temp->next = head;
		head = temp;
	}
	nodell* temp2 = head;
	for(int i=1;i<n-1;i++){
		temp2 = temp2->next;
	}
	temp->next = temp2->next;
	temp2->next = temp;
	return head;
}

void deleteLL(nodell* head, int n){
	nodell* temp = head;
	for(int i=1;i<n-1;i++){
		temp = temp->next;
	}
	nodell* temp2 = temp->next;
	temp->next = temp2->next;
	free(temp2);
}

void printLL(){
	nodell* temp = head;
	while(temp != NULL){
		std::cout<<temp->data;
		temp->next=temp;
	}
	std::cout<<std::endl;
}

#endif /* LINKEDLIST_H_ */
