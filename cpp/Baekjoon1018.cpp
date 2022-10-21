#include<iostream>
#include<algorithm>
using namespace std;

class Solution{
public:
    int paintBoard(int n, int m, string board[]){
        int minValue=100000;
        
        for(int r = 0; r < n-7; ++r)
            for(int c = 0; c < m-7; ++c){
                int startW = 0, startB = 0;
                for(int i = r; i < r+8; ++i)
                    for(int j = c; j < c+8; ++j){
                        if((i+j) % 2 == 0){
                            if(board[i][j] != 'W') ++startW;
                            if(board[i][j] != 'B') ++startB;
                        }
                        else{
                            if(board[i][j] != 'B') ++startW;
                            if(board[i][j] != 'W') ++startB;
                        }
                    }
                minValue = min(minValue, min(startW, startB));
            }
            
         return minValue;
    }
};

int main(){
    int n,m;
    scanf("%d %d", &n, &m);
    Solution s;
    string board[n];
    for(int i = 0; i < n; ++i)
        cin>>board[i];

    printf("%d\n", s.paintBoard(n, m, board));
    return 0;
}