#include <algorithm>
#include <iostream>
#include <climits>
#include <vector>
#include <queue>

using namespace std;

struct cmp {
    bool operator()(const pair<long, int>& a, const pair<long, int>& b) const {
        if(a.first == b.first)
            return a.second > b.second;
        else
            return a.first > b.first;
    }
};

void getNums(priority_queue<pair<long,int>, vector<pair<long,int>>, cmp>&pq, vector<int>&s, int n) {
    for(int i = 1, iter = 0; i <= s[s.size()-1]; ++i) {
        if(i > s[iter+1]) ++iter;
        pq.push({(i-s[iter])*(s[iter+1]-i)-1, i});
    }

    for(int i = s[s.size()-1]+1; pq.size() < n; ++i)
        pq.push({LONG_MAX, i});
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int l, n;
    cin >> l;
    vector<int> s(l+1);
    for(int i = 1; i <= l; ++i)
        cin >> s[i];
    cin >> n;

    priority_queue<pair<long,int>, vector<pair<long,int>>, cmp> pq;
    getNums(pq, s, n);
    for(int i = 0; i < n; ++i) {
        cout << pq.top().second << " ";
        pq.pop();
    }
    return 0;
}
