// Author: Gokul Raj, 235, R3A, CSE

#include <stdio.h>

#define ARR_LEN 256

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

void showSparse(int (*mat)[3], char* msg){
    int r = mat[0][2]+1, c = 3;
    printf("\n%s\t[%d x %d]\n", msg, r, c);
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++)
            printf("%d ", mat[i][j]);
        printf("\n");
    }
}

void sparseTranspose(int (*mat)[3]){
    int n = mat[0][2];

    int t0 = mat[0][0];
    mat[0][0] = mat[0][1];
    mat[0][1] = t0;

    for(int i=1; i<=n; i++){
        int min = i;
        for(int j=i+1; j<=n; j++){
            if(mat[min][1]*10 + mat[min][0] > mat[j][1]*10 + mat[j][0])
                min = j;
        }
        if(min != i){
            int t0 = mat[i][0], t1 = mat[i][1], t2 = mat[i][2];
            mat[i][0] = mat[min][1]; mat[i][1] = mat[min][0]; mat[i][2] = mat[min][2];
            mat[min][0] = t0; mat[min][1] = t1; mat[min][2] = t2;
        }
        else{
            int t0 = mat[i][0];
            mat[i][0] = mat[i][1];
            mat[i][1] = t0;
        }
    }
}

void main(){
    int mat[ARR_LEN][ARR_LEN], spr[ARR_LEN][3], r, c;
    getMatrix(mat, &r, &c, "Matrix A");
    makeSparseArray(mat, r, c, spr);
    showSparse(spr, "Original Sparse Matrix");
    sparseTranspose(spr);
    showSparse(spr, "Transposed Sparse Matrix");
}