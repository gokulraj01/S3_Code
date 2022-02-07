// Author: Gokul Raj, 235, R3A, CSE
// Sorting Algorithms - Insertion Sort

#include <stdio.h>

#define ARR_LEN 256

// function to dump array as human readable text to console
void showArr(int *arr, int n){
    for(int i=0; i<n; i++)
        printf("%d ", arr[i]);
    printf("\n\n");
}

// implementation of Insertion Sort Algorithm
void insertionSort(int *arr, int n){
    int i, j, key;
    // select one element per iteration from 2nd to last
    for(i=1; i<n; i++){
        key = arr[i];
        // check against previous (sorted) sub array and determine position to insert in
        for(j=i-1; j>=0 && arr[j] > key; j--)
            arr[j+1] = arr[j];
        // insert at found position
        arr[j+1] = key;
    }
}

// driver code
void main(){
    int arr[ARR_LEN], n;
    // input elements
    printf("Enter number of elements: ");
    scanf("%d", &n);
    for(int i=0; i<n; i++)
        scanf("%d", &arr[i]);
    
    insertionSort(arr, n);  // perform insertion sort
    printf("Sorted Array is: ");
    showArr(arr, n);    // show results
}