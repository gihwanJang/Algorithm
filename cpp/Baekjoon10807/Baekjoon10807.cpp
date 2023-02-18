#include <iostream>
#include <utility>
#include <unordered_map>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, V, num;
    cin >> N;

    unordered_map<int,int> map;
    while(N--){
        cin >> num;
        if(!map.count(num))
            map.insert(make_pair(num,1));
        else
            ++map.find(num)->second;
    }

    cin >> V;
    cout << (map.count(V) ? map.find(V)->second : 0) << "\n";

    return 0;
}
