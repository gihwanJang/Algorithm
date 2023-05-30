#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

void removeString(string&str, string&target){
    string res= "";
        
    for(int i = 0; i < str.size(); ++i){
        res.push_back(str[i]);

        if(res.size() >= target.size())
            if(res.substr(res.size() - target.size()) == target)
                for(int j = 0; j < target.size(); ++j)
                    res.pop_back();
    }

    str = res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s, t;
    cin >> s >> t;

    removeString(s, t);

    cout << (s.size() > 0 ? s : "FRULA") << "\n";
    return 0;
}
