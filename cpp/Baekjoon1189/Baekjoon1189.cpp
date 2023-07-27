#include <iostream>
#include <vector>

using namespace std;

struct Location
{
    int r, c;
    Location(int R, int C): r(R), c(C){}
};

bool canGo(vector<string>&road_map, vector<vector<bool>>&visited, int r, int c)
{
    if(0 > r || r >= road_map.size())
        return false;
    if(0 > c || c >= road_map[0].size())
        return false;
    if(visited[r][c])
        return false;
    if(road_map[r][c] == 'T')
        return false;
    return true;
}

int getNumberOfArrivalRoutes(vector<string>&road_map, vector<vector<bool>>&visited, int k, Location curr, int distance)
{
    if(curr.r == road_map.size()-1 && curr.c == road_map[0].size()-1)
        return distance == k;

    int count = 0;
    visited[curr.r][curr.c] = true;

    if (canGo(road_map, visited, curr.r + 1, curr.c))
        count += getNumberOfArrivalRoutes(road_map, visited, k, Location(curr.r + 1, curr.c), distance + 1);
    if (canGo(road_map, visited, curr.r - 1, curr.c))
       count += getNumberOfArrivalRoutes(road_map, visited, k, Location(curr.r - 1, curr.c), distance + 1);
    if (canGo(road_map, visited, curr.r, curr.c + 1))
        count += getNumberOfArrivalRoutes(road_map, visited, k, Location(curr.r, curr.c + 1), distance + 1);
    if (canGo(road_map, visited, curr.r, curr.c - 1))
        count += getNumberOfArrivalRoutes(road_map, visited, k, Location(curr.r, curr.c - 1), distance + 1);

    visited[curr.r][curr.c] = false;
    return count;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int R, C, K;
    cin >> R >> C >> K;

    vector<string> road_map(R);
    vector<vector<bool>> visited(R, vector<bool>(C));
    for(int i = R-1; i >= 0; --i)
        cin >> road_map[i];

    cout << getNumberOfArrivalRoutes(road_map, visited, K, Location(0,0) ,1) << "\n";
    return 0;
}
