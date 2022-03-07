//  Author: Gokul Raj, 235, R3A, SCTCE
//  Program 1: Searching Algorithms - Linear Search
#include <stdio.h>

#define ARR_LEN 256

//  Implementation of Linear Search
void main(){
        int n, k, flag = 0, i;
        int arr[ARR_LEN];
        printf("Enter number of elements: ");
        scanf("%d", &n);
        // Array initialization
        for(int i=0; i<n; i++){
                printf("Enter element %d: ", i+1);
                scanf("%d", &arr[i]);
        }
        printf("Enter key to search: ");
        scanf("%d", &k);
        // Linear search to attempt finding key
        for(i=0; i<n; i++){
                if(arr[i] == k){
                        flag = 1;
                        break;
                }
        }
        // Display search result
        if(flag)
                printf("Element found in array at %d\n", i);
        else
                printf("Not found\n");
}
