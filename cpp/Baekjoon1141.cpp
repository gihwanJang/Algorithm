#include <iostream>
#include <set>
#include <utility>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    set<string> X;
    string s;
    while(N--){
        cin >> s;
        X.insert(s);
    }

    set<string>::iterator curr = X.begin();
    set<string>::iterator nextIt = next(curr, 1);
    while(nextIt != X.end()){
        if(*curr == (*nextIt).substr(0,curr->length()))
            X.erase(curr);
            
        curr = nextIt;
        nextIt = next(curr, 1);
    }

    cout << X.size() << "\n";
    return 0;
}
