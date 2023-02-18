#include<cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int find[6], check[6] = {1, 1, 2, 2, 2, 8};

    for(int i = 0 ; i < 6; ++i)
        scanf("%d", &find[i]);
    
    for(int i = 0 ; i < 6; ++i)
        printf("%d ", check[i] - find[i]);
    printf("\n");
    return 0;
}
