#include <iostream>
#include <vector>

using namespace std;

int canInstall(int distance, vector<int>&house){
    int cnt = 1;
    int last = house[0];

    for(int i = 1; i < house.size(); ++i){
        int curr = house[i];
        if(curr - last >= distance) {
			++cnt;
			last = curr;
		}
    }

    return cnt;
}

int solution(int n, int c, vector<int>&house){
    sort(house.begin(), house.end());

    int lo = 1;
    int hi = house[n-1] - house[0] + 1;

    while(lo < hi){
        int mid = (lo + hi) / 2;

        if(canInstall(mid, house) < c)
            hi = mid;
        else
            lo = mid + 1;
    }

    return lo - 1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, c;
    cin >> n >> c;

    vector<int> house(n);
    for(int i = 0; i < n; ++i)
        cin >> house[i];

    cout << solution(n, c, house) << "\n";
    return 0;
}
