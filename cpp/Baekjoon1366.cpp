#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

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

bool cmp(int a, int b){
    return b < a;
}

int checkAllCase(vector<int>&scales,vector<int>&location,vector<int>&code,int depth){
    if(depth == scales.size()){
        unordered_set<int> set(15);
        vector<int> difficulty(depth);

        for(int i = 0; i < depth; ++i){
            set.insert(location[i]);
            difficulty[i] = scales[i] > location[i] ? 12 - scales[i] + location[i] : location[i] - scales[i];
        }
        
        if(set.size() != code.size()) return 100;

        sort(difficulty.begin(), difficulty.end(), cmp);

        if(difficulty[0]){
            while(difficulty[difficulty.size() - 1] == 0)
                difficulty.pop_back();
            return difficulty[0] - difficulty[difficulty.size() - 1] + 1;
        }
        return 0;
    }

    int res = 100;
    for(int i = 0; i < code.size(); ++i){
        location[depth] = code[i];
        res = min(checkAllCase(scales, location, code, depth+1),res);
    }

    return res;
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
    vector<int> location(n);
    vector<int> code(m);
    for(int i = 0; i < n; ++i){
        cin >> s;
        scales[i] = map.at(s);
    }
    for(int i = 0; i < m; ++i){
        cin >> s;
        code[i] = map.at(s);
    }

    cout << checkAllCase(scales, location, code, 0) << "\n";
    
    return 0;
}