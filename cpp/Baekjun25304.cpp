#include<cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int total, n, cost, count, sum = 0;

    scanf("%d %d", &total, &n);
    for(; n > 0; --n){
        scanf("%d %d", &cost, &count);
        sum += cost * count;
    }

    printf("%s\n", total - sum ? "No" : "Yes");
    return 0;
}
