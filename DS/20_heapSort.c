// Author: Gokul Raj, 235, R3A, CSE
// Program 20: Sorting Algorithms: Heap Sort

#include <stdio.h>
#include <stdlib.h>

void showArr(char *msg, int *arr, int n){
    printf("%s: ", msg);
    for(int i=0; i<n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

void heapify(int *arr, int n, int i){
    // index of left, right child to node-i
    int lc = 2*i+1;
    int rc = lc+1;
    // find max in the subtree at i
    int max = i;
    if(lc < n && arr[lc] > arr[max])
        max = lc;
    if(rc < n && arr[rc] > arr[max])
        max = rc;
    // swap i with max element, and heapify at i
    if(max != i){
        int t = arr[max];
        arr[max] = arr[i];
        arr[i] = t;
        heapify(arr, n, max);
    }
}

void heapSort(int *arr, int n){
    // Make max heap
    for(int i=(n/2)-1; i>=0; i--){
        printf("Maxing at %d\n", i);
        heapify(arr, n, i);
    }
    for(int i=0; i<n; i++){
        // Swap edge elements
        int t = arr[n-i-1];
        arr[n-i-1] = arr[0];
        arr[0] = t;
        // Last i elements are now sorted
        // Do Heapify excluding last i elements
        heapify(arr, n-i-1, 0);
    }
}

void main(){
    int n;
    printf("Heap Sort\n---------\n");
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int *arr = malloc(n);
    printf("Elements: ");
    for(int i=0; i<n; i++)
        scanf("%d", &arr[i]);
    heapSort(arr, n);
    showArr("Sorted Array", arr, n);
}
