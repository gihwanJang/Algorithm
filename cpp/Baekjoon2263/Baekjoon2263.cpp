#include <iostream>
#include <vector>

using namespace std;

void preOrder(vector<int>&pre, vector<int>&in, vector<int>&post, int in_s, int in_e, int post_s, int post_e){
    if (in_s > in_e || post_s > post_e)
        return;

    pre.push_back(post[post_e]);

    int root, left_size;

    for(int i = in_s; i <= in_e; ++i)
        if(in[i] == post[post_e]){
            root = i;
            break;
        }

    left_size = root - in_s;

    preOrder(pre, in, post, in_s, root - 1, post_s, post_s + left_size - 1);
    preOrder(pre, in, post, root + 1, in_e, post_s + left_size, post_e - 1);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> pre;
    vector<int> in(n);
    vector<int> post(n);

    for(int i = 0; i < n; ++i)
        cin >> in[i];

    for(int i = 0; i < n; ++i)
        cin >> post[i];

    preOrder(pre, in, post, 0, n - 1, 0, n - 1);

    for(int i = 0; i < n; ++i)
        cout << pre[i] << " ";
    cout << "\n";
    return 0;
}
