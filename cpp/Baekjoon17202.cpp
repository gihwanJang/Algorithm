#include <iostream>
using namespace std;

int main(int argc, char const *argv[]){
    int a, b, nums[16];
    
    scanf("%d %d", &a, &b);
    for (int i = 14; i >= 0; i -= 2, a /= 10, b /= 10){
        nums[i] = a%10;
        nums[i + 1] = b%10;
    }

    for(int i = 15; i > 1; --i)
        for(int j = 0; j < i; ++j)
            nums[j] = (nums[j] + nums[j + 1]) % 10;
    
    printf("%d%d\n", nums[0], nums[1]);
    return 0;
}
