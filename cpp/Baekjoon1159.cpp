#include <iostream>
#include <map>

using namespace std;

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    string name, ans = "";
    map<char, int> player_map;
    while(N--){
        cin >> name;
        if(player_map.count(name[0]))
            ++player_map.find(name[0])->second;
        else
            player_map.insert({name[0],1});
    }

    for(pair<char, int> p : player_map)
        if(p.second > 4)
            ans += p.first;
    
    cout << (ans == "" ? "PREDAJA" : ans) << "\n";
    return 0;
}
