// Author: Gokul Raj, 235, R3A, CSE

#include <stdio.h>

#define ARR_LEN 256

void makeSparseArray(int (*sourceMat)[ARR_LEN], int r, int c, int (*destMat)[3]){
    int ri = 1;
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            if(sourceMat[i][j] != 0){
                destMat[ri][0] = i;
                destMat[ri][1] = j;
                destMat[ri][2] = sourceMat[i][j];
                ri++;
            }
        }
    }
    destMat[0][0] = r;
    destMat[0][1] = c;
    destMat[0][2] = ri-1;
}

void getMatrix(int (*destMat)[ARR_LEN], int* r, int* c, char* msg){
    printf("%s\n", msg);
    printf("Enter rows and cols: ");
    scanf("%d %d", r, c);
    for(int i=0; i<*r; i++){
        printf("> ");
        for(int j=0; j<*c; j++)
            scanf("%d", &destMat[i][j]);
    }
}

void getSparse(int (*destMat)[3], char* msg){
    printf("%s\n", msg);
    printf("Enter Sparse Matrix\n> ");
    scanf("%d %d %d", &destMat[0][0], &destMat[0][1], &destMat[0][2]);
    int n = destMat[0][2];
    for(int i=1; i<=n; i++){
        printf("> ");
        scanf("%d %d %d", &destMat[i][0], &destMat[i][1], &destMat[i][2]);
    }
}

void showMatrix(int (*mat)[ARR_LEN], int r, int c, char* msg){
    printf("\n%s\t[%d x %d%]\n", msg, r, c);
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++)
            printf("%d ", mat[i][j]);
        printf("\n");
    }
}

void showSparse(int (*mat)[3], char* msg){
    int r = mat[0][2]+1, c = 3;
    printf("\n%s\t[%d x %d%]\n", msg, r, c);
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++)
            printf("%d ", mat[i][j]);
        printf("\n");
    }
}

void main(){
    int mat[ARR_LEN][ARR_LEN], r, c, res[ARR_LEN][3];
    // getMatrix(mat, &r, &c);
    // showMatrix(mat, r, c, "Input Matrix");
    // makeSparseArray(mat, r, c, res);
    getSparse(res, "Sparse Matrix A");
    showSparse(res, "Sparse Array");
}