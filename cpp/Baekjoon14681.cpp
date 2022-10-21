#include<stdio.h>
int solution(int x, int y){
    if(x>0){
        if(y>0)return 1;
        return 4;
    }
    else{
        if(y>0)return 2;
        return 3; 
    }
}
int main(int argc, char const *argv[]){
    int x,y;
    scanf("%d\n%d",&x,&y);
    printf("%d",solution(x,y));
    return 0;
}
