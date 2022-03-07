//  Author: Gokul Raj, 235, R3A, SCTCE
//  Program 6: Polynomial Addition

#include <stdio.h>

#define POLY_MAX_LEN 256

// Structure to hold polynomial term
struct Poly{
    struct Term{
        int coff;
        int exp;
    } terms[POLY_MAX_LEN];
    int length;
};

// Displays a given polynomial
void showPoly(struct Poly poly){
    for(int i=0; i<poly.length; i++){
        if(poly.terms[i].coff > 0)
            printf(" + %dx^%d", poly.terms[i].coff, poly.terms[i].exp);
        else
            printf(" - %dx^%d", poly.terms[i].coff, poly.terms[i].exp);
    }
    printf(" [Length: %d]\n\n", poly.length);
}

// Inputs a polynomial from user
struct Poly getPoly(){
    struct Poly inPoly;
    printf("Enter number of terms: ");
    scanf("%d", &inPoly.length);
    printf("Term of form [coff exp]\n\n");
    for(int i=0; i<inPoly.length; i++){
        printf("Enter term %d: ", i+1);
        scanf("%d %d", &inPoly.terms[i].coff, &inPoly.terms[i].exp);
    }
    
    return inPoly;
}

// Add two polynomials together, return sum polynomial
struct Poly addPoly(struct Poly poly1, struct Poly poly2){
    struct Poly resPoly;
    int i=0, j=0, ri = 0;
    // Loop until both polynomial terms exhausted
    while(i < poly1.length || j < poly2.length){
        // If exp match, add coff and link to resPoly
        if(poly1.terms[i].exp == poly2.terms[j].exp){
            resPoly.terms[ri].exp = poly1.terms[i].exp;
            resPoly.terms[ri].coff = poly1.terms[i].coff + poly2.terms[j].coff;
            i++; j++;
        }
        // If exp1 > exp2 or 2nd poly exhausted, copy term from poly1 into res
        else if(poly1.terms[i].exp > poly2.terms[j].exp || j == poly2.length){
            resPoly.terms[ri].exp = poly1.terms[i].exp;
            resPoly.terms[ri].coff = poly1.terms[i].coff;
            i++;
        }
        // If exp1 < exp2 or 1st poly exhausted, copy term from poly2 into res
        else{
            resPoly.terms[ri].exp = poly2.terms[j].exp;
            resPoly.terms[ri].coff = poly2.terms[j].coff;
            j++;
        }
        ri++;
    }
    resPoly.length = ri;
    return resPoly;
}


//  Implementation of Polynomial Addition
void main(){
    printf("Enter Polynomial 1\n");
    struct Poly poly1 = getPoly();
    printf("\nEnter Polynomial 2\n");
    struct Poly poly2 = getPoly();
    
    struct Poly resPoly = addPoly(poly1, poly2);
    printf("\nPoly1 is: ");
    showPoly(poly1);
    printf("Poly2 is: ");
    showPoly(poly2);
    printf("Sum is: ");
    showPoly(resPoly);
}
