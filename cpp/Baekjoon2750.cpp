#include<iostream>
#include <stdlib.h>
#include <time.h>

void swap(int* a, int* b){
    int t = *a;
    *a = *b;
    *b = t;
}

int partition (int nums[], int start, int end){
    int pivot = nums[start], left = start, right = end;

    while(left < right){
        while (pivot >= nums[left])
            ++left;
        while (pivot < nums[right])
            --right;
        if (left < right)
            swap(&nums[left], &nums[right]);
    }
    swap(&nums[start], &nums[right]);
    return right;
}

void sort(int nums[], int start, int end){
    if(start < end){
        int pivot = partition(nums, start, end);
        
        sort(nums, start, pivot-1);
        sort(nums, pivot+1, end);
    }
}

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);
    int nums[n];
    for(int i = 0; i < n; ++i)
        scanf("%d", &nums[i]);
    

    sort(nums, 0, n-1);

    for(int i = 0; i < n; ++i)
        printf("%d\n", nums[i]);

    return 0;
}
