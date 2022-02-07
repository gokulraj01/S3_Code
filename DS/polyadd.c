// Author: Gokul Raj, 235, R3A, CSE

#include <stdio.h>
#include <stdlib.h>

#define POLY_MAX_LEN 10

struct Poly {
    struct Term{
        int coff;
        int exp;
    } terms[POLY_MAX_LEN];
    int length;
};

struct Poly polyAddn(struct Poly poly1, struct Poly poly2){
    int i = 0, j = 0, ri = 0;
    struct Poly res;
    while(i < poly1.length || j < poly2.length){
        if(poly1.terms[i].exp == poly2.terms[j].exp){
            printf("Same coff");
            res.terms[ri].coff = poly1.terms[i].coff + poly2.terms[j].coff;
            res.terms[ri].exp = poly1.terms[i].exp;
            i++; j++;
        }
        else if(poly1.terms[i].exp > poly2.terms[i].exp || j == poly2.length){
            res.terms[ri].coff = poly1.terms[i].coff;
            res.terms[ri].exp = poly1.terms[i].exp;
            i++;
        }
        else{
            res.terms[ri].coff = poly2.terms[j].coff;
            res.terms[ri].exp = poly2.terms[j].exp;
            j++;
        }
        ri++;
    }
    res.length = ri;
    return res;
}

struct Poly polyRead(char* query){
    printf("%s\n", query);
    struct Poly res;
    printf("Enter number of terms: ");
    scanf("%d", &res.length);
    for(int i=0; i<res.length; i++){
        printf("Term %d | Coff and Exp: ", i+1);
        scanf("%d %d", &res.terms[i].coff, &res.terms[i].exp);
    }
    return res;
}

void polyShow(struct Poly poly){
    for(int i=0; i<poly.length; i++){
        if(poly.terms[i].coff > 0)
            printf("+ %dx^%d ", poly.terms[i].coff, poly.terms[i].exp);
        else
            printf("- %dx^%d ", poly.terms[i].coff, poly.terms[i].exp);
    }
    printf("\t(Length: %d)\n\n", poly.length);
} 
void main(){
    struct Poly poly1 = polyRead("Enter 1st Polynomial");
    polyShow(poly1);
    struct Poly poly2 = polyRead("Enter 2nd Polynomial");
    polyShow(poly2);
    struct Poly poly_res = polyAddn(poly1, poly2);
    polyShow(poly_res);
}