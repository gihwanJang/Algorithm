#include <iostream>
#include <unordered_set>

using namespace std;

void checkContain(string s, unordered_set<string>&set){
    int size = s.size();
    string tmp = s;
    for(int i = 0; i < size; ++i){
        if(set.count(s.substr(i, size)))
            return;
        s.push_back(s[i]);
    }
    set.insert(tmp);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    string s;
    unordered_set<string> set(50);
    for(int i = 0; i < n; ++i){
        cin >> s;
        checkContain(s, set);
    }

    cout << set.size() << "\n";
    return 0;
}
