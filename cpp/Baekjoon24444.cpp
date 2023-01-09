#include<iostream>
#include<queue>
#include<deque>
#include<algorithm>

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
		for (int i = 0; i < graph[inq].size(); i++) {
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

int main() {
	int n, m, r;
	scanf("%d %d %d", &n, &m, &r);
	for (int i = 1; i <= m; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		graph[a].push_back(b);
		graph[b].push_back(a);
	}
	for (int i = 1; i <= n; i++) {
		sort(graph[i].begin(), graph[i].end());
	}
	bfs(r);
	for (int i = 1; i <= n; i++) {
		printf("%d\n", result[i]);
	}

}