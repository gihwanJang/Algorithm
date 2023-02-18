#include <iostream>
#include <unordered_set>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_set<int> set(100000);
    int M, value;
    string commend;
    cin >> M;

    while(M--){
        cin >> commend;
        if(commend.compare("add") == 0){
            cin >> value;
            set.insert(value);
        }
        else if(commend.compare("remove") == 0){
            cin >> value;
            set.erase(value);
        }
        else if(commend.compare("check") == 0){
            cin >> value;
            cout << (set.count(value) ? 1 : 0) << "\n"; 
        }
        else if(commend.compare("toggle") == 0){
            cin >> value;
            if(set.count(value))
                set.erase(value);
            else
                set.insert(value);
        }
        else if(commend.compare("all") == 0){
            for(int i = 1; i < 21; ++i)
                set.insert(i);
        }
        else{
            set.clear();
        }
    }
    return 0;
}
