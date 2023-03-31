#include <iostream>
#include <unordered_map>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    string site, pw;
    unordered_map<string,string> map;
    while(n--){
        cin >> site >> pw;
        map.insert({site, pw});
    }

    while(m--){
        cin >> site;
        cout << map.at(site) << "\n";
    }
    return 0;
}
