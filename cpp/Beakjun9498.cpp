#include<stdio.h>
char grade(int score){
    if(score>89)return 'A';
    if(score>79)return 'B';
    if(score>69)return 'C';
    if(score>59)return 'D';
    else return'F';
}
int main(int argc, char const *argv[]){
    int score;
    scanf("%d",&score);
    printf("%c",grade(score));
    return 0;
}
