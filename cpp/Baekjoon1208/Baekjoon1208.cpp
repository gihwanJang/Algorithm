#include <unordered_map>
#include <iostream>
#include <vector>

using namespace std;

void rightSeq(unordered_map<int,int>&map, vector<int>&val, int start, int sum)
{
    if(start == val.size())
    {
        map[sum]++;
        return;
    }

    rightSeq(map, val, start + 1, sum + val[start]);
    rightSeq(map, val, start + 1, sum);
}

void leftSeq(unordered_map<int,int>&map, vector<int>&val, int s, int start, int sum, long&count)
{
    if(start == val.size() / 2)
    {
        count += map[s - sum];
        return;
    }
    
    leftSeq(map, val, s, start + 1, sum + val[start], count);
    leftSeq(map, val, s, start + 1, sum, count);
}

long getNumOfSubSeq(vector<int>&val, int s)
{
    long count = 0;
    unordered_map<int,int> map;

    rightSeq(map, val, val.size()/2, 0);
    leftSeq(map, val, s, 0, 0, count);

    return s ? count : count - 1;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, s;
    cin >> n >> s;

    vector<int> val(n);
    for(int i = 0; i < n; ++i)
        cin >> val[i];

    cout << getNumOfSubSeq(val, s) << "\n";
    return 0;
}
