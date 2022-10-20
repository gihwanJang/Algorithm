#include <cstdio>
#include <queue>
using namespace std;

int main(int argc, char const *argv[]){
    int n, num;
    priority_queue<int> pq;

    scanf("%d", &n);
    while(n--){
        scanf("%d", &num);
        if(num == 0){
            if(pq.empty())
                printf("0\n");
            else{
                printf("%d\n", pq.top());
                pq.pop();
            }
        }
        else
            pq.push(num);
    }
    return 0;
}
