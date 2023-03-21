#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int ans = 987654321;
unordered_set<int> set;

unordered_map<string,int> makeMap(){
    unordered_map<string,int> map;
    map.insert({"A",1});
    map.insert({"A#",2});
    map.insert({"B",3});
    map.insert({"C",4});
    map.insert({"C#",5});
    map.insert({"D",6});
    map.insert({"D#",7});
    map.insert({"E",8});
    map.insert({"F",9});
    map.insert({"F#",10});
    map.insert({"G",11});
    map.insert({"G#",12});
    return map;
}

void play(vector<int>&scales, vector<int>&code, vector<pair<int,int>>&difficulty, int depth){
    if(depth == scales.size()){
        int l = 987654321, r = 0;
        for(int i = 0; i < scales.size(); ++i){
            set.insert(difficulty[i].first);

            if(difficulty[i].second != 0){
                r = max(r, difficulty[i].second);
                l = min(l, difficulty[i].second);
            }
        }

        if(set.size() == code.size()){
            if(l == 987654321)
                ans = 0;
            else if(r - l + 1 < ans)
                ans = r - l + 1;
        }

        set.clear();
        return;
    }
    
    for(int i = 0; i < code.size(); ++i){
        difficulty[depth].first = code[i];
        difficulty[depth].second = code[i] - scales[depth] + (code[i] >= scales[depth] ? 0 : 12);
        play(scales, code, difficulty, depth + 1);
        difficulty[depth].second += 12;
        play(scales, code, difficulty, depth + 1);
    }    
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    int n, m;
    cin >> n >> m;

    unordered_map<string,int> map = makeMap();
    vector<int> scales(n);
    vector<int> code(m);
    for(int i = 0; i < n; ++i){
        cin >> s;
        scales[i] = map.at(s);
    }
    for(int i = 0; i < m; ++i){
        cin >> s;
        code[i] = map.at(s);
    }

    vector<pair<int,int>> difficulty(n);
    play(scales, code, difficulty, 0);

    cout << ans << "\n";
    return 0;
}