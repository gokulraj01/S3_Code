// Author: Gokul Raj, 235, R3A, CSE

#include <stdio.h>

#define MAX_SIZE 3

int stack[MAX_SIZE], top = -1;

int isFull(){
    if(top == MAX_SIZE-1)
        return 1;
    return 0;
}

int isEmpty(){
    if(top == -1)
        return 1;
    return 0;
}

void push(int ele){
    if(isFull(top)){
        printf("Stack Overflow...\n");
        return;
    }
    stack[++top] = ele;
}

int pop(){
    if(isEmpty(top)){
        printf("Stack Underflow...\n");
        return -1;
    }
    int t = stack[top--];
    return t;
}

void main(){
    printf("\nSTACK OPERATIONS\n(1) Push\t(2) Pop\t\t(3) ShowTop\n");
    while(1){
        int opt, ele;
        printf("\nOption: ");
        scanf("%d", &opt);
        switch(opt){
            case 1:
                printf("Element to push: ");
                scanf("%d", &ele);
                push(ele);
                break;
            case 2:
                ele = pop();
                if(ele != -1)
                    printf("Got: %d\n", ele);
                break;
            case 3:
                printf("TOP: %d\n", top);
                break;
        }
    }
}