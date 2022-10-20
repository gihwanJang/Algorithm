#include<iostream>
#include<vector>
using namespace std;

vector<int> nums;

void solution(int n, int k, int s[]){
    if(nums.size() == 6){
        for(int i = 0; i < 6; ++i)
            printf("%d ",nums[i]);
        printf("\n");
        return;
    }

    nums.push_back(s[n]);
    if(n<k)solution(n+1, k, s);
    nums.pop_back();
    if(n<k)solution(n+1, k, s);
}

int main(){
    int k;

    while(true){
        scanf("%d", &k);
        if(k == 0) break;

        int s[k];
        for(int i = 0; i < k; ++i)
            scanf("%d", &s[i]);
        
        solution(0, k, s);
        printf("\n");
    }

    return 0;
}