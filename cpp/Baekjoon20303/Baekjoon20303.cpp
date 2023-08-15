#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Item
{
    int weight, value;
};

void DFS(vector<int>&candys, vector<bool>&visited, vector<vector<int>>&relation, vector<Item>&items, int start)
{
    int curr = start;
    int candy = 0;
    int friendCount = 0;
    vector<int> stack;

    stack.push_back(start);
    while(!stack.empty())
    {
        curr = stack.back();
        stack.pop_back();

        if(!visited[curr])
        {
            visited[curr] = true;

            candy += candys[curr];
            ++friendCount;

            for(int i = 0; i < relation[curr].size(); ++i)
                if(!visited[relation[curr][i]])
                    stack.push_back(relation[curr][i]);
        }
    }
    
    items.push_back({friendCount, candy});
}

vector<Item> changeRelationToItems(vector<int>&candys, vector<vector<int>>&relation)
{
    vector<Item> items;
    vector<bool> visited(candys.size());

    for(int i = 0; i < candys.size(); ++i)
        if(!visited[i])
            DFS(candys, visited, relation, items, i);

    return items;
}

int getMaximumCandy(vector<int>&candys, vector<vector<int>>&relation, int k)
{
    vector<Item> items = changeRelationToItems(candys, relation);
    vector<vector<int>> table(items.size()+1, vector<int>(k));

    for(int r = 1; r <= items.size(); ++r)
        for(int c = 1; c < k; ++c)
        {
            if(c - items[r-1].weight >= 0)
                table[r][c] = max(table[r-1][c], table[r - 1][c - items[r-1].weight] + items[r-1].value);
            else
                table[r][c] = table[r-1][c];
        }

    return table[items.size()][k-1];
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, k;
    cin >> n >> m >> k;

    vector<int> candys(n);
    for(int i = 0; i < n; ++i)
        cin >> candys[i];

    vector<vector<int>> relation(n);
    for(int i = 0; i < m; ++i)
    {
        int k1, k2;
        cin >> k1 >> k2;
        relation[k1-1].push_back(k2-1);
        relation[k2-1].push_back(k1-1);
    }

    cout << getMaximumCandy(candys, relation, k) << '\n';
    return 0;
}
