#include<cstdio>
#include<queue>
#include<utility>
using namespace std;

int main(int argc, char const *argv[]){
    int T, n, m, num, count, max;

    scanf("%d", &T);
    while(T--){
        priority_queue<int> pq;
        queue< pair<int, int> > que;
        count = 0;
        scanf("%d %d", &n, &m);

        for (int i = 0, max = 0; i < n; ++i){
            scanf("%d", &num);
            que.push(make_pair(num, i));
            pq.push(num);
        }
        
        while(!pq.empty()){
            if(pq.top() != que.front().first){
                que.push(que.front());
                que.pop();
            }
            else{
                ++count;
                if(que.front().second == m)
                    break;
                pq.pop();
                que.pop();
            }
        }
        printf("%d\n", count);
    }
    return 0;
}
