#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> table(10, 0);

void countMinValue(){
    if(table[6] < table[9]){
        ++table[6];
        return;
    }
    ++table[9];
}

void countNum(int n){
    if(n == 6 || n == 9){
        countMinValue();
        return;
    }
    ++table[n];
}

void checkDigit(int n){
    for(; n > 0; n /= 10)
        countNum(n % 10);
}

int getSet(){
    int set = 0;
    for(int i = 0; i < 10; ++i)
        set = max(set, table[i]);
    return set;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    checkDigit(n);

    cout << getSet() << "\n";
    return 0;
}
