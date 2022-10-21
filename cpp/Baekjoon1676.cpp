#include<iostream>

int main(int argc, char const *argv[]){
    int n, count[2] = {0,};
    scanf("%d", &n);

    for(int i; n > 0; --n){
        i = n;
        while(i%2 == 0){
            i/=2;
            ++count[0];
        }
        while(i%5 == 0){
            i/=5;
            ++count[1];
        }
    }

    printf("%d\n", count[0] > count[1] ? count[1] : count[0]);
    return 0;
}
