#include<iostream>
#include<unordered_set>
using namespace std;

int main(int argc, char const *argv[]){
    int n, m, num;
    scanf("%d %d", &n, &m);
    unordered_set<int> a(n*2),b(m*2);
    
    for(; n > 0; --n){
        scanf("%d", &num);
        a.insert(num);
    }

    for(; m > 0; --m){
        scanf("%d", &num);
        b.insert(num);
    }

    num = 0;

    for(int k : a)
        if(!b.count(k))
            ++num;

    for(int k : b)
        if(!a.count(k))
            ++num;

    printf("%d\n", num);

    return 0;
}
