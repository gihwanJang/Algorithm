#include<iostream>
#include<unordered_set>
using namespace std;

int main(int argc, char const *argv[]){
    int n, m, num;
    scanf("%d", &n);

    unordered_set<int> set(n*2);
    for(int i = 0; i < n; ++i){
        scanf("%d", &num);
        set.insert(num);
    }

    scanf("%d", &m);

    int nums[m];
    for(int i = 0; i < m; ++i)
        scanf("%d", &nums[i]);
    
    for(int i = 0; i < m; ++i)
        printf("%d ", set.count(nums[i]) ? 1 : 0);
    
    printf("\n");
    return 0;
}
