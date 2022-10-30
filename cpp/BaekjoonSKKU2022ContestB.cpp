#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define scale 1000000000

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    double maximumP = 1;
    vector<double> p(10);
    for(int i = 0; i < 10; ++i)
        cin >> p[i];
    
    sort(p.begin(), p.end(), greater<>());

    for(int i = 0; i < 9; ++i)
        maximumP *= p[i] / (i + 1);
    
    cout<<fixed;
    cout.precision(6);
    cout << (maximumP * scale) << "\n";
    return 0;
}
