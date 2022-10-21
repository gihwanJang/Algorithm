#include <cstdio>
using namespace std;

int n, white = 0, blue = 0;
bool matrix[128][128];

void solution(int r, int c, int size){
    bool b = matrix[r][c], result = true;

    for(int row = r; row < size + r && result; ++row)
        for(int col = c; col < size + c; ++col)
            if(b != matrix[row][col]){
                solution(r, c, size / 2);
                solution(r + size / 2, c, size / 2);
                solution(r, c + size / 2, size / 2);
                solution(r + size / 2, c + size / 2, size / 2);
                result = false;
                break;
            }

    if(result) b ? ++blue : ++white;
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
    printf("%d\n%d\n", white, blue);
    return;
}

int main(int argc, char const *argv[]){
    input();
    solution(0, 0, n);
    output();
    return 0;
}
