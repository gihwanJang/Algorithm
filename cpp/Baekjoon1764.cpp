#include<iostream>
#include<unordered_set>
#include<vector>
#include<algorithm>
using namespace std;

int main(int argc, char const *argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    string s;
    cin >> n >> m;
    unordered_set<string> set(n*2);
    vector<string> visited;

    for(; n > 0; --n){
        cin >> s;
        set.insert(s);
    }

    for(; m > 0; --m){
        cin >> s;
        if(set.count(s))
            visited.push_back(s);
    }

    sort(visited.begin(), visited.end());

    cout<< visited.size() << "\n";
    for(vector<string>::iterator it = visited. begin(); it != visited.end(); ++it)
        cout<< *it << "\n";

    return 0;
}
