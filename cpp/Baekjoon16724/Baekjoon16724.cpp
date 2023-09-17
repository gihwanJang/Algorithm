#include <iostream>
#include <vector>

using namespace std;

int findNode(vector<int>&table, const int&node) {
    if(table[node] == node) return node;
    return table[node] = findNode(table, table[node]);
}

void unionNode(vector<int>&table, const int&from, const int&to) {
    int fromParent = findNode(table, from);
    int toParent = findNode(table, to);

    table[fromParent] = toParent;
}

void move(vector<pair<int,int>>&stack, vector<int>&table, int r, int c, int m, char d) {
    if (d == 'U'){
        unionNode(table, r * m + c, (r - 1) * m + c);
        stack.push_back({r - 1, c});
    }
    if (d == 'D'){
        unionNode(table, r * m + c, (r + 1) * m + c);
        stack.push_back({r + 1, c});
    }
    if (d == 'L'){
        unionNode(table, r * m + c, r * m + c - 1);
        stack.push_back({r, c - 1});
    }
    if (d == 'R'){
        unionNode(table, r * m + c, r * m + c + 1);
        stack.push_back({r, c + 1});
    }
}

int getMinimumGroup(vector<string>&map, int n, int m) {
    int groupCount = 0;
    pair<int, int> curr;
    vector<pair<int,int>> stack;
    vector<int> table(n * m);
    vector<vector<bool>> visited(n, vector<bool>(m));

    for(int i = 0; i < n*m; ++i)
        table[i] = i;

    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c)
            if(!visited[r][c]) {
                stack.push_back({r, c});

                 while(!stack.empty()) {
                    curr = stack.back();
                    stack.pop_back();

                    if(!visited[r][c]){
                        visited[r][c] = true;
                        move(stack, table, r, c, m, map[r][c]);
                    }
                 }
            }

    for(int i = 0; i < n*m; ++i)
        if(table[i] == i)
            ++groupCount;

    return groupCount;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<string> map(n);
    for(int i = 0; i < n; ++i)
        cin >> map[i];

    cout << getMinimumGroup(map, n, m) << "\n";
    return 0;
}
