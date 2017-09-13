#include <iostream>
#include <cstdio>
#include <stdlib.h>

using namespace std;

int height = 0;

struct node {
    int data;
    struct node* left;
    struct node* right;
    int height;
};

class Avltree {

    struct node* newnode(int data)
    {
        struct node* temp = new struct node;
        temp->data = data;
        temp->left = temp->right = NULL;
        temp->height = 1;
        return temp;
    }

    int height(struct node* h)
    {
        if (h == NULL)
            return 0;
        return h->height;
    }

private:
    struct node* rotateRight(struct node* root)
    {

        struct node* newroot = root->left;
        root->left = newroot->right;
        newroot->right = root;
        root->height = 1 + max(height(root->left), height(root->right));
        newroot->height = 1 + max(height(root->left), height(root->right));
        return newroot;
    }

private:
    struct node* rotateLeft(struct node* root)
    {

        struct node* newroot = root->right;
        root->right = newroot->left;
        newroot->left = root;
        root->height = 1 + max(height(root->left), height(root->right));
        newroot->height = 1 + max(height(root->left), height(root->right));
        return newroot;
    }

public:
    struct node* insert(struct node* n, int data)
    {

        if (n == NULL)
            return newnode(data);

        if (n->data <= data) {
            n->right = insert(n->right, data);
        }
        else
            n->left = insert(n->left, data);
            
            n->height = 1+max(height(n->left), height(n->right));

        int balance = height(n->left) - height(n->right);

        if (balance > 1) {

            if (height(n->left->left) >= height(n->left->right)) {

                return rotateRight(n);
            }
            else
                n->left = rotateLeft(n->left);
            return rotateRight(n);
        }

        if (balance < -1) {

            if (height(n->right->right) >= height(n->right->left)) {

                return rotateLeft(n);
            }
            else

                n->right = rotateRight(n->right);
            return rotateLeft(n);
        }

        n->height = 1 + max(height(n->left), height(n->right));
        return n;
        cout << "check" << endl;
    }

    void preorder(struct node* root)
    {

        if (root == NULL)
            return;
        else
            cout << "\t" << root->data<<"\n";
        preorder(root->left);
        preorder(root->right);
    }
    
    void inorder(struct node* root)
    {

        if (root == NULL)
            return;
        else
            
        inorder(root->left);
        cout << "\t" << root->data;
        inorder(root->right);
    }
};


int main()
{

    Avltree t;
    struct node* root = NULL;

    root = t.insert(root, 20);
    root = t.insert(root, 15);
    root = t.insert(root, 25);
    root = t.insert(root, 10);
    root = t.insert(root, 18);
    root = t.insert(root, 50);

    t.preorder(root);
    t.inorder(root);

    return 0;
}
