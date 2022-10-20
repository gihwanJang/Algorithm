#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int row_A, col_A, row_B, col_B, matrixA[100][100], matrixB[100][100], sum;

    scanf("%d %d", &row_A, &col_A);
    for(int r = 0; r < row_A; ++r)
        for(int c = 0; c < col_A; ++c)
            scanf("%d", &matrixA[r][c]);
    scanf("%d %d", &row_B, &col_B);
    for(int r = 0; r < row_B; ++r)
        for(int c = 0; c < col_B; ++c)
            scanf("%d", &matrixB[r][c]);

    for(int r = 0; r < row_A; ++r){
        for(int c_B = 0; c_B < col_B; ++c_B){
            sum = 0;
            for(int c_A = 0; c_A < col_A; ++c_A)
                sum += matrixA[r][c_A] * matrixB[c_A][c_B];
            printf("%d ", sum);
        }
        printf("\n");
    }

    return 0;
}
