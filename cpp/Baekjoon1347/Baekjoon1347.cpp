#include <iostream>
#include <vector>

using namespace std;

struct currPoint{
    /*
    * 0 : ^
    * 1 : >
    * 2 : v
    * 3 : <
    */
    int x = 0, y = 0, d = 2;
};


void move(vector<vector<char>>&matrix, currPoint&curr, char c){
    if(c == 'R'){
        curr.d = (curr.d + 5) % 4;
        return;
    }
    else if(c == 'L'){
        curr.d = (curr.d + 3) % 4;
        return;
    }
    else{
        
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    string s;
    currPoint curr;
    vector<vector<char>> matrix(1, vector<char>(1,'.'));

    cin >> n;
    cin >> s;
    for(int i = 0; i < n; ++i)
        move(matrix, curr, s[i]);

    for(vector<char> r : matrix){
        for(int c = 0; c < r.size(); ++c)
            cout << r[c];
        cout << "\n";
    }
    return 0;
}
