// Author: Gokul Raj, 235, R3A, CSE

#include <stdio.h>
#include <stdlib.h>

#define ARR_LEN 256

// function to dump array as human readable text to console
void showArr(int *arr, int n){
    for(int i=0; i<n; i++)
        printf("%d ", arr[i]);
    printf(" (Length: %d)\n\n", n);
}

void selectionSort(int *arr, int n){
    for(int i=0; i<n-1; i++){
        int min = i;
        for(int j=i; j<n; j++){
            if(arr[j] < arr[min])
                min = j;
        }
        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
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

    selectionSort(arr, n);     // perform bubble sort
    printf("Sorted Array is: ");
    showArr(arr, n);        // show results
}