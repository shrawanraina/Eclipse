/*
 * bst.cpp
 *
 *  Created on: Jan 21, 2014
 *      Author: shrawanraina
 */
#include <iostream>
#include <stdlib.h>
#include <queue>
using namespace std;

struct bstnode{
	char data;
	bstnode* left;
	bstnode* right;
};

bstnode* newBST(char data){
		bstnode* temp = new bstnode();
		temp->data = data;
		temp->left = NULL;
		temp->right = NULL;
		return temp;
}

void insertBST(bstnode** root,char data){
	if (*root == NULL){
		*root = newBST(data);
	}
	else if (data < (*root)->data){
		insertBST(&(*root)->left,data);
	}
	else {
		insertBST(&(*root)->right,data);
	}
}

void preOrder(bstnode* root){
	if(root != NULL){
		cout<<root->data<<" ";
		preOrder(root->left);
		preOrder(root->right);
	}
}

void inOrder(bstnode* root){
	if(root != NULL){
		inOrder(root->left);
		cout<<root->data<<" ";
		inOrder(root->right);
	}
}

void postOrder(bstnode* root){
	if(root != NULL){
		postOrder(root->left);
		postOrder(root->right);
		cout<<root->data<<" ";
	}
}

int height(bstnode* root){
	if(root == NULL){
		return 0;
	}
	else{
		int lheight = height(root->left)+1;
		int rheight = height(root->right)+1;
		if(lheight <= rheight){
			return rheight;
		}
		else return lheight;
	}
}

void printLevel(bstnode* root, int level){
	if (root  == NULL)
		return;
	if (level == 1){
		cout<<root->data<<" ";
	}
	else if(level > 1){
		printLevel(root->left,level-1);
		printLevel(root->right,level-1);
	}
}

void printLevelOrder(bstnode* root){
	int h = height(root);
	std::cout<<"Height: "<<h<<endl;
	for(int i = 1;i<=h;i++){
		printLevel(root,i);
	}
}

void printLevelOrderQ(bstnode *root){
	std::queue<bstnode*> q;
	q.push(root);
	while(!q.empty()){
		bstnode *current = q.front();
		std::cout<<current->data<<" ";
		if(current->left != NULL)
			q.push(current->left);
		if(current->right != NULL)
			q.push(current->right);
		q.pop();
	}
}

bstnode* searchBST(char key,bstnode* root){
	if(root == NULL){
		return nullptr;
	}
	if(key == root->data){
		return root;
	}
	else if (key < root->data)
		return searchBST(key,root->left);
	else
		return searchBST(key,root->right);
}

bstnode* findSmallestRight(bstnode* current){
	while(current->left != NULL){
		current  = current->left;
	}
	cout<<current->data;
	return current;
}

bstnode* _deleteBST(char key, bstnode *root){
	if(root == NULL)
		return root;
	else if(key < root->data)
		root->left = _deleteBST(key, root->left);
	else if(key > root->data)
		root->right = _deleteBST(key, root->right);
	else{
		if(root->left == NULL and root->right == NULL){
			delete root;
			root = NULL;
		}
		else if(root->left == NULL){
			bstnode *temp = root;
			root = root->right;
			delete temp;
		}
		else if(root->right == NULL){
			bstnode *temp = root;
			root = root->left;
			delete temp;
		}
		else{
			bstnode *temp = findSmallestRight(root->right);
			root->data = temp->data;
			root->right = _deleteBST(temp->data, root->right);
		}
	}
	return root;
}

void isBST(bstnode* root, int *arr, int *n){
	if (root == NULL)
		return;
	isBST(root->left, arr, n);
	arr[*n] = root->data;
	(*n)++;
	isBST(root->right, arr, n);
}

int main(){
	bstnode* root = new bstnode();
	root = NULL;
	int arr[15],n = 0;
 	insertBST(&root,'f');
	insertBST(&root,'d');
	insertBST(&root,'j');
	insertBST(&root,'b');
	insertBST(&root,'e');
	insertBST(&root,'g');
	insertBST(&root,'k');
	insertBST(&root,'a');
	insertBST(&root,'c');
	insertBST(&root,'i');
	insertBST(&root,'h');
	//printLevelOrderQ(root);
	std::string inp = "what";
	std::cout<<inp[0];
	/*
	isBST(root,arr,&n);
	for(int i=0;arr[i]!='\0';i++){
		cout<<(char)arr[i]<<" ";
	}

	printLevelOrder(root);
	root = _deleteBST('d',root);
	std::cout<<endl;
	printLevelOrder(root);
*/
/*
	std::cout<<endl;
	preOrder(root);
	std::cout<<endl;
	inOrder(root);
	std::cout<<endl;
	postOrder(root);
*/
//	levelOrderTraversal(root);
//	bstnode* tmp = new bstnode();
//	deleteBST('c',&root);
//	int ht = height(root);
//	cout<<ht<<endl;
//	printLevelOrder(root);
	return 0;
}



