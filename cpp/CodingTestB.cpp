#include<iostream>
#include<utility>
using namespace std;

struct line{
    pair<int, int> point1;
    pair<int, int> point2;
    int w;
};

int solution(int N, line lines[]){
    int sum=0;

    for(int i = 0; i < N; ++i){
        int count = 0;
        double a1 = (lines[i].point2.second - lines[i].point1.second)/(lines[i].point2.first - lines[i].point1.first);
        for(int j = i+1; j < N; ++j){
            double a2 = (lines[j].point2.second - lines[j].point1.second)/(lines[j].point2.first - lines[j].point1.first);
            double x = (a2*lines[j].point1.first - a1*lines[i].point1.first + lines[i].point1.second - lines[j].point1.second) / (a2-a1);
            if(lines[i].point2.first > lines[i].point1.first){
                if(lines[i].point2.first > x && x > lines[i].point1.first)++count;
            }
            else{
                if(lines[i].point2.first < x && x < lines[i].point1.first)++count;
            }
        }
        sum += (count + 1) * lines[i].w;
    }

    return sum;
}

int main(int argc, char const *argv[]){
    int N;
    scanf("%d", &N);
    line lines[N];
    for(int i = 0; i < N; ++i){
        int x1, y1, x2, y2, w;
        scanf("%d %d %d %d %d",&x1, &y1, &x2, &y2, &w);
        line newLine = {make_pair(x1, y1), make_pair(x2, y2), w};
        lines[i]= newLine;
    }
    
    printf("%d\n", solution(N, lines));
    return 0;
}
