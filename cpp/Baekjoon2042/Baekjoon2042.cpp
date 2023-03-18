#include <iostream>
#include <vector>

using namespace std;

class SegmentTree{
private:
    int size;
    vector<long> tree;

private:
    long merge(long l, long r){
        return l + r;
    }

    long buildRec(vector<long>&arr, int node, int l_node, int r_node){
        if(l_node == r_node)
            return tree[node] = arr[l_node];
        
        int mid = l_node + (r_node - l_node) / 2;
        long l_val = buildRec(arr, node * 2, l_node, mid);
        long r_val = buildRec(arr, node * 2 + 1, mid + 1, r_node);

        return tree[node] = merge(l_val, r_val);
    }

    long updateRec(int idx, long new_val, int node, int l_node, int r_node){
        if(idx < l_node || r_node < idx)
            return tree[node];

        if(l_node == r_node)
            return tree[node] = new_val;

        int mid = l_node + (r_node - l_node) / 2;
        long l_val = updateRec(idx, new_val, node * 2, l_node, mid);
        long r_val = updateRec(idx, new_val, node * 2 + 1, mid + 1, r_node);
        return tree[node] = merge(l_val, r_val);
    }

    long queryRec(int l, int r, int node, int l_node, int r_node){
        if(r < l_node || r_node < l)
            return 0;

        if(l <= l_node && r_node <= r)
            return tree[node];

        int mid = l_node + (r_node - l_node) / 2;
        return merge(queryRec(l, r, node*2, l_node, mid), queryRec(l, r, node*2+1, mid+1, r_node));
    }

public:
    void build(vector<long>&arr, int n){
        size = n;
        tree.resize(size * 4);

        buildRec(arr, 1, 0, size - 1);
    }

    void update(int idx, long new_val){
        updateRec(idx, new_val, 1, 0, size - 1);
    }

    long query(int l, int r){
        return queryRec(l, r, 1, 0, size - 1);
    }
};


int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, k, command;
    long a, b;
    cin >> n >> m >> k;

    vector<long> arr(n);
    for(int i = 0; i < n; ++i)
        cin >> arr[i];

    SegmentTree st;
    st.build(arr, n);

    for(int i = 0; i < m+k; ++i){
        cin >> command >> a >> b;

        if(command == 1)
            st.update(a-1, b);
        else
            cout << st.query(a-1, b-1) << "\n";
    }

    return 0;
}
