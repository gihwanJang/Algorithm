#include<cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n, m = 1;

	scanf("%d", &n);
	while (m < n)
		m *= 2;

	printf("%d", 2 * n - m);
	return 0;
}
