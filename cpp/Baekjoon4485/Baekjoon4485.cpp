#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int n;
int DR[] = {-1,1,0,0};
int DC[] = {0,0,-1,1};
int map[125][125];
int cost[125][125];

struct compare {
    bool operator()(tuple<int,int,int>a, tuple<int,int,int>b){
		return get<0>(a) > get<0>(b);
	}
};

bool isValidate(int r, int c) {
    return (0 <= r && r < n &&
            0 <= c && c < n);
}

int getMinCost() {
    tuple<int,int,int> curr = make_tuple(map[0][0], 0, 0);
    priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, compare> pq;

    pq.push(curr);
    while (!pq.empty()) {
        curr = pq.top();
        pq.pop();

        for (int i = 0; i < 4; ++i) {
            int nextR = get<1>(curr) + DR[i];
            int nextC = get<2>(curr) + DC[i];

            if (isValidate(nextR, nextC) && get<0>(curr) + map[nextR][nextC] < cost[nextR][nextC]) {
                cost[nextR][nextC] = get<0>(curr) + map[nextR][nextC];
                pq.push(make_tuple(get<0>(curr) + map[nextR][nextC], nextR, nextC));
            }
        }
    }
    return cost[n-1][n-1];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int cnt = 0;

    while (true) {
        cin >> n;
        if (n == 0) {
            break;
        }

        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                cin >> map[r][c];
                cost[r][c] = 999999999;
            }
        }
        cout << "Problem " << ++cnt << ": " << getMinCost() << "\n";
    }
    return 0;
}
