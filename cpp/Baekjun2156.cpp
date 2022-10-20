#include<iostream>

int Max(int a, int b, int c) {
	if (b > c) {
		if (a > b) return a;
		else return b;
	}
	else {
		if (a > c) return a;
		else return c;
	}
}

int main(int argc, char const *argv[]){
    int n, nums[10001], table[10001];
    scanf("%d", &n);

    for(int i = 1; i <= n; ++i)
        scanf("%d", &nums[i]);

    table[1] = nums[1];
    table[2] = nums[1] + nums[2];
    
    for(int i = 3; i <= n; ++i)
        table[i] = Max(table[i - 3] + nums[i - 1] + nums[i], table[i - 1], table[i - 2] + nums[i]);
    
    printf("%d\n", table[n]);
    return 0;
}
