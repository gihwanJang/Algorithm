#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

double triangleArea(double x1, double x2, double x3, double y1, double y2, double y3){
	double res = x1 * y2 + x2 * y3 + x3 * y1;
	res -= y1 * x2 + y2 * x3 + y3 * x1;
	return res / 2;
}

double calculateArea(vector<pair<int,int>>&points){
    double res = 0;

    for (int i = 2; i < points.size(); ++i)
		res += triangleArea(points[0].first, points[i - 1].first, points[i].first, points[0].second, points[i - 1].second, points[i].second);

    return abs(res);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    cin >> n;

    vector<pair<int,int>> points(n);
    for(int i = 0; i < n; ++i)
        cin >> points[i].first >> points[i].second;
    
    cout << fixed;
    cout.precision(1);
    cout << calculateArea(points) << "\n";
    return 0;
}
