1. Declare struct Term with coff, exp and pointer to next Term

- ## `polyAddn(poly1, poly2)`
    1. res = lastNode = NULL
    2. i = poly1
    3. j = poly2
    4. while(i not NULL OR j not NULL):
        1. Create new Term, newNode
        2. if(exp of i == exp of j):
            1. newNode->coff = i->coff + j->coff
            2. newNode->exp = i->exp
            3. i = i->next
            4. j = j->next;
        3. else if(exp of i > exp of j || j == NULL):
            1. newNode->coff = i->coff
            2. newNode->exp = i->exp
            3. i = i->next
        4. else:
            1. newNode->coff = j->coff
            2. newNode->exp = j->exp
            3. j = j->next
        5. if(lastNode == NULL):
            1. res = newNode
        6. else:
            1. lastNode->next = newNode
        7. lastNode = newNode
        8. newNode->next = NULL
    5. return res

- ## `polyRead()`
    1. INPUT length, len
    2. i = 0
    3. res = NULL
    4. while(i < len):
        1. Create new Term, newNode
        2. INPUT coff, exp into newNode
        3. if(prev == NULL):
            1. res = newNode;
        4. else:
            1. prev->next = newNode
            2. prev = newNode
        5. newNode->next = NULL
        6. i += 1
    5. return res

- ## `polyShow(poly)`
    1. p = poly
    2. while(p != NULL):
        1. DISPLAY coff, exp
        2. p = p->next

- ## `main`
    1. Using polyRead, get poly1 and poly2
    2. Call polyAdd using poly1 and poly2, store result in polysum
    3. DISPLAY poly1, poly2, polysum