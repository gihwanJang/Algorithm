#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

struct Point{
    int x, y;
};

bool checkRect(vector<Point>&p){
    int idx = 0;
    vector<long long> s(6);
    for(int i = 0; i < 4; ++i)
        for(int j = i + 1; j < 4; ++j, ++idx)
            s[idx] = pow(p[i].x-p[j].x, 2) + pow(p[i].y-p[j].y, 2);
    sort(s.begin(),s.end());
    return (s[0] == s[1] && s[1] == s[2] && s[2] == s[3] && s[4] == s[5]);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while(T--){
        vector<Point> points(4);
        
        for(int i = 0; i < 4; ++i)
            cin >> points[i].x >> points[i].y;

        cout << checkRect(points) << "\n";
    }

    return 0;
}
