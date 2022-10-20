#include <iostream>
#include <algorithm>
using namespace std;

bool cmp(string a, string b){
    if(a[0] < b[0]) return true;
    else if(a[0] > b[0]) return false;
    else{
        if(a.length() > 0 && b.length() > 0)
            return cmp(a.substr(1, a.length() - 1), b.substr(1, b.length() - 1));
        else 
            return false;
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s, subset[1000];

    cin >> s;
    for(int i = 0; i < s.length(); ++i)
        subset[i] = s.substr(i, s.length() - i);
    sort(subset, subset + s.length(), cmp);

    for(int i = 0; i < s.length(); ++i)
        cout << subset[i] << "\n";
    return 0;
}
