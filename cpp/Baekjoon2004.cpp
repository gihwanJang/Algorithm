#include<iostream>

int count_two(int n){
    int count = 0;
    while(n >= 2){
        count += n/2;
        n /= 2;
    }
    return count;
}

int count_five(int n){
    int count = 0;
    while(n >= 5){
        count += n/5;
        n /= 5;
    }
    return count;
}

int main(int argc, char const *argv[]){
    int n, m, count[2];
    scanf("%d %d", &n, &m);

    count[0] = count_two(n) - count_two(n-m) - count_two(m);
    count[1] = count_five(n) - count_five(n-m) - count_five(m);
    
    printf("%d\n", count[0] > count[1] ? count[1] : count[0]);
    return 0;
}