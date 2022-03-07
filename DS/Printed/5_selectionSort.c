//  Author: Gokul Raj, 235, R3A, SCTCE
//  Program 5: Sorting Algorithms: Selection Sort
#include <stdio.h>

#define ARR_LEN 256

// Implementation of selection sort
void selectionSort(int *arr, int n){
    for(int i=0; i<n-1; i++){
        // Find min element in subarray starting at i
        int min = i;
        for(int j=i; j<n; j++){
            if(arr[j] < arr[min])
                min = j;
        }
        // Swap ith element with element at min position
        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
    }
}

// Array Display
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
    
    selectionSort(arr, n);
    printf("Sorted Array is: ");
    showArr(arr,n);
}
