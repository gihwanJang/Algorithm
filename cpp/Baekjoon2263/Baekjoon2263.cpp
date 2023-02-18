#include<iostream>

struct Node{
    int val;
    Node* L;
    Node* R;
};


int main(){
    int n;
    scanf("%d", &n);
    int preorder[n], postorder[n];
    for(int i = 0; i < n; ++i) scanf("%d", &preorder[i]);
    for(int i = 0; i < n; ++i) scanf("%d", &postorder[i]);

    return 0;
}