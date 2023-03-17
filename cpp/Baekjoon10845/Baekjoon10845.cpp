#include <iostream>

using namespace std;

struct node{
    int value;
    node*next = NULL;
};

class queue{
private:
    int size_q;
    node* head;
    node* tail; 
public:
    queue();
    void push(int v);
    int pop();
    int size();
    bool empty();
    int front();
    int back();
};

queue::queue(){
    size_q = 0;
    head = NULL;
    tail = NULL;
}

void queue::push(int v){
    node*new_node = new node;
    new_node->value = v;

    if(size_q == 0)
        head = new_node;
    else
        tail->next = new_node;

    tail = new_node;
    ++size_q;
}

int queue::pop(){
    if(!size_q) return -1;

    node*rm_node = head;
    int res = rm_node->value;

    head = rm_node->next;
    --size_q;

    delete rm_node;
    return res;
}

int queue::size(){
    return size_q;
}

bool queue::empty(){
    return !size_q;
}

int queue::front(){
    if(!size_q) return -1;
    return head->value;
}

int queue::back(){
    if(!size_q) return -1;
    return tail->value;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    queue que;

    int n, v;
    cin >> n;

    string s;
    while(n--){
        cin >> s;

        if(s == "push"){
            cin >> v;
            que.push(v);
        }
        else if(s == "pop")
            cout << que.pop() << "\n";
        else if(s == "size")
            cout << que.size() << "\n";
        else if(s == "empty")
            cout << que.empty() << "\n";
        else if(s == "front")
            cout << que.front() << "\n";
        else
            cout << que.back() << "\n";
    }
    return 0;
}
