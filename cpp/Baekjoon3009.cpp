#include<iostream>
#include<unordered_map>
using namespace std;

int main(int argc, char const *argv[]){
    int x, y;
    unordered_map<int, int> xSet(8), ySet(8);
    for(int i = 0; i < 3; ++i){
        scanf("%d %d", &x, &y);
        if(xSet.count(x)) ++xSet.find(x)->second;
        else xSet.insert(make_pair(x, 1));
        if(ySet.count(y)) ++ySet.find(y)->second;
        else ySet.insert(make_pair(y, 1));
    }

    for(unordered_map<int, int>::iterator it = xSet.begin(); it != xSet.end(); ++it)
        if(it->second == 1) x = it->first;
    for(unordered_map<int, int>::iterator it = ySet.begin(); it != ySet.end(); ++it)
        if(it->second == 1) y = it->first;
    
    printf("%d %d\n", x, y);
    return 0;
}
