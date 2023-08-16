#include <iostream>
#include <vector>

using namespace std;

void DFS(vector<int>&wishes, vector<bool>&check, vector<bool>&visited, int curr, int&cnt)
{
    int next = wishes[curr];

    visited[curr] = true;

    if(!visited[next])
        DFS(wishes, check, visited, next, cnt);
    else if(!check[next])
    {
        for(int i = next; i != curr; i = wishes[i])
            --cnt;
        --cnt;
    }

    check[curr] = true;
}

int getNumberOfStudentsLeft(vector<int>&wishes, int n)
{
    int cnt = n;
    vector<bool> check(n);
    vector<bool> visited(n);

    for(int i = 0; i < n; ++i)
        if(!visited[i])
            DFS(wishes, check, visited, i, cnt);

    return cnt;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while(T--)
    {
        int n;
        cin >> n;

        vector<int> wishes(n);
        for(int i = 0; i < n; ++i)
        {
            cin >> wishes[i];
            --wishes[i];
        }

        cout << getNumberOfStudentsLeft(wishes, n) << '\n';
    }
    return 0;
}
