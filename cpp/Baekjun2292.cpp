#include<stdio.h>
#include<math.h>
// 식 k=3*n*(n-1)+1
int solution(int n){
    return ceil(sqrt((4*double(n)-1)/12)+0.5);
}

int main(int argc, char const *argv[]){
    int n;
    scanf("%d",&n);

    printf("%d\n",solution(n));
    return 0;
}
