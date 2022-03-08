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

void merge(int *arr, int beg, int mid, int end){
    int i=beg, j=mid+1, k = 0, kmax = end-beg+1;
    int *buf = malloc(sizeof(int)*kmax);
    while(i <= mid && j<= end){
        if(arr[i] < arr[j])
            buf[k++] = arr[i++];
        else
            buf[k++] = arr[j++];
    }
    while(i <= mid)
        buf[k++] = arr[i++];
    while(j <= end)
        buf[k++] = arr[j++];
    for(int i=0; i<k; i++)
        arr[beg+i] = buf[i];
    free(buf);
}

void mergeSort(int *arr, int beg, int end){
    if(beg < end){
        int mid = (beg+end)/2;
        mergeSort(arr, beg, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, beg, mid, end);
    }
}

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
