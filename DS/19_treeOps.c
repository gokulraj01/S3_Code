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
        if(res->lhs->data == delNode && res->lhs->lhs == NULL && res->lhs->rhs == NULL){
            temp = res->lhs;
            res->lhs = NULL;
            free(temp);
        }
        else
            printf("Node not leaf!!\n");
        if(res->rhs->data == delNode && res->rhs->lhs == NULL && res->rhs->rhs == NULL){
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
    struct Node *res = searchTree(tree, root);
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

void showTree(char *msg, struct Node *tree){
    printf("\n%s\n", msg);
    struct Node *nodes[2][10];
    int ni = 1, buffi = 0, validCount = 1;
    nodes[buffi][0] = tree;
    char opBuff[20];
    opBuff[0] = '\0';
    while(validCount > 0){
        printf("%s", opBuff);
        int newBuff = !buffi;
        int len = ni, opi = 0;
        validCount = 0; ni = 0;
        for(int i=0; i<len; i++){
            if(nodes[buffi][i] == NULL){
                opBuff[opi++] = 254;
                opBuff[opi++] = ' ';
                nodes[newBuff][ni++] = NULL;
                nodes[newBuff][ni++] = NULL;
            }
            else{
                validCount++;
                opBuff[opi++] = nodes[buffi][i]->data;
                opBuff[opi++] = ' ';
                nodes[newBuff][ni++] = nodes[buffi][i]->lhs;
                nodes[newBuff][ni++] = nodes[buffi][i]->rhs;
            }
        }
        opBuff[opi++] = '\n';
        opBuff[opi] = '\0';
        buffi = newBuff;
    }
}

void main(){
    printf("Binary Tree Operations\nCreate a tree!!\n");
    printf("Enter Root Node Name: ");
    struct Node *tree = makeTree(inputChar());
    showTree("Original Tree", tree);
    printf("\nMenu\n[1] Add\t\t[2] Delete\n[3] Search Node\t[4] Search Parent\n[5] Show Tree\t[6] EXIT\n");
    int looping = 1;
    struct Node *res;
    while(looping){
        int choice;
        printf("\nChoice: ");
        scanf("%d", &choice);
        char src, dest;
        switch(choice){
            case 1:
                printf("New Node Name: ");
                src = inputChar();
                printf("Destination Node: ");
                dest = inputChar(); 
                insertNode(tree, dest, src);
                break;
            case 2:
                printf("Node to remove: ");
                src = inputChar();
                deleteNode(tree, src);
                break;
            case 3:
                printf("Node: ");
                src = inputChar();
                res = searchTree(tree, src);
                res == NULL ? printf("Node not found!!\n") : printf("Node Found!!\n");
                break;
            case 4:
                printf("Node: ");
                src = inputChar();
                res = searchParent(NULL, tree, src);
                res == NULL ? printf("Node not found!!\n") : printf("Parent is Node %c\n", res->data);
                break;
            case 5:
                showTree("Tree Status", tree);
                break;
            case 6:
                looping = 0;
                break;
        }
    }
}
// Sample input: abdf00g000c0eh00i00