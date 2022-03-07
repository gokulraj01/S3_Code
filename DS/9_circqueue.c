//  Author: Gokul Raj, 235, R3A, SCTCE
//  Program 9: Circular Queue using Array

#include <stdio.h>

#define MAX_LEN 3

int queue[MAX_LEN], front = -1, rear = -1;

int isFull(){
    if(front == (rear+1)%MAX_LEN)
        return 1;
    return 0;
}

int isEmpty(){
    if(front == -1 && rear == -1)
        return 1;
    return 0;
}

void enqueue(int ele){
    if(isFull()){
        printf("Queue Full...\n");
        return;
    }
    rear = (rear+1)%MAX_LEN;
    queue[rear] = ele;
    if(front == -1)
        front = 0;
}

int dequeue(){
    if(isEmpty()){
        printf("Queue Empty...\n");
        return -1;
    }
    int t = queue[front];
    front = (front+1)%MAX_LEN;
    if(isFull()){
        front = -1;
        rear = -1;
    }
    return t;
}

void showQueue(){
    if(!isEmpty()){
        printf("FRONT --> ");
        int i;
        for(i=front; i!=rear; i=(i+1)%MAX_LEN)
            printf("%d ", queue[i]);
        printf("%d ", queue[i]);
        printf("<-- REAR\n");
    }
    else
        printf("Queue Empty!!\n");
}

void main(){
    int looping = 1;
    printf("\nCIRCULAR QUEUE OPERATIONS\n[1] Enqueue\t[2] Dequeue\n[3] Show Queue\t[4] EXIT\n");
    while(looping){
        int opt, ele;
        printf("\nOption: ");
        scanf("%d", &opt);
        switch(opt){
            case 1:
                printf("Element to queue: ");
                scanf("%d", &ele);
                enqueue(ele);
                break;
            case 2:
                ele = dequeue();
                if(ele != -1)
                    printf("Got: %d\n", ele);
                break;
            case 3:
                showQueue();
                break;
            case 4:
                looping = 0;
                break;
        }
    }
}
