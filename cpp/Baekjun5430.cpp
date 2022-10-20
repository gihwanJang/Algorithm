#include <iostream>
#include <list>
#include <sstream>
using namespace std;

list<string> dq;

void split(string input, char delimiter) {
    stringstream ss(input);
    string temp;
 
    while (getline(ss, temp, delimiter))
        dq.push_back(temp);
}

void print_front(int n){
    while(n--){
        cout << dq.front();
        if(n) cout << ",";
        dq.pop_front();
    }
}

void print_back(int n){
    while(n--){
        cout << dq.back();
        if(n) cout << ",";
        dq.pop_back();
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, n;
    bool front;
    string op, arr;
    cin >> T;

    while(T--){
        front = true;
        dq.clear();
        cin >> op >> n >> arr;

        split(arr.substr(1,arr.size() - 2), ',');

        for (int i = 0; i < op.size(); ++i){
            if(op.at(i) == 'R')
                front = !front;
            else{
                --n;
                if(dq.empty()) break;
                else front ? dq.pop_front() : dq.pop_back();
            }
        }
        
        if(n < 0) cout << "error" << "\n";
        else{
            cout << "[";
            front ? print_front(n) : print_back(n);
            cout << "]\n";
        }
    }
    return 0;
}
