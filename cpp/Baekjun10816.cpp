#include<iostream>
#include<unordered_map>
using namespace std;

int main(int argc, char const *argv[]){
    int n, m, num;
    scanf("%d", &n);
    unordered_map<int, int> map(n*2);
    for(; n>0; --n){
        scanf("%d", &num);
        if(map.count(num))
            ++(map.find(num)->second);
        else
            map.insert(make_pair(num, 1));
    }

    scanf("%d", &m);
    int nums[m];
    for(int i = 0; i < m; ++i)
        scanf("%d", &nums[i]);
    
    for(int i = 0; i < m; ++i){
        if(map.count(nums[i]))
            printf("%d ", map.find(nums[i])->second);
        else
            printf("0 ");
    }

    printf("\n");
    return 0;
}
