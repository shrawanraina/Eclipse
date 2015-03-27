#include<iostream>
//#include<conio.h>
#include<stdlib.h>
using namespace std;

class node{
public:
	class node *next;
	int data;
};

class stack : public node {
public:
	node *head;
	stack(){
		head = NULL;
	}
	void push(int x){
		if(head == NULL){
			head = new node;
			head->next = NULL;
			head->data = x;
		}
		else{
			node *temp;
			temp = new node;
			temp->data = x;
			temp->next = head;
			head = temp;
		}
	}
	void display(){
		node *temp;
		temp = head;
		while(temp != NULL){
			cout <<temp->data<< " ";
			temp = temp->next;
		}
		cout<<endl;
	}
	int pop(){
		node *temp;
		temp = head;
		head = temp->next;
		int x = temp->data;
		delete(temp);
		return x;
	}
};
class queue : public stack {
	stack stack1;
	stack stack2;
public:
	void enqueue(int x){
		stack1.push(x);
	}

	int dequeue(){
		int x;
		if(stack2.head == NULL){
			while(stack1.head != NULL){
				x = stack1.pop();
				//cout<<x<<endl;
				stack2.push(x);
			}
		}
		x = stack2.pop();
		return x;
	}
};


int main(){
	int x;
/*
	stack s1;
	s1.push(10);
	s1.push(20);
	stack s2;
	s2.push(30);
	s2.push(40);
	s2.push(50);
	s2.display();
	s1.display();
	int x = s2.pop();
	s2.display();
	cout<<x<<endl;
*/
	queue queue1;
	queue1.enqueue(10);
	queue1.enqueue(20);
	queue1.enqueue(30);
	x = queue1.dequeue();
	cout<<x<<endl;
	x = queue1.dequeue();
	cout<<x<<endl;
	return (0);
}
