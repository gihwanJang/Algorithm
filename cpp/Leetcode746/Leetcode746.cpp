#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        if(cost.size()<2)return cost[cost.size()-1];

        int table[cost.size()];
        table[0] = cost[0];
        table[1] = cost[1];

        for(int i = 2; i < cost.size(); ++i)
            table[i] = min(table[i-2] + cost[i], table[i-1] + cost[i]);
        
        return min(table[cost.size()-2], table[cost.size()-1]);
    }
};

int main(int argc, char const *argv[]){
    vector<int> cost = {1,2,3};
    
    Solution s;
    cout<<s.minCostClimbingStairs(cost);
    return 0;
}
