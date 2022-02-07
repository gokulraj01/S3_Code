// Author: Gokul Raj, 235, R3A, CSE

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

void main(){
    printf("\nCIRCULAR QUEUE OPERATIONS\n(1) Enqueue\t(2) Dequeue\t(3) ShowPointers\n");
    while(1){
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
                printf("FRONT: %d\t REAR: %d\n", front, rear);
                break;
        }
    }
}