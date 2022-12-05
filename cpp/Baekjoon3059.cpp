#include <iostream>
#include <unordered_set>

using namespace std;

int charSum(string s){
    unordered_set<char> set;
    int ans = 0;

    for(int i = 0; i < s.length(); ++i)
        set.insert(s[i]);

    for(int i = 65; i < 91; ++i)
        if(!set.count(i))
            ans += i;

    return ans;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    while(N--){
        string s;
        cin >> s;
        cout << charSum(s) << "\n";
    }
    return 0;
}
