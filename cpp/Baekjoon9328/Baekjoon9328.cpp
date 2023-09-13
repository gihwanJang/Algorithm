#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Loc{int r, c;};

void makeQue(queue<Loc>&que, vector<vector<Loc>>&door, vector<bool>&key_table, Loc loc, char&state)
{
    if(state == '*') return;

    if('a' <= state && state <= 'z')
        key_table[state - 'a'] = true;
    else if('A' <= state && state <= 'Z')
        if(!key_table[state - 'A'])
        {
            door[state - 'A'].push_back(loc);
            return;
        }
    
    que.push(loc);
}

int getDocument(vector<string>&floor_plan, vector<bool>&key_table, int h, int w)
{
    int document_cnt = 0;

    Loc curr;
    queue<Loc> que;
    vector<vector<Loc>> door(26);
    vector<vector<bool>> visited(h, vector<bool>(w));

    for(int r = 0; r < h; ++r)
    {
        makeQue(que, door, key_table, {r, 0}, floor_plan[r][0]);
        makeQue(que, door, key_table, {r, w-1}, floor_plan[r][w-1]);
    }
    for(int c = 0; c < w; ++c)
    {
        makeQue(que, door, key_table, {0, c}, floor_plan[0][c]);
        makeQue(que, door, key_table, {h-1, c}, floor_plan[h-1][c]);
    }

    while(true)
    {
        bool canStop = true;

        while(!que.empty())
        {
            curr = que.front();
            que.pop();

            if(!visited[curr.r][curr.c])
            {
                visited[curr.r][curr.c] = true;

                if(floor_plan[curr.r][curr.c] == '$') ++document_cnt;

                if(curr.r > 0 && !visited[curr.r-1][curr.c])
                    makeQue(que, door, key_table, {curr.r-1, curr.c}, floor_plan[curr.r-1][curr.c]);
                if(curr.r+1 < h && !visited[curr.r+1][curr.c])
                    makeQue(que, door, key_table, {curr.r+1, curr.c}, floor_plan[curr.r+1][curr.c]);
                if(curr.c > 0 && !visited[curr.r][curr.c-1])
                    makeQue(que, door, key_table, {curr.r, curr.c-1}, floor_plan[curr.r][curr.c-1]);
                if(curr.c+1 < w && !visited[curr.r][curr.c+1])
                    makeQue(que, door, key_table, {curr.r, curr.c+1}, floor_plan[curr.r][curr.c+1]);
            }
        }

        for(int i = 0; i < 26; ++i)
            if(key_table[i])
                while(!door[i].empty())
                {
                    que.push(door[i].back());
                    door[i].pop_back();
                    canStop = false;
                }

        if(canStop) break;
    }

    return document_cnt;
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
        int h, w;
        cin >> h >> w;

        vector<string> floor_plan(h);
        for(int r = 0; r < h; ++r)
            cin >> floor_plan[r];

        string keys;
        cin >> keys;
        vector<bool> key_table(26);
        for(int i = 0; i < keys.size(); ++i)
            if(keys[i] != '0')
                key_table[keys[i] - 'a'] = true;

        cout << getDocument(floor_plan, key_table, h, w) << "\n";
    }
    return 0;
}