// Author: Gokul Raj, 235, R3A, CSE
// Sorting Algorithms - Bubble Sort.

#include <stdio.h>

#define ARR_LEN 256

// function to dump array as human readable text to console
void showArr(int *arr, int n){
    for(int i=0; i<n; i++)
        printf("%d ", arr[i]);
    printf("\n\n");
}

// implementation of Bubble Sort Algorithm
void bubbleSort(int *arr, int n){
    int done;
    // outer loop to traverse array
    for(int i=0; i<n-1; i++){
        done = 1;   // reseting flag

        // inner loop for sorting position
        for(int j=0; j<n-i-1; j++){
            if(arr[j] > arr[j+1]){
                // swapping arr of pos j and pos j+1
                done = 0;
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
        // check if sort done. If so, exit.
        if(done)
            return;
    }
}

// driver code
void main(){
    int arr[ARR_LEN], n;

    // input array
    printf("Enter number of elements: ");
    scanf("%d", &n);
    for(int i=0; i<n; i++)
        scanf("%d", &arr[i]);

    bubbleSort(arr, n);     // perform bubble sort
    printf("Sorted Array is: ");
    showArr(arr, n);        // show results
}