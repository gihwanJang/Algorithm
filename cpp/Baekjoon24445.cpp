#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> graph[100001];
int visited[100001] = { 0, };
int result[100001];
int cnt = 0;

void bfs(int r) {
	queue<int> q;
	q.push(r);
	visited[r] = 1;
	cnt++;
	result[r] = cnt;
	while (!q.empty()) {
		int inq = q.front();
		q.pop();
		for (int i = 0; i < graph[inq].size(); ++i) {
			int temp = graph[inq][i];
			if (!visited[temp]) {
				cnt++;
				result[temp] = cnt;
				q.push(temp);
				visited[temp] = 1;
			}
		}
	}
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, r;
    cin >> n >> m >> r;

    for (int i = 1; i <= m; ++i) {
		int a, b;
		cin >> a >> b;
		graph[a].push_back(b);
		graph[b].push_back(a);
	}

	for (int i = 1; i <= n; ++i)
		sort(graph[i].rbegin(), graph[i].rend());
	
    bfs(r);

    for(int i = 1; i <=n; ++i)
        cout << result[i] << "\n";
    return 0;
}
