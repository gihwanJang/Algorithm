#include<stdio.h>
int solution(int year){
    if(year%4==0){
        if(year%400!=0&&year%100==0)return 0;
        return 1;
    }
    return 0;
}
int main(int argc, char const *argv[]){
    int year;
    scanf("%d",&year);
    printf("%d",solution(year));
    return 0;
}
