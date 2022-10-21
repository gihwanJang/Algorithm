#include <iostream>
#include <algorithm>
using namespace std;

struct user{
    string name;
    int d, m, y;
};

bool cmp(user a, user b){
    if(a.y < b.y) return true;
    else if(a.y > b.y) return false;
    else{
        if(a.m < b.m) return true;
        else if(a.m > b.m) return false;
        else{
            if(a.d < b.d) return true;
            else if(a.d > b.d) return false;
        }
    }
    return true;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    user users[100];
    int n;

    cin >> n;
    for(int i = 0; i < n; ++i)
        cin >> users[i].name >> users[i].d >> users[i].m >> users[i].y;
    
    sort(users, users+n, cmp);

    cout << users[n - 1].name << "\n" << users[0].name << "\n";
    return 0;
}

