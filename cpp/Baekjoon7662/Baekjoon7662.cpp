#include <iostream>
#include <set>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    char c;
    int T, k, n;
    cin >> T;

    while(T--){
        multiset<int> ms;

        cin >> k;
        while(k--){
            cin >> c >> n;

            if(c =='I')
                ms.insert(n);
            else{
                if(ms.empty())
                    continue;
                else if(n == 1)
                    ms.erase(--ms.end());
                else
                    ms.erase(ms.begin());
            }
        }

        if(ms.empty())
            cout << "EMPTY" << "\n";
        else
            cout << *(--ms.end()) << " " << *ms.begin() << "\n";
    }
    return 0;
}
