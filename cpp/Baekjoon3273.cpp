#include <cstdio>
#include <algorithm>
using namespace std;

int n, x, nums[100000], ans = 0;

void solve(){
    sort(nums, nums + n);

    int l = 0, r = n-1;

	while(1) {
		if (l >= r) 
			break;
		int sum = nums[l] + nums[r];
		if (sum == x) {
			++ans;
			++l;
			--r;
		}
		else if (sum < x)
			++l;
		else
			--r;
	}
}

int main(int argc, char const *argv[]){
    scanf("%d", &n);
    for(int i = 0; i < n; ++i) scanf("%d", &nums[i]);
    scanf("%d", &x);

    solve();

    printf("%d\n", ans);
    return 0;
}
