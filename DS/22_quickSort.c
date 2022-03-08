// Author: Gokul Raj, 235, R3A, CSE
// Program 22: Sorting Algorithms: Quick Sort

#include <stdio.h>
#include <stdlib.h>

void showArr(char *msg, int *arr, int n){
    printf("%s: ", msg);
    for(int i=0; i<n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int partition(int *arr, int start, int end){
    // Store end of current sub array
    int endpos = end;
    // Set 1st element as pivot
    int pivot = start, temp;
    while(start < end){
        // Move left ptr until element greater than pivot found
        while(arr[start] <= arr[pivot] && start < endpos)
            start++;
        // Move right ptr until element less than pivot found
        while(arr[end] > arr[pivot])
            end--;
        // If pointers don't cross, swap those elements 
        if(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
    // Now right ptr is at correct position for pivot
    // Swap pivot to correct place
    temp = arr[end];
    arr[end] = arr[pivot];
    arr[pivot] = temp;
    // return new location for pivot
    return end;
}

void quickSort(int *arr, int start, int end){
    if(start < end){
        // Partition and position pivot correctly
        int pivot = partition(arr, start, end);
        // Sort left,right sub array recursively
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }
}

// Driver Code
void main(){
    int n;
    printf("Quick Sort\n---------\n");
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int *arr = malloc(sizeof(int)*n);
    printf("Elements: ");
    for(int i=0; i<n; i++)
        scanf("%d", &arr[i]);
    quickSort(arr, 0, n-1);
    showArr("Sorted Array", arr, n);
}
