#include<cstdio>
using namespace std;

int a, b, c;

long solution(long u){
	if(u==1) return a%c;
	
	long r = solution(u/2)%c;
	
    return u % 2 == 0 ? r * r % c : r * r % c * a % c;
}

int main(int argc, char const *argv[]){
    scanf("%d %d %d", &a, &b, &c);
    printf("%ld\n", solution(b));
    return 0;
}
