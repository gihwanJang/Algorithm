#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int m, f;

    while(true){
        cin >> m >> f;

        if(!m && !f)
            return 0;
        
        cout << m + f << "\n";
    } 
    return 0;
}
