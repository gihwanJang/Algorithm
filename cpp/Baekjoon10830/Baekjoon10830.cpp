#include<cstdio>
using namespace std;

long n, b, matrix[5][5], tmp[5][5], ans[5][5];

void Matrix_multi(long X[5][5], long Y[5][5]){
	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j){
			tmp[i][j] = 0;
			for (int k = 0; k < n; ++k)
				tmp[i][j] += (X[i][k] * Y[k][j]);
			tmp[i][j] %= 1000;
		}

	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j)
			X[i][j] = tmp[i][j];
}

void input(){
    scanf("%ld %ld", &n, &b);
    for(int r = 0; r < n; ++r){
        for(int c = 0; c < n; ++c)
            scanf("%ld", &matrix[r][c]);
        ans[r][r] = 1;
    }
}

void output(){
    for(int r = 0; r < n; ++r){
        for(int c = 0; c < n; ++c)
            printf("%ld ", ans[r][c]);
        printf("\n");
    }
}

int main(int argc, char const *argv[]){
    input();

    while (b > 0){
		if (b % 2 == 1)
			Matrix_multi(ans, matrix);
		Matrix_multi(matrix, matrix);
		b /= 2;
	}

    output();
    return 0;
}
