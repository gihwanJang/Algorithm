#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class SegmentTree{
private:
    int size;
    int mode;
    vector<int> tree;

private:
    int buildRec(vector<int>&arr, int node, int l_node, int r_node){
        if(l_node == r_node)
            return tree[node] = arr[l_node];
        
        int mid = l_node + (r_node - l_node) / 2;
        int l_val = buildRec(arr, node * 2, l_node, mid);
        int r_val = buildRec(arr, node * 2 + 1, mid + 1, r_node);

        return tree[node] = (mode ? min(l_val, r_val):max(l_val, r_val));
    }

    int queryRec(int l, int r, int node, int l_node, int r_node){
        if(r < l_node || r_node < l)
            return mode ? 2000000000 : 0;

        if(l <= l_node && r_node <= r)
        return tree[node];

        int mid = l_node + (r_node - l_node) / 2;
        int l_val = queryRec(l, r, node*2, l_node, mid);
        int r_val = queryRec(l, r, node*2+1, mid+1, r_node);

        return (mode ? min(l_val, r_val):max(l_val, r_val));
    }
public:
    void build(int n, vector<int>&arr, int m){
        size = n;
        tree.resize(size * 4);
        mode = m;

        buildRec(arr, 1, 0, size-1);
    }

    int query(int l, int r){
        return queryRec(l, r, 1, 0, size-1);
    }
};

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e;
    cin >> n >> m;

    vector<int> nums(n);
    for(int i = 0; i < n; ++i)
        cin >> nums[i];

    SegmentTree min_st;
    min_st.build(n, nums, 1);
    SegmentTree max_st;
    max_st.build(n, nums, 0);
    
    while(m--){
        cin >> s >> e;

        cout << min_st.query(s-1, e-1) << " " << max_st.query(s-1, e-1) << "\n";
    }
    return 0;
}
