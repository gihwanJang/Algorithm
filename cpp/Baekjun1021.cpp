#include <cstdio>
#include <deque>
using namespace std;

int main(int argc, char const *argv[]){
    int n, m, num, left, right, count = 0;
    deque<int> dq;

    scanf("%d %d", &n, &m);

    for(int i=1; i<=n; ++i)
		dq.push_back(i);

    while(m--){
        scanf("%d", &num);

        for(int i=0; i<dq.size(); ++i)
			if(dq[i] == num){
				left = i;
				right = dq.size()-i;
				break;
			}
        
		if(left<=right){
			for(; dq.front()!=num; ++count){
				dq.push_back(dq.front());
				dq.pop_front();
			}
			dq.pop_front();
		}
		else{
			for(++count; dq.back()!=num; ++count){
				dq.push_front(dq.back());
				dq.pop_back();
			}
			dq.pop_back();
		}
    }

    printf("%d\n", count);
    return 0;
}
