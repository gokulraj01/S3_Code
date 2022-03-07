//  Author: Gokul Raj, 235, R3A, SCTCE
//  Program 3: Sorting Algorithms: Bubble Sort
#include <stdio.h>

#define ARR_LEN 256

//  Implementation of bubble sort
void main(){
    int n, arr[ARR_LEN];
    printf("Enter number of elements: ");
    scanf("%d", &n);
    
    // Array initialization
    for(int i=0; i<n; i++){
        printf("Enter element %d: ", i+1);
        scanf("%d", &arr[i]);
    }
    
    int done = 1;
    for(int i=0; i<n-1; i++){
        done = 1;
        for(int j=0; j<n-i-1; j++){
            if(arr[j] > arr[j+1]){
                done = 0;
                // Swapping j with j+1
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        // if done, array already sorted. Exit then.
        if(done)
            break;
    }
    
    // Array display
    printf("Sorted Array is: ");
    for(int i=0; i<n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}
