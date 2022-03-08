// Author: Gokul Raj, 235, R3A, CSE
// Program 21: Sorting Algorithms: Merge Sort

#include <stdio.h>
#include <stdlib.h>

void showArr(char *msg, int *arr, int n){
    printf("%s: ", msg);
    for(int i=0; i<n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

void merge(int *arr, int beg, int mid, int end){
    int i=beg, j=mid+1, k = 0, kmax = end-beg+1;
    // Create buffer to store elements in order
    int *buf = malloc(sizeof(int)*kmax);
    // While both subarrays have elements, copy in ascending order
    while(i <= mid && j<= end){
        if(arr[i] < arr[j])
            buf[k++] = arr[i++];
        else
            buf[k++] = arr[j++];
    }
    // When one exhaused, copy the others into buffer
    while(i <= mid)
        buf[k++] = arr[i++];
    while(j <= end)
        buf[k++] = arr[j++];
    // Replace array content with buffer
    for(int i=0; i<k; i++)
        arr[beg+i] = buf[i];
    free(buf);
}

void mergeSort(int *arr, int beg, int end){
    if(beg < end){
        int mid = (beg+end)/2;
        // Split to left and right sub array, sort recursively
        mergeSort(arr, beg, mid);
        mergeSort(arr, mid+1, end);
        // Merge left, right sub array
        merge(arr, beg, mid, end);
    }
}

// Driver Code
void main(){
    int n;
    printf("Merge Sort\n---------\n");
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int *arr = malloc(sizeof(int)*n);
    printf("Elements: ");
    for(int i=0; i<n; i++)
        scanf("%d", &arr[i]);
    mergeSort(arr, 0, n-1);
    showArr("Sorted Array", arr, n);
}
