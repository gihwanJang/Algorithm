#include <cstdio>
#include <list>
using namespace std;

int main(int argc, char const *argv[]){
    list<int> queue;
    int n, k;

    scanf("%d %d", &n, &k);
    for(; n > 0; --n)
        queue.push_front(n);
    
    printf("<");
    while(!queue.empty()){
        for(int i = 1; i < k; ++i){
            queue.push_back(queue.front());
            queue.pop_front();
        }
        printf("%d", queue.front());
        queue.pop_front();
        if(!queue.empty()) printf(", ");
    }
    printf(">\n");
    return 0;
}
