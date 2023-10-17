#include <iostream>
#include <vector>

using namespace std;

long combination(vector<long>&histogram, int lo, int hi) {
    int mid = (lo + hi) / 2;
    int toLeft = mid;
	int toRight = mid;

    long height = histogram[mid];
    long maxArea = height;

    while(lo < toLeft && toRight < hi) {
		if(histogram[toLeft - 1] < histogram[toRight + 1])
			height = min(height, histogram[++toRight]);	
		else 
			height = min(height, histogram[--toLeft]);
 
		maxArea = max(maxArea, height * (toRight - toLeft + 1)); 
	}

    while (toRight < hi) {
        height = min(height, histogram[++toRight]);
        maxArea = max(maxArea, height * (toRight - toLeft + 1));
    }

    while (lo < toLeft) {
        height = min(height, histogram[--toLeft]);
        maxArea = max(maxArea, height * (toRight - toLeft + 1));
    }
    
    return maxArea;
}

long divideAndConquer(vector<long>&histogram, int lo, int hi) {
    if(lo == hi) return histogram[lo];
    
    int mid = (lo + hi) / 2;
    
    long left = divideAndConquer(histogram, lo, mid);
    long right = divideAndConquer(histogram, mid + 1, hi);

    return max(max(left, right), combination(histogram, lo, hi));
}

long getMaxArea(vector<long>&histogram) {
    return divideAndConquer(histogram, 0, histogram.size()-1);
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while (true) {
        int n;
        cin >> n;
        if(!n) break;

        vector<long> histogram(n);
        for(int i = 0; i < n; ++i)
            cin >> histogram[i];

        cout << getMaxArea(histogram) << "\n";
    }
    return 0;
}

