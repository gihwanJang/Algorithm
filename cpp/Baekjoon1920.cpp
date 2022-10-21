#include <cstdio>
#include <unordered_set>
using namespace std;

int main(int argc, char const *argv[]){
    unordered_set<int> set(10000000);
    int n, num;
    
    scanf("%d", &n);
    while (n--){
        scanf("%d", &num);
        set.insert(num);
    }

    scanf("%d", &n);
    while (n--){
        scanf("%d", &num);
        printf("%lu\n", set.count(num));
    }    
    return 0;
}
