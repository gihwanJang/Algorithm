#include<iostream>
#include<vector>
using namespace std;

int main(int argc, char const *argv[]){
    int n, nums[1000000], ans[1000000];
    vector<int> stack;
    
    scanf("%d", &n);
    for(int i = 0; i < n; ++i)
        scanf("%d", &nums[i]);
    
    for (int i = n - 1; i > -1; --i){
		while (!stack.empty() && stack.back() <= nums[i])
			stack.pop_back();
        ans[i] = stack.empty() ? -1 : stack.back();
		stack.push_back(nums[i]);
	}
    
    for(int i = 0; i < n; ++i)
        printf("%d ", ans[i]);
    printf("\n");
    return 0;
}
