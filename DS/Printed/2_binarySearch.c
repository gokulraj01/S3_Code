//  Author: Gokul Raj, 235, R3A, SCTCE
//  Program 2: Searching Algorithms - Binary Search
#include <stdio.h>

#define ARR_LEN 256

//  Implementation of Binary Search
void main(){
    int n, k, arr[ARR_LEN];
    
    printf("Enter number of elements: ");
    scanf("%d", &n);
    
    int start = 0, end = n-1, mid = 0;
    
    // Array initialization
    for(int i=0; i<n; i++){
        printf("Enter element %d: ", i+1);
        scanf("%d", &arr[i]);
    }
    
    printf("Enter key element to search: ");
    scanf("%d", &k);
    
    int found = 0;
    // Loop until found or until search width is 0
    while(start <= end){
        mid = (start+end)/2;
        // element found, break loop
        if(k == arr[mid]){
            found = 1;
            break;
        }
        // if key after current pivot, new frame is the elements after pivot
        else if(k > arr[mid])
            start = mid+1;
        // if key is before current pivot, new frame is elements until pivot
        else if(k < arr[mid])
            end = mid-1;
    }
    
    //  Display Result
    if(found)
        printf("Element Found at %d\n", mid);
    else
        printf("Not Found\n");    
}
