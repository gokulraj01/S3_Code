//  Author: Gokul Raj, 235, R3A, SCTCE
//  Program 4: Sorting Algorithms: Insertion Sort
#include <stdio.h>

#define ARR_LEN 256

// Implementation of Insertion Sort
void insertionSort(int *arr, int n){
    // Assume 1st sorted, start from 2nd index
    for(int i=1; i<n; i++){
        // Assign ith element as key
        int k = arr[i], j;
        // Compare against all previous elements
        for(j=i-1; j>=0 && arr[j] > k; j--)
            arr[j+1] = arr[j];
        // Insert key at right position
        arr[j+1] = k;
    }
}

// Display the array
void showArr(int *arr, int n){
    for(int i=0; i<n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

//  driver code
void main(){
    int n, arr[ARR_LEN];
    printf("Enter number of elements: ");
    scanf("%d", &n);
    
    for(int i=0; i<n; i++)
        scanf("%d", &arr[i]);
    
    insertionSort(arr, n);
    printf("Sorted Array is: ");
    showArr(arr,n);
}
