/*
 * stacks.h
 *
 *  Created on: Jan 21, 2014
 *      Author: shrawanraina
 */
#ifndef NULL
#define NULL   ((void *) 0)
#endif

#ifndef STACKS_H_
#define STACKS_H_
using namespace std;

struct nodeS{
	char data;
	nodeS *next;
};

nodeS* push(char n,nodeS *head){
	nodeS* temp = new nodeS();
	temp->data = n;
	temp->next = head;
	head = temp;
	return head;
}

nodeS* pop(nodeS *top){
	nodeS* temp = new nodeS();
	if (top == NULL){
		return top;
	}
	temp = top;
	top = top->next;
	free(temp);
	return top;
}

bool isEmpty(nodeS *top){
	bool result = false;
	if(top == NULL)
		result = true;
	return result;
}

nodeS* topStack(nodeS *top){
	if(top != NULL){
		return top;
	}
	else{
		cout<<"Stack is empty"<<endl;
	}
	return 0;
}

void printS(nodeS* top){
	nodeS *temp = top;
	while(temp != NULL){
		std::cout<<temp->data<<" ";
		temp = temp->next;
	}
	std::cout<<std::endl;
}

#endif /* STACKS_H_ */
