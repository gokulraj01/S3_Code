/** @author Gokul Raj | 235 | R3A | CSE
 * AIM: Write a Java program to perform heap sort
 * PROGRAM 17: Heap Sort
 */
 
 import java.util.Scanner;
 
 class HeapSort{ 
    int[] heapify(int[] arr, int i, int n){
        int lc = 2*i+1, rc = lc+1, max = i;
        // If lc >= n, leaf node. Do nothing.
        if(lc >= n)
            return arr;
        // if rc >= n after lc < n, only one child (left)
        // Set rc to i for ignoring in max evaluation
        if(rc >= n)
            rc = i;
        // Find max among i, lc, rc-th elements
        if(arr[lc] > arr[max])
            max = lc;
        if(arr[rc] > arr[max])
            max = rc;
        if(max != i){
            // Swap max element to root
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            // Heapify previous position of max element
            arr = heapify(arr, max, n);
        }
        return arr;
    }
    
    int[] heapSort(int[] arr, int n){
        // Make max heap
        for(int i=(n/2)-1; i>=0; i--)
            arr = heapify(arr, i, n);
        for(int i=0; i<n; i++){
            // Swap 1st element (now max) to end
            int temp = arr[0];
            arr[0] = arr[n-i-1];
            arr[n-i-1] = temp;
            // Heapify upto element before current swap
            arr = heapify(arr, 0, n-i-1);
        }
        return arr;
    }
    
    void run(){
        System.out.println("Heap Sort");
        // Input array
        System.out.print("Enter elements: ");
        Scanner s = new Scanner(System.in);
        String[] in = (s.nextLine()).split(" ");
        int len = in.length;
        int[] arr = new int[len];
        for(int i=0; i<len; i++)
            arr[i] = Integer.parseInt(in[i]);
        // Perform sort
        arr = heapSort(arr, len);
        // Display sorted array
        System.out.print("Sorted Array: ");
        for(int i: arr)
            System.out.print(i+" ");
        System.out.println();
    }
    
    public static void main(String args[]){
        new HeapSort().run();
    }
 }
