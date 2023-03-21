#include <iostream>

int main(int argc, char const *argv[]){
    int k, n, m;
    std::cin >> k >> n >> m;

    std::cout << (k*n <= m ? 0 : n*k - m) << "\n";
    return 0;
}
