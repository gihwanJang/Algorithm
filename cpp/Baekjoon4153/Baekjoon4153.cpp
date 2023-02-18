#include<iostream>
#include<math.h>

bool check(int a, int b, int c){
    if(a > b && a>c){
        if(b*b + c*c == a*a) return true;
        return false;
    }
    else if(b > a && b>c){
        if(a*a + c*c == b*b) return true;
        return false;
    }
    else{
        if(a*a + b*b == c*c) return true;
        return false;
    }
}

int main(int argc, char const *argv[]){
    int a = -1, b, c;

    while(true){
        scanf("%d %d %d", &a, &b, &c);
        if(a==0) break;
    
        if(check(a, b, c))
            printf("right\n");
        else
            printf("wrong\n");
    }
    return 0;
}
