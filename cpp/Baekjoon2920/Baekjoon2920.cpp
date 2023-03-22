#include <iostream>

using namespace std;

string sorted(bool a, bool d){
    if(a)
        return "ascending";
    else if(d)
        return "descending";
    else
        return "mixed";
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    bool asc = true;
    bool des = true;
    int prev, curr;

    cin >> prev;
    for(int i = 1; i < 8; ++i){
        cin >> curr;

        if(prev < curr)
            des = false;
        else
            asc = false;

        prev = curr;
    }

    cout << sorted(asc, des) << "\n";
    return 0;
}
