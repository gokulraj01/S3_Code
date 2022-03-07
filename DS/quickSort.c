// Author: Gokul Raj, 235, R3A, CSE

#include <stdio.h>
#include <stdlib.h>

#define ARR_LEN 256

void showArr(char *msg, int *arr, int n){
    printf("%s: ", msg);
    for(int i=0; i<n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int partition(int *arr, int start, int end){
    int endpos = end;
    int pivot = start, temp;
    while(start < end){
        while(arr[start] <= arr[pivot] && start < endpos)
            start++;
        while(arr[end] > arr[pivot])
            end--;
        if(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
    temp = arr[end];
    arr[end] = arr[pivot];
    arr[pivot] = temp;
    return end;
}

void quickSort(int *arr, int start, int end){
    if(start < end){
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }
}

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
