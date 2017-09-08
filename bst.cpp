#include<iostream>
#include<stdio.h>
#include<cstdio>

using namespace std;

struct node{
	
	int data;
	struct node *left;
	struct node *right;
};

//class bst{
	
	struct node *newnode(int data){
		struct node *temp = new struct node;
		temp->data = data;
		temp->left = temp->right = NULL;
		return temp;
	}
	
	struct node  *insert(struct node *n, int data){
		if(n == NULL){
		return newnode(data);
		}
		if(data >= n->data)
		n->right = insert(n->right, data);
		
		else 
		n->left = insert(n->left, data);
		
		return n;
		
		
	}
	
	void inorder(struct node *root){
	
		if(root == NULL )
			return;
			else{
			inorder(root->left);
			cout<<"bst: \n"<<root->data<<endl;
			inorder(root->right);
		}
	
	}
	


	int main(){
		
		struct node *root = NULL;
		//bst tree = new bst;
		root = insert(root, 20);	
		insert(root, 25);
		insert(root, 10);
		insert(root, 25);
		insert(root, 15);
		
		inorder(root);
		return 0;
	}
