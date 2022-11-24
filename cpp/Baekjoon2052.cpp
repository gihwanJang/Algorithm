#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    double answer = pow(0.5, N);
    
    printf("%.*f",N,answer);
    return 0;
}
