#include<cstdio>
#include<vector>
using namespace std;

int main(int argc, char const *argv[]){
    int n, nums[100001];
    vector<int> stack;
    vector<char> ans;

    scanf("%d", &n);
    for(int i = 0; i < n; ++i)
        scanf("%d", &nums[i]);

    for(int i = 0, j = 1; j <=n; ++j){
        stack.push_back(j);
        ans.push_back('+');
        while(stack.size() != 0 && stack.back() == nums[i]){
            ans.push_back('-');
            stack.pop_back();
            ++i;
        }
    }

    if(stack.size() != 0)
        printf("NO\n");
    else
        for(vector<char>::iterator it = ans.begin(); it != ans.end(); ++it)
            printf("%c\n", *it);
    return 0;
}
