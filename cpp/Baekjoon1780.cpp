#include <cstdio>
using namespace std;

int n, matrix[2187][2187], check[3] = {0,};

void solution(int r, int c, int size){
    int val = matrix[r][c];
    bool flag = true;

    for(int row = r; row < r + size && flag; ++row)
        for(int col = c; col < c + size; ++col)
            if(val != matrix[row][col]){
                for(int i = 0; i < 3; ++i)
                    for(int j = 0; j < 3; ++j)
                        solution(r + size / 3 * i, c + size / 3 * j, size / 3);
                flag = false;
                break;
            }

    if(flag) val == -1 ? ++check[2] : ++check[val];
    return;
}

void input(){
    scanf("%d", &n);
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < n; ++c)
            scanf("%d", &matrix[r][c]);
    return;
}

void output(){
    printf("%d\n%d\n%d\n", check[2], check[0], check[1]);
    return;
}

int main(int argc, char const *argv[]){
    input();
    solution(0, 0, n);
    output();
    return 0;
}
