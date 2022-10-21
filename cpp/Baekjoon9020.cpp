#include<iostream>
#include<math.h>
#include<vector>
using namespace std;

vector<int> primeNums;

void setPrimeNum(){
    int max = 10000;
    int arr[max+1];
    for(int i = 2; i <= max; ++i) arr[i]=i;
    for(int i = 2; i * i <= max; ++i){
        if (arr[i] == 0) continue;
        for (int j = i * i; j <= max; j += i)
            arr[j] = 0;
    }
    for(int i = 2; i <= max; ++i)
        if(arr[i] != 0) primeNums.push_back(arr[i]);
}

void solution(int n){
    int a=5000,b=-5000;
    for(size_t i = 0; i < primeNums.size() && primeNums.at(i) < n; ++i){
        int subNum = n - primeNums.at(i);
        for(size_t j = 0;  j < primeNums.size() && primeNums.at(i) <= subNum; ++j)
            if(subNum==primeNums.at(j))
                if(abs(primeNums.at(i) - primeNums.at(j)) < abs(a - b)){
                    a=primeNums.at(i);
                    b=primeNums.at(j);
                }
    }
    printf("%d %d\n", a, b);
}

int main(int argc, char const *argv[]){
    int T, n;
    scanf("%d", &T);

    setPrimeNum();

    for(; T > 0; --T){
        scanf("%d",&n);
        
        solution(n);
    }
    return 0;
}
