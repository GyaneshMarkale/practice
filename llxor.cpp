#include<iostream>
#include<stdint.h>

using namespace std;

struct node{
	int data;
	node *n;
};
	struct node *llxor(struct node *x, struct node *y){
		return (struct node *) ((intptr_t)(x) ^ (intptr_t)(y));
	}	
	 struct node *insertnode(struct node ** head , int data){
		struct node *Nnode = new struct node;
		Nnode->data = data;
		Nnode->n = llxor(*head , NULL);
		
		if((*head) != NULL){
			
			struct node *next = llxor((*head)->n, NULL);
			(*head)->n = llxor(Nnode, next);
		}
		*head = Nnode;
		
	}
	
	void print(struct node *h){
		
		struct node *curr = h;
		struct node *prev = NULL;
		struct node *next; 
		
		while(curr != NULL){
			
			cout<<curr->data;
			next = llxor(prev, curr->n);
			
			prev = curr;
			curr = next;
		}
		
	}
	
	int main(){
		
		struct node *root = NULL;
		insertnode(&root, 1);
		insertnode(&root, 2);
		insertnode(&root ,3);
		print(root);
		
		return 0;
	
	}
