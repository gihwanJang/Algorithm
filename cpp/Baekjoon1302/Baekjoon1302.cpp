#include <iostream>
#include <unordered_map>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_map<string, int> map;
    string title;
    int N;
    cin >> N;
    while(N--){
        cin >> title;
        if(map.count(title))
            ++map.find(title)->second;
        else
            map.insert({title, 1});
    }

    for(pair<string,int> v : map)
        if(map.find(title)->second <= v.second){
            if(map.find(title)->second == v.second){
                if(title > v.first)
                    title = v.first;
            }
            else
                title = v.first;
        }

    cout << title << "\n";
    return 0;
}