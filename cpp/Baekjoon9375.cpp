#include<iostream>
#include<unordered_map>
using namespace std;

int main(int argc, char const *argv[]){
    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);

    int T, n;
    for(cin >> T; T > 0; --T){
        cin >> n;
        unordered_map<string, int> map(10000);
        string key, value;
        int answer = 1;
        for(int i = 0, j = 0; i < n; ++i){
            cin >> value >> key;
            if(map.count(key)){
                ++map.find(key)->second;
            }
            else{
                map.insert(make_pair(key, 1));
            }
        }

        for(unordered_map<string, int>::iterator it = map.begin(); it != map.end(); ++it)
            answer *= (it->second + 1);


        cout << answer-1 << "\n";
    }
    return 0;
}
