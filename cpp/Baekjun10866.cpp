#include <iostream>
#include <list>
using namespace std;

list<int> deque;

void operate(string s){
    int n;
    if(s == "push_back"){
        cin >> n;
        deque.push_back(n);
    }
    else if(s == "push_front"){
        cin >> n;
        deque.push_front(n);
    }
    else if(s == "pop_back"){
        cout << (deque.empty() ? -1 : deque.back()) << "\n";
        if(!deque.empty()) deque.pop_back();
    }
    else if(s == "pop_front"){
        cout << (deque.empty() ? -1 : deque.front()) << "\n";
        if(!deque.empty()) deque.pop_front();
    }
    else if(s == "back")
        cout << (deque.empty() ? -1 : deque.back()) << "\n";
    else if(s == "front")
        cout << (deque.empty() ? -1 : deque.front()) << "\n";
    else if(s == "size")
        cout << deque.size() << "\n";
    else
        cout << (deque.empty() ? 1 : 0) << "\n";
}

int main(int argc, char const *argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    string s;

    cin >> n;
    while(n--){
        cin >> s;
        operate(s);
    }
    return 0;
}
