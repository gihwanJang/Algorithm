#include<iostream>
#include<stdlib.h>
using namespace std;

int**img;

bool check(int size, int r, int c){
    bool flag = true;
    for(int i = r; i < r+size; ++i)
        for (int j = c; j < c+size; ++j)
            if(img[r][c] != img[i][j]){
                flag = false;
                break;
            }
    return flag;
}

void solution(int size, int r, int c){
    if(size == 1 || check(size, r, c)){
        printf("%d", img[r][c]);
        return;
    }
    printf("(");
    solution(size/2, r, c);
    solution(size/2, r, c + size/2);
    solution(size/2, r + size/2, c);
    solution(size/2, r + size/2, c + size/2);
    printf(")");
}

int main(){
    int N;
    scanf("%d", &N);
    img = new int*[N];
    for(int r = 0; r < N; ++r){
        string s;
        img[r] = new int[N];
        cin>>s;
        for(int c = 0; c < N; ++c)
            img[r][c] = s[c]-'0';
    }

    solution(N, 0, 0);
    printf("\n");
    return 0;
}