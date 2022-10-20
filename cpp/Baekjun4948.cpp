#include<iostream>
#define MAX 123456 * 2

int arr[MAX+1];

void setArray(){
    for (int i = 2; i <= MAX; ++i)
        arr[i] = i;
    for (int i = 2; i * i <= MAX; i++){
        if (arr[i] == 0) continue;
        for (int j = i * i; j <= MAX; j += i)
            arr[j] = 0;
    }

}

int solution(int N){
    int count=0;
    for(int i = N+1; i <= 2*N; ++i)
        if(arr[i] != 0) ++count;
    return count;
}

int main(int argc, char const *argv[]){
    int N;

    while(true){
        scanf("%d", &N);
        if(N == 0) break;
        setArray();
        printf("%d\n", solution(N));
    }

    return 0;
}
