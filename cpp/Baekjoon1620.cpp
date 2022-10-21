#include<iostream>
#include<unordered_map>
using namespace std;

int main(int argc, char const *argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, m;
    string s;
    cin >> n >> m;

    unordered_map<string, string> map1(n*2), map2(n*2);

    for(int i = 0; i < n; ++i){
        cin >> s;
        map1.insert(make_pair(s, to_string(i+1)));
        map2.insert(make_pair(to_string(i+1), s));
    }

    for(; m > 0; --m){
        cin >> s;
        if(s[0] < 58)
            cout << map2.find(s)->second << "\n";
        else
            cout << map1.find(s)->second << "\n";
    }

    return 0;
}
