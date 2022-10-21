#include<iostream>
using namespace std;

int solution(int n,string ward[]){
    int count = n;

    for(size_t i=0; i<n; ++i){
        int alpa[26]={0,};
        ++alpa[ward[i][0]-97];
        for(size_t j=1; j<ward[i].length(); ++j){
            if(ward[i][j-1]!=ward[i][j]&&alpa[ward[i][j]-97]!=0){
                --count;
                break;
            }
            ++alpa[ward[i][j]-97];
        }
    }

    return count;
}

int main(int argc, char const *argv[]){
    int n;
    cin>>n;
    string ward[n];
    for (size_t i = 0; i<n; ++i)
        cin>>ward[i];

    cout<<solution(n,ward)<<endl;
    return 0;
}
