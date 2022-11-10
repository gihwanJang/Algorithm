#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

// (a > b) -> (a - b)
string subtract(string a, string b){
    string sub = "";
    int a_c, b_c;

    for(int i = 1; i <= b.length(); ++i){
        a_c = a[a.length() - i] - '0';
        b_c = b[b.length() - i] - '0';
        
        if(a_c - b_c < 0){
            int j = 1;
            while(a[a.length() - i - j] == 0){
                a[a.length() - i - j] = '9';
                ++j;
            }
            a[a.length() - i - j] -= 1;
            sub.push_back(('0' + 10 + a_c - b_c));
        }
        else
            sub.push_back('0' + a_c - b_c);
    }

    for(int i = b.length() + 1; i <= a.length(); ++i)
        sub.push_back(a[a.length() - i]);

    while(sub.length() != 1 && sub.back() == '0')
        sub.pop_back();

    reverse(sub.begin(), sub.end());

    return sub;
}

bool cmp(string a, string b){
    if(a.length() > b.length())
        return true;
    else
        return a >= b;
}

string increaseString(string a){
    int i = a.length() - 1;
    while(a[i] == '9'){
        a[i] = '0';
        --i;
    }
    if(i == -1){
        a.push_back('1');
        reverse(a.begin(), a.end());
    }
    else
        a[i] += 1;
    return a;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string n, m, ans = "0";
    cin >> n >> m;

    while(cmp(n, m)){
        ans = increaseString(ans);
        n = subtract(n, m);
    }

    cout << ans << "\n";
    cout << n << "\n";
    return 0;
}
