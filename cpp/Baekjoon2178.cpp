#include <iostream>
#include <queue>
#include <utility>

using namespace std;

int N, M;
int check[101][101];
int visited[101][101];
char map[101][101];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

void BFS(int x, int y){
    visited[x][y] = 1;

    queue<pair<int, int>> que;
    que.push(make_pair(x, y));

    while(!que.empty()){
        int x = que.front().first;
		int y = que.front().second;
        que.pop();

        for(int i = 0; i < 4; ++i){
            int next_x = x + dx[i];
			int next_y = y + dy[i];

            if (0 <= next_x && next_x < N && 0 <= next_y && next_y < M)
                if(map[next_x][next_y] == '1' && visited[next_x][next_y] == 0){
                    check[next_x][next_y] = check[x][y] + 1;
					visited[next_x][next_y] = 1;
                    que.push(make_pair(next_x, next_y));
                }
        }
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    for(int i = 0; i < N; ++i)
        cin >> map[i];
    
    BFS(0,0);

    cout << check[N - 1][M - 1] + 1 << "\n";
    return 0;
}
