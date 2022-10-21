#include<cstdio>

int main(int argc, char const *argv[]){
    int n, m, x1, y1, x2, y2, nums[1025][1025];

    scanf("%d %d", &n, &m);
    for(int r = 1; r <= n; ++r)
        for(int c = 1; c <= n; ++c){
            scanf("%d", &nums[r][c]);
            nums[r][c] += nums[r - 1][c] + nums[r][c - 1] - nums[r - 1][c - 1];
        }

    for(; m > 0; --m){
        scanf("%d %d %d  %d", &x1, &y1, &x2, &y2);
        printf("%d\n", nums[x2][y2] + nums[x1 - 1][y1 - 1] - nums[x1 - 1][y2] - nums[x2][y1 - 1]);
    }
    return 0;
}
