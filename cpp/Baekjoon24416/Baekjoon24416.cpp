#include<iostream>

int n, rec = 0, roop = 0;

int fibo1(int k){
    if(k == 1 || k == 2) return 1;
    ++rec;
    return fibo1(k-1) + fibo1(k-2);
}

int fibo2(int k){
    int fi[k];
    fi[0] = fi[1] = 1;
    for(int i = 2; i < k; ++i, ++roop)
        fi[i] = fi[i-1] + fi[i-2];
    return fi[k-1];
}

int main(int argc, char const *argv[]){
    scanf("%d", &n);

    fibo1(n);
    fibo2(n);

    printf("%d %d\n", rec+1, roop);
    return 0;
}
