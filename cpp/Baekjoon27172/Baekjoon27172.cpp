#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct PlayerTable
{
    int idx, card, score;
};

bool cmpWithCard(PlayerTable p1, PlayerTable p2)
{
    return p1.card < p2.card;
}

bool cmpWithIdx(PlayerTable p1, PlayerTable p2)
{
    return p1.idx < p2.idx;
}


void getPlayerScore(vector<PlayerTable>&players, int n)
{
    vector<int> table(1000001);

    sort(players.begin(), players.end(), cmpWithCard);

    for(int i = 0; i < n; ++i)
        table[players[i].card] = i;

    for(int i = 0; i < n; ++i)
        for(int j = 2; j * players[i].card <= players[n - 1].card; ++j)
            if(table[j * players[i].card])
            {
                ++players[i].score;
                --players[table[j * players[i].card]].score;
            }

    sort(players.begin(), players.end(), cmpWithIdx);
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<PlayerTable> players(n);
    for(int i = 0; i < n; ++i)
    {
        players[i].idx = i;
        cin >> players[i].card;
        players[i].score = 0;
    }

    getPlayerScore(players, n);

    for(int i = 0; i < n; ++i)
        cout << players[i].score << " ";
    cout << "\n";
    return 0;
}
