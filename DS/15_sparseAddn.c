// Author: Gokul Raj, 235, R3A, CSE
// Program 15: Addition of Sparse Matrices

#include <stdio.h>

#define ARR_LEN 256

// Input Matrix from user
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

// Input Sparse Matrix from user
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

// Convert Matrix to Sparse Matrix
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

// Show a formatted sparse matrix
void showSparse(int (*mat)[3], char* msg){
    int r = mat[0][2]+1, c = 3;
    printf("\n%s\t[%d x %d]\n", msg, r, c);
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++)
            printf("%d ", mat[i][j]);
        printf("\n");
    }
}

// Add two sparse matrices together
void addSparse(int (*spc1)[3], int (*spc2)[3], int (*dest)[3]){
    int n1 = spc1[0][2]+1, n2 = spc2[0][2]+1, i = 1, j = 1, ri = 1;
    while(i < n1 || j < n2){
        if(spc1[i][0] == spc2[j][0] && spc1[i][1] == spc2[j][1]){
            dest[ri][0] = spc1[i][0];
            dest[ri][1] = spc1[i][1];
            dest[ri][2] = spc1[i][2] + spc2[j][2];
            i++; j++;
        }
        else if(spc1[i][0] < spc2[j][0] || (spc1[i][0] == spc2[j][0] && spc1[i][1] < spc2[j][1]) || j == n2){
            dest[ri][0] = spc1[i][0];
            dest[ri][1] = spc1[i][1];
            dest[ri][2] = spc1[i][2];
            i++;
        }
        else{
            dest[ri][0] = spc2[j][0];
            dest[ri][1] = spc2[j][1];
            dest[ri][2] = spc2[j][2];
            j++;
        }
        ri++;
    }
    dest[0][0] = spc1[0][0];
    dest[0][1] = spc1[0][1];
    dest[0][2] = ri-1;
}

// Driver Code
void main(){
    int spcA[ARR_LEN][3], spcB[ARR_LEN][3], sum[ARR_LEN][3];
    getSparse(spcA, "Sparse A");
    getSparse(spcB, "Sparse B");
    addSparse(spcA, spcB, sum);
    showSparse(spcA, "Matrix A");
    showSparse(spcB, "Matrix B");
    showSparse(sum, "Sum of A and B");
}