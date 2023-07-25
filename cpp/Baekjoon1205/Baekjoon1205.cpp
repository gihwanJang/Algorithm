#include <functional>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int getRanking(priority_queue<int, vector<int>, greater<int>>&pq, int p, int score)
{
    if(pq.size() < p || pq.empty())
    {
        pq.push(score);
    }
    else
    {
        if(pq.top() < score)
        {
            pq.pop();
            pq.push(score);
        }
        else
            return -1;
    }

    while(score >= pq.top() && !pq.empty())
        pq.pop();

    return pq.size() + 1;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, score, p, s;
    cin >> n >> score >> p;

    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i = 0; i < n; ++i)
    {
        cin >> s;

        if(pq.size() < p)
            pq.push(s);
        else
            if(pq.top() < s)
            {
                pq.pop();
                pq.push(s);
            }
    }

    cout << getRanking(pq, p, score) << "\n";
    return 0;
}