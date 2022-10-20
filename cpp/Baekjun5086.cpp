#include<iostream>


int main(int argc, char const *argv[]){
    int l, r;
    while (true){
        scanf("%d %d", &l, &r);
        if(l==0 && r==0) break;

        if(r%l == 0) printf("factor\n");
        else if(l%r == 0) printf("multiple\n");
        else printf("neither\n");
    }
        
    return 0;
}
