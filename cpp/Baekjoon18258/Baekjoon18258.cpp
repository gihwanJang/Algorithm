#include<cstdio>
#include<cstring>
#include<list>
using namespace std;

list<int> queue;

void operate(char *s){
    int n;
    if(!strcmp(s, "push")){
        scanf("%d", &n);
        queue.push_back(n);
    }
    else if(!strcmp(s, "pop")){
        printf("%d\n", (queue.empty() ?  -1 : queue.front()));
        if(!queue.empty())queue.pop_front();
    }
    else if(!strcmp(s, "size"))
        printf("%ld\n", queue.size());
    else if(!strcmp(s, "empty"))
        printf("%d\n", (queue.empty() ?  1 : 0));
    else if(!strcmp(s, "front"))
        printf("%d\n", (queue.empty() ?  -1 : queue.front()));
    else
        printf("%d\n", (queue.empty() ?  -1 : queue.back()));
}

int main(int argc, char const *argv[]){
    char s[6];
    int T;

    scanf("%d", &T);
    for(; T > 0; --T){
        scanf("%s", s);
        operate(s);
    }
    return 0;
}
