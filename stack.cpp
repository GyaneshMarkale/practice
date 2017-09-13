#include <iostream>
#include <cstdlib>

using namespace std;

class node {
public:
    int data;
    node* next;
};
class stack {
private:
    int size;
    node* head;
    int maxstack;

public:
    stack(int max)
    {
        size = 0;
        head = NULL;
        maxstack = max;
    }
    void push(int data)
    {
        if (size == maxstack - 1)
            cout << "err:stack overflow";
        //return
        else {
            node* top = new node;
            if (head == NULL) {
                top->data = data;
                top->next = NULL;
                head = top;
                size++;
            }
            else {
                top->data = data;
                top->next = head;
                head = top;
                size++;
            }
        }
    }
    int pop()
    {
        if (head == NULL) {
            cout << "err: stack empty" << endl;
        }
        else {
            node* old = head;
            head = head->next;
            delete (old);
            size--;
        }
    }
    void print()
    {
        node* temp;
        temp = head;
        while (temp != NULL) {
            cout << temp->data << "\n";
            temp = temp->next;
        }
    }
};
class stack2 = public stack{

};
int main(int argc, char** argv)
{
    stack* s = new stack(100);
    s->push(12);
    s->push(10);
    //s->push(14);
    s->print();
    s->pop();
    s->print();
    s->pop();
    s->print();
    s->pop();
    s->print();
    return 0;
}

