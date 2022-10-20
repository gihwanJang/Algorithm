#include<iostream>
using namespace std;

struct Node{
    int val;
    Node* L;
    Node* R;
};

void insert(Node* root, int value){
    Node* curr = root;
    Node* newNode = new Node;
    newNode->val = value;
    newNode->L = NULL;
    newNode->R = NULL;

    while(true){
        if(curr->val > value){
            if(curr->L != NULL)
                curr = curr->L;
            else{
                curr->L = newNode;
                break;
            }
        }
        else{
            if(curr->R != NULL) curr = curr->R;
            else{
                curr->R = newNode;
                break;
            }
        }
    }
}

void solution(Node node){
    if(node.L != NULL) solution(*node.L);
    if(node.R != NULL) solution(*node.R);
    printf("%d\n", node.val);
}


int main(){
    int val;
    scanf("%d", &val);
    Node root = {val, NULL, NULL};

    while(scanf("%d", &val)!=EOF)
        insert(&root, val);
    
    solution(root);
    return 0;
}