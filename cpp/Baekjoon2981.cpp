#include<iostream>
#include<vector>
#include<cmath>
#include<algorithm>
using namespace std;

vector<int> answer;

int GCD(int a, int b){
    if(b == 0) return a;
    else return GCD(b, a%b);
}

void solution(int n , int nums[]){
    int gcd = abs(nums[0] - nums[1]);
    for(int i = 2; i < n; ++i)
        gcd = GCD(gcd, abs(nums[i-1]-nums[i]));
    
    for(int i = 2; i <= sqrt(gcd); ++i)
        if(gcd%i == 0){
            answer.push_back(i);
            if(i != gcd/i)
                answer.push_back(gcd/i);
        }
    sort(answer.begin(),answer.end());
    answer.push_back(gcd);
}

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);
    int nums[n];
    for(int i = 0; i < n ; ++i)
        scanf("%d", &nums[i]);

    solution(n, nums);

    for(vector<int>::iterator it = answer.begin(); it != answer.end(); ++it)
        printf("%d ", *it);
    printf("\n");
    return 0;
}
