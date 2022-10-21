#include<cstdio>
#include<vector>
using namespace std;

int main(int argc, char const *argv[]){
    int n, num, sum = 0;
    vector<int> stack;

    scanf("%d", &n);
    for(; n > 0; --n){
        scanf("%d", &num);
        if(num != 0){
            stack.push_back(num);
            sum += stack.back();
        }
        else{
            sum -= stack.back();
            stack.pop_back();
        }
    }

    printf("%d\n", sum);
    return 0;
}
