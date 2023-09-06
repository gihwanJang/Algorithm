#include <iostream>
#include <queue>

using namespace std;

int getMinimumCmp(priority_queue<int, vector<int>, greater<int>>&pq, int n)
{
    int cnt = 0;

    for(int f, s; 1 < pq.size(); cnt += f + s)
    {
        f = pq.top();
        pq.pop();

        s = pq.top();
        pq.pop();

        pq.push(f + s);
    }

    return cnt;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    int card;
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i = 0; i < n; ++i)
    {
        cin >> card;
        pq.push(card);
    }

    cout << getMinimumCmp(pq, n) << "\n";
    return 0;
}
