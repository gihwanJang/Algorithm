#include<iostream>
#include<unordered_set>
using namespace std;

int main(int argc, char const *argv[]){
    int n, m, count=0;
    string s;
    scanf("%d %d", &n, &m);
    unordered_set<string> set(n*2);
    for(; n > 0; --n){
        cin >> s;
        set.insert(s);
    }

    for(; m > 0; --m){
        cin >> s;
        if(set.count(s))++count;
    }

    printf("%d\n", count);
    return 0;
}
