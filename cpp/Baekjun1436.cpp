#include<iostream>

class Solution{
public:
    int findDestroyNum(int n){
        int count = 0, num = 666;
        for(; n != count; ++num){
            for(int i = num; i > 0; i/=10)
                if(i % 1000 == 666){
                    ++count;
                    break;
                }
        }

        return num-1;
    }
};

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);
    Solution s;

    printf("%d\n",s.findDestroyNum(n));
    return 0;
}

