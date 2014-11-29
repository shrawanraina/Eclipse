/*
 * stacks.h
 *
 *  Created on: Jan 21, 2014
 *      Author: shrawanraina
 */

#ifndef QUEUE_H_
#define QUEUE_H_
#include <iostream>
using namespace std;

#ifndef NULL
#define NULL   ((void *) 0)
#endif

struct nodeQ{
	char data;
	nodeQ *next;
};

void enQueue(nodeQ** front, nodeQ** rear, char n){
	struct nodeQ* temp = new nodeQ();
	temp->data = n;
	temp->next = NULL;
	if(*front == NULL && *rear == NULL){
		*front = *rear = temp;
		return;
	}
	(*rear)->next = temp;
	*rear = temp;
}

char deQueue(nodeQ** front){
	nodeQ* temp = new nodeQ();
	char item;
	temp = *front;
	if(*front == NULL)
		return 0;
	else
		item = (*front)->data;
		*front = (*front)->next;
	free(temp);
	return item;
}

void printQ(nodeQ* front){
	nodeQ* temp = front;
	while(temp != NULL){
		std::cout<<temp->data<<" ";
		temp = temp->next;
	}
	std::cout<<std::endl;
}

#endif /* QUEUE_H_ */
