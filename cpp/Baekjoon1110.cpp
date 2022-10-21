#include<stdio.h>

int solution(int n){
    int next_num=((n/10+n%10)%10)+((n%10)*10),cycle=1;
    while(n!=next_num){
        next_num=((next_num/10+next_num%10)%10)+((next_num%10)*10);
        ++cycle;
    }
    return cycle;
}
int main(int argc, char const *argv[]){
    int num;
    scanf("%d",&num);
    printf("%d",solution(num));
    return 0;
}
