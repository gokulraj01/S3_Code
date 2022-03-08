// Author: Gokul Raj, 235, R3A, CSE
// Program 17: Infix to Postfix Expression, it's evaluation

#include <stdio.h>
#include <math.h>

#define MAX_SIZE 64
#define EXP_MAX 256

// Calculates a^exp in double format
double pow(double a, double exp){
    double op = 1.0;
    for(double i=1.0; i<=exp; i+=1.0)
        op *= a;
    return op;
}

// Operator Priority Lookup
int opRank(char op){
    switch(op){
        case '^':
            return 3;
        case '/':
            return 2;
        case '*':
            return 2;
        case '+':
            return 1;
        case '-':
            return 1;
        case '(':
            return 0;
        default:
            return -1;
    }
}

// Performs op on a, b, returns output
double calculate(double a, double b, char op){
    double res;
    switch(op){
        case '^':
            res = pow(a,b);
            break;
        case '/':
            res = a/b;
            break;
        case '*':
            res = a*b;
            break;
        case '+':
            res = a+b;
            break;
        case '-':
            res = a-b;
            break;
    }
    return res;
}

// Display polish conversion stack
void status(char c, char* s, char* op, int top, int opi){
    printf("%c\t", c);
    for(int i=0; i<=top; i++)
        putc(s[i], stdout);
    putc('\t', stdout);
    for(int i=0; i<opi; i++)
        putc(op[i], stdout);
    putc('\n', stdout);
}

// Convert infix to postfix(polish) expression
void toPolish(char* exp, char* op){
    char s[MAX_SIZE];
    int top = -1, opi = 0;
    for(int i=0; exp[i] != '\0'; i++){
        int r = opRank(exp[i]);
        
        // Simply push to stack
        if((top < 0 || opRank(s[top]) < r || r == 0) && r >= 0)
            s[++top] = exp[i];
            
        // Pop until bracket start
        else if(exp[i] == ')'){
            char c = s[top--];
            while(c != '('){
                op[opi++] = c;
                c = s[top--];
            }
        }
        
        // Copy to output
        else if(r < 0)
            op[opi++] = exp[i];
            
        // Pop until low priority
        else{
            char c = s[top--];
            while(opRank(c) > r && c != '('){
                op[opi++] = c;
                c = s[top--];
            }
            s[++top] = c;
            s[++top] = exp[i];
        }
        status(exp[i], s, op, top, opi);
    }
    // Pop until stack empty
    while(top > -1)
        op[opi++] = s[top--];
}

// Evaluate a Polish Expression
double evaluatePolish(char *polExp){
    double s[MAX_SIZE];
    int top = -1;
    double a = 0, b = 0;
    for(int i=0; polExp[i]!='\0'; i++){
        char c = polExp[i];
        if(c >= '0' && c <= '9')
            s[++top] = c-'0';
        else{
            b = s[top--];
            a = s[top--];
            s[++top] = calculate(a, b, c);
        }
    }
    return s[0];
}

// Driver Code
void main(){
    char op[EXP_MAX], exp[EXP_MAX]; 
    printf("Enter an expression: ");
    scanf("%s", exp);
    printf("Input\tStack\tOut\n");
    toPolish(exp, op);
    printf("Polish: %s\n", op);
    printf("Result: %2f\n", evaluatePolish(op));
}
