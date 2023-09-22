#include <iostream>
#include <vector>

using namespace std;

string isHJS(vector<string>&pqr, int&n) {
    string yes = "HJS! HJS! HJS!";
    string no = "Hmm...";

    vector<string> tmp(3);
    vector<vector<char>> changer = {{'1','2','3'}, {'1','3','2'},
                                    {'2','1','3'}, {'2','3','1'},
                                    {'3','1','2'}, {'3','2','1'}};

    for(int i = 0; i < 6; ++i) {
        for(int j = 0; j < 3; ++j){
            string s = "";
        
            for(int k = 0; k < n; ++k){
                if(pqr[j][k] == 'H') 
                    s.push_back(changer[i][0]);
                else if(pqr[j][k] == 'J')
                    s.push_back(changer[i][1]);
                else
                    s.push_back(changer[i][2]);
            }

            tmp[j] = s;
        }

        if(tmp[0] < tmp[1] && tmp[1] < tmp[2])
            return yes;
    }

    return no;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<string> pqr(3);
    for(int i = 0; i < 3; ++i)
        cin >> pqr[i];

    cout << isHJS(pqr, n) << "\n";
    return 0;
}
