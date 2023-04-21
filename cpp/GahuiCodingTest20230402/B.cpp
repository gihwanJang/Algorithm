#include <iostream>
#include <vector>

using namespace std;

int split(string s){
    int res = 0;

    res += stoi(s.substr(0,2))*60*60;
    res += stoi(s.substr(3,2))*60;
    res += stoi(s.substr(6,2));

    return res;
}

int doubleCounting(int n, vector<int>&up, vector<int>&down){
    for(int i = 0; i < up.size(); ++i)
        for(int j = 0; j < down.size(); ++j){
            if(up[i]+40 < down[j]) break;

            if(up[i] <= down[j] && down[j] < up[i] + 40)
                n += up[i] + 40 - down[j];
            else if(down[j] <= up[i] && up[i] < down[j] + 40)
                n += down[j] + 40 - up[i];
        }

    return n;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int ans = 24 * 60 * 60;
    int c, h;
    cin >> c >> h;

    string s;
    vector<int> up(c);
    vector<int> down(h);
    for(int i = 0; i < c; ++i){
        cin >> s;
        up[i] = split(s);
    }
    for(int i = 0; i < h; ++i){
        cin >> s;
        down[i] = split(s);
    }

    ans -= (c+h) * 40;
    cout << doubleCounting(ans, up, down) << "\n";
    return 0;
}
