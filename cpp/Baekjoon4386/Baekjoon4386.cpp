#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

struct Point{double x, y;};

struct Edge{
    double distance; 
    int from, to;

    Edge(double d, int f, int t) {
        distance = d;
        from = f;
        to = t;
    }

    bool operator<(const Edge &e) const {
		return distance < e.distance;
	}
};

double getDistance(Point a, Point b){
    double dx = b.x - a.x;
    double dy = b.y - a.y;
    return sqrt(dx * dx + dy * dy);
}

int findNode(vector<int>&union_table, const int&node) {
    if(union_table[node] == node) return node;
    return union_table[node] = findNode(union_table, union_table[node]);
}

bool unionNode(vector<int>&union_table, const int&from, const int&to) {
    int fromParent = findNode(union_table, from);
    int toParent = findNode(union_table, to);

    if(fromParent == toParent) return false;

    union_table[fromParent] = toParent;

    return true;
}

double getMinimumCost(vector<Point>&stars, const int&n) {
    double distance_sum = 0;
    vector<int> union_table(n);
    vector<Edge> edges;

    for(int i = 0; i < n; ++i)
        union_table[i] = i;

    for(int i = 0; i < n; ++i)
        for(int j = i + 1; j < n; ++j)
            edges.push_back(Edge(getDistance(stars[i], stars[j]), i, j));

    sort(edges.begin(), edges.end());

    for(int i = 0; i < edges.size(); ++i)
        if(unionNode(union_table, edges[i].from, edges[i].to))
            distance_sum += edges[i].distance;

    return distance_sum;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cout << fixed;
    cout.precision(2);

    int n;
    cin >> n;

    vector<Point> stars(n);
    for(int i = 0; i < n; ++i)
        cin >> stars[i].x >> stars[i].y;

    cout << getMinimumCost(stars, n) << "\n";
    return 0;
}