#include<iostream>

using namespace std;

struct Node
{
   int data;
   struct Node *next;
}*front = NULL,*rear = NULL;

void enqueue(int value)
{
   struct Node *newNode = new struct Node;
   newNode->data = value;
   newNode -> next = NULL;
   if(front == NULL)
      front = rear = newNode;
   else{
      rear -> next = newNode;
      rear = newNode;
   }
   
}
void dequeue()
{
   if(front == NULL)
    cout<<"\nQueue is Empty!!!\n";
   else{
      struct Node *temp = front;
      front = front -> next;
      cout<<"\nDeleted element: %d\n"<< temp->data;
      delete(temp);
   }
}
void display()
{
   if(front == NULL)
      cout<<"\nQueue is Empty!!!\n";
   else{
      struct Node *temp = front;
      while(temp->next != NULL){
	 cout<<temp->data;
	 temp = temp -> next;
      }
      cout<<temp->data;
   }
}    
int main(){
	struct Node *q = NULL;
	enqueue(10);
	enqueue(11);
	enqueue(12);
	display();
	return 0;
}
