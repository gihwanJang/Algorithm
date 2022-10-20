#include<iostream>
#include<vector>
using namespace std;

int MIN = 1000000000, MAX = -1000000000;

int operation(int a, int b, int opcode){
    if(opcode == 0) return a+b;
    else if(opcode == 1) return a-b;
    else if(opcode == 2) return a*b;
    else return a/b;
}

void rec(const vector<int>&nums, vector<int>&op, int index, int val){
    if(index == nums.size()){
        if(MIN > val) MIN = val;
        if(MAX < val) MAX = val;
        return;
    }

    for(int i = 0; i < 4; ++i)
        if(op[i] !=0){
            --op[i];
            rec(nums, op, index+1, operation(val, nums[index], i));
            ++op[i];
        }
}

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);
    vector<int> nums(n);
    vector<int> op(4);
    for(int i = 0; i < n; ++i)
        scanf("%d", &nums[i]);
    for(int i = 0; i < 4; ++i)
        scanf("%d", &op[i]);

    rec(nums, op, 1, nums[0]);
    
    printf("%d\n%d", MAX, MIN);
    return 0;
}
