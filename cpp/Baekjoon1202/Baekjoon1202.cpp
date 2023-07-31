#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Gem
{
    int weight, value;
};

bool cmp(Gem a, Gem b)
{
    return a.weight < b.weight;
}

long getMaxValue(vector<Gem>&gems, vector<int>&bags)
{   
    sort(gems.begin(), gems.end(), cmp);
    sort(bags.begin(), bags.end());

    int idx = 0;
    long value = 0;
    priority_queue<int> pq;

    for(int i = 0; i < bags.size(); ++i)
    {
        while(idx < gems.size() && gems[idx].weight <= bags[i])
            pq.push(gems[idx++].value);

        if(!pq.empty())
        {
            value += pq.top();
            pq.pop();
        }
    }

    return value;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    cin >> n >> k;

    vector<Gem> gems(n);
    for (int i = 0; i < n; ++i)
        cin >> gems[i].weight >> gems[i].value;

    vector<int> bags(k);
    for (int i = 0; i < k; ++i)
        cin >> bags[i];

    cout << getMaxValue(gems, bags) << "\n";
    return 0;
}
