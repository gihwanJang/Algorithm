#include <iostream>
#include <set>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, value;
    cin >> n >> m;

    set<int> A;

    while(n--){
        cin >> value;
        A.insert(value);
    }
    while(m--){
        cin >> value;
        A.erase(value);
    }

    cout << A.size() << "\n";
    for(int v : A)
        cout << v << " ";
    return 0;
}
