#include <iostream>
#include <utility>
#include <vector>
#include <unordered_map>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, c;
    pair<int, int> ans = make_pair(0,0);
    cin >> N;

    vector<vector<bool>> mate(N,vector<bool>(N));
    vector<vector<int>> table(N, vector<int> (5));
    for(int r = 0; r < N; ++r)
        for(int c = 0; c < 5; ++c)
            cin >> table[r][c];

    for(int c = 0; c < 5; ++c){
        unordered_map<int, vector<int>> class_mate(13);
        for(int r = 0; r < N; ++r){
            if(!class_mate.count(table[r][c])){
                vector<int> students;
                students.push_back(r);
                class_mate.insert({table[r][c], students});
            }
            else
                class_mate.find(table[r][c])->second.push_back(r);
        }
        for(pair<int, vector<int>> p : class_mate){
            for(int i = 0; i < p.second.size(); ++i)
                for(int j = 0; j < p.second.size(); ++j)
                    mate[p.second[i]][p.second[j]] = true;
        }
    }

    for(int r = 0; r < N; ++r){
        int count = 0;
        for(int c = 0; c < N; ++c)
            if(mate[r][c])
                ++count;
        if(count > ans.second)
            ans = make_pair(r, count);
    }

    cout << ans.first + 1 << "\n";
    return 0;
}
