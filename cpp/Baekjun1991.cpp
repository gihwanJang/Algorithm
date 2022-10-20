#include<iostream>
using namespace std;

struct Node{
    char item;
    Node*left;
    Node*right;
};

void preorder(Node node){
    cout<<node.item;
    if(node.left != nullptr)preorder(*node.left);
    if(node.right != nullptr)preorder(*node.right);
}

void inorder(Node node){
    if(node.left != nullptr)inorder(*node.left);
    cout<<node.item;
    if(node.right != nullptr)inorder(*node.right);
}

void postorder(Node node){
    if(node.left != nullptr)postorder(*node.left);
    if(node.right != nullptr)postorder(*node.right);
    cout<<node.item;
}

int main(){
    int N;
    cin>>N;
    
    Node nodes[N];
    for(int i = 0; i < N; ++i){
        Node newNode = {('A'+i), nullptr, nullptr};
        nodes[i] = newNode;
    }

    for(int i = 0; i < N; ++i){
        char c, l, r;
        cin>>c>>l>>r;
        if(l != '.')nodes[c-'A'].left = &nodes[l-'A'];
        if(r != '.')nodes[c-'A'].right = &nodes[r-'A'];
    }

    preorder(nodes[0]);
    cout<<endl;
    inorder(nodes[0]);
    cout<<endl;
    postorder(nodes[0]);
    cout<<endl;

    return 0;
}