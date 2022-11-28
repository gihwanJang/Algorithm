#include <iostream>
#include <vector>
#include <queue>
#define INF 987654321
using namespace std;
/*
int getSmallestNode(vector<int>&distance, vector<bool>&visited){
    int min = INF, idx = 0;

	for (int i = 0; i < distance.size(); ++i)
		if((distance[i] < min) && !visited[i]){
			min = distance[i];
			idx = i;
		}

	return idx;
}

void dijkstra(vector<vector<pair<int, int>>>&graph, vector<int>&distance, vector<bool>&visited, int start){
    distance[start] = 0;
    visited[start] = true;

    for (int j = 0; j < graph[start].size(); ++j)
		distance[graph[start][j].first] = graph[start][j].second;

    for (int i = 0; i < distance.size() - 2; ++i){
		int now = getSmallestNode(distance, visited);
		visited[now] = true;
		
		for (int j = 0; j < graph[now].size(); ++j){
			int cost = distance[now] + graph[now][j].second;

			if (cost < distance[graph[now][j].first])
			    distance[graph[now][j].first] = cost;
		}
	}
}
*/

struct compare{
	bool operator()(pair<int, int>a, pair<int, int>b){
		return a.first > b.first;
	}
};

void dijkstra(vector<vector<pair<int, int>>>&graph, vector<int>&distance, int start){
    priority_queue<pair<int, int>, vector<pair<int, int>>, compare> pq;
    pq.push({0, start});
    distance[start] = 0;

    while(!pq.empty()){
        int dist = pq.top().first;
        int curr = pq.top().second;
        pq.pop();

        if (dist > distance[curr]) continue;

        for (int i = 0; i < graph[curr].size(); ++i){
            int cost = dist + graph[curr][i].second;

            if (cost < distance[graph[curr][i].first]) {
                distance[graph[curr][i].first] = cost;
                pq.push(make_pair(cost, graph[curr][i].first));
            }
        }
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int V, E, start;
    cin >> V >> E >> start;

    vector<vector<pair<int, int>>> graph(V + 1);
    vector<int> distance(V + 1, INF);

    while(E--){
		int u, v, w;
		cin >> u >> v >> w;

		graph[u].push_back(make_pair(v, w));
	}

    dijkstra(graph, distance, start);

    for (int i = 1; i <= V; i++){
		if (distance[i] == INF)
			cout << "INF" << '\n';
		else
			cout << distance[i] << '\n';
	}
    return 0;
}
