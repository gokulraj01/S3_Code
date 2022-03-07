//  Author: Gokul Raj, 235, R3A, SCTCE
//  Program 20: Binary Tree Node Search
#include <stdio.h>
#include <stdlib.h>

struct Node {
    char data;
    struct Node *lhs;
    struct Node *rhs;
};

char inputChar(){
    char c = getchar();
    while(c == '\n')
        c = getchar();
    if(c >= 'a' && c <= 'z')
        c -= 32;
    return c;
}

struct Node *makeTree(char name){
    struct Node *root = malloc(sizeof(struct Node));
    root->data = name;
    char c;
    printf("<< %c: ", name);
    c = inputChar();
    if(c != '0')
        root->lhs = makeTree(c);
    else
        root->lhs = NULL;
    printf("%c >>: ", name);
    c = inputChar();
    if(c != '0')
        root->rhs = makeTree(c);
    else
        root->rhs = NULL;
    return root;
}

struct Node *searchTree(struct Node *root, char key){
    if(root->data == key)
        return root;
    struct Node *res = NULL;
    if(root->lhs != NULL)
        res = searchTree(root->lhs, key);
    if(res == NULL && root->rhs != NULL)
        res = searchTree(root->rhs, key);
    return res;
}

struct Node *searchParent(struct Node *parent, struct Node *root, char key){
    if(root->data == key)
        return parent;
    struct Node *res = NULL;
    if(root->lhs != NULL)
        res = searchParent(root, root->lhs, key);
    if(res == NULL && root->rhs != NULL)
        res = searchParent(root, root->rhs, key);
    return res;
}

void deleteNode(struct Node *tree, char delNode){
    struct Node *res = searchParent(NULL, tree, delNode);
    struct Node *temp;
    if(res != NULL){
        printf("Got parent as %c", res->data);
        if(res->lhs->data == delNode && res->lhs->lhs == NULL && res->lhs->rhs == NULL){
            printf("Child is LEFT");
            temp = res->lhs;
            res->lhs = NULL;
            free(temp);
        }
        else
            printf("Node not leaf!!\n");
        if(res->rhs->data == delNode && res->rhs->lhs == NULL && res->rhs->rhs == NULL){
            printf("Child is RIGHT");
            temp = res->rhs;
            res->rhs = NULL;
            free(temp);
        }
        else
            printf("Node not leaf!!\n");
    }
    else
        printf("Node not found!!");
}

void insertNode(struct Node *tree, char root, char nodeName){
    struct Node *res = searchNode(tree, root);
    if(res->lhs == NULL || res->rhs == NULL){
        struct Node *newNode = malloc(sizeof(struct Node));
        newNode->lhs = NULL;
        newNode->rhs = NULL;
        newNode->data = nodeName;
        if(res->lhs == NULL){
            res->lhs = newNode;
            return;
        }
        if(res->rhs == NULL)
            res->rhs = newNode;
    }
    else
        printf("Node Full!!\n");
}

void main(){
    printf("Enter Root Node Name: ");
    struct Node *tree = makeTree(inputChar());
    printf("Enter Node Name to find: ");
    char k = inputChar();
    struct 
}
