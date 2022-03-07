//  Author: Gokul Raj, 235, R3A, SCTCE
//  Program 6: Polynomial Addition

#include <stdio.h>

#define POLY_MAX_LEN 256

struct Term{
    int coff;
    int exp;
};

void showPoly(struct Term poly[POLY_MAX_LEN], int len){
    for(int i=0; i<len; i++){
        if(poly[i].coff > 0)
            printf(" + %dx^%d", poly[i].coff, poly[i].exp);
        else
            printf(" - %dx^%d", poly[i].coff, poly[i].exp);
    }
    printf(" [Length: %d]\n\n", len);
}

void getPoly(struct Term *inPoly, int *len){
    printf("Enter number of terms: ");
    scanf("%d", len);
    printf("Term of form [coff exp]\n\n");
    for(int i=0; i<(*len); i++){
        printf("Enter term %d: ", i+1);
        scanf("%d %d", &inPoly[i].coff, &inPoly[i].exp);
    }
}

void addPoly(struct Term *poly1, struct Term *poly2, int l1, int l2, struct Term *resPoly, int *lr){
    int i=0, j=0, ri = 0;
    while(i < l1 || j < l2){
        if(poly1[i].exp == poly2[j].exp){
            resPoly[ri].exp = poly1[i].exp;
            resPoly[ri].coff = poly1[i].coff + poly2[j].coff;
            i++; j++;
        }
        else if(poly1[i].exp > poly2[j].exp || j == l2){
            resPoly[ri].exp = poly1[i].exp;
            resPoly[ri].coff = poly1[i].coff;
            i++;
        }
        else{
            resPoly[ri].exp = poly2[j].exp;
            resPoly[ri].coff = poly2[j].coff;
            j++;
        }
        ri++;
    }
    *lr = ri;
}


//  Implementation of Polynomial Addition
void main(){
    struct Term poly1[POLY_MAX_LEN], poly2[POLY_MAX_LEN], sum[POLY_MAX_LEN];
    int l1, l2, ls;
    printf("Enter Polynomial 1\n");
    getPoly(poly1, &l1);
    printf("\nEnter Polynomial 2\n");
    getPoly(poly2, &l2);
    
    addPoly(poly1, poly2, l1, l2, sum, &ls);
    printf("\nPoly1 is: ");
    showPoly(poly1, l1);
    printf("Poly2 is: ");
    showPoly(poly2, l2);
    printf("Sum is: ");
    showPoly(sum, ls);
}
