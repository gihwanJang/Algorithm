#include <cstdio>
#include <algorithm>
using namespace std;

int n, m, ans = 100000000;
bool visited[100001] = {false, };

bool valid(int k) {
	if (k < 0 || k > 100000)
		return false;
	return true;
}

void solution(int k, int curr){
    if(k == m){
        ans = min(ans, curr);
        return;
    }
    if (valid(k - 1)) 
        solution(k - 1, curr + 1);
    if(valid(k + 1))
        solution(k + 1, curr + 1);
    if(valid(2 * k))
        solution(2 * k, curr + 1);
}

int main(int argc, char const *argv[]){
    scanf("%d %d", &n, &m);
    solution(n,0);
    printf("%d\n", ans);
    return 0;
}
