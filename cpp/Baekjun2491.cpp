#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n, prev, curr, up = 1, down = 1, max = 1;

    scanf("%d", &n);
    scanf("%d", &prev);

    while(--n){
        scanf("%d", &curr);
        if(prev > curr){
            ++up;
            down = 1;
        }
        else if(prev < curr){
            ++down;
            up = 1;
        }
        else{
            ++up;
            ++down;
        }
        if(max < up) max = up;
        if(max < down) max = down;
        prev = curr;
    }

    printf("%d\n", max);
    return 0;
}
