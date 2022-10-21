#include<stdio.h>

int main(int argc, char const *argv[]){
    int num1,num2;
    scanf("%d\n%d",&num1,&num2);

    printf("%d\n",num1*(num2%10));
    printf("%d\n",num1*(num2%100/10));
    printf("%d\n",num1*(num2/100));
    printf("%d\n",num1*num2);
    return 0;
}
