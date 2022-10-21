#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int sum = 0, num;
    
    for(int i = 0; i < 5; ++i){
        scanf("%d", &num);
        sum += num * num;
    }

    printf("%d\n", sum %10);
    return 0;
}
