1. Initialize structure Node with name, roll and next.

I. makeNode()
1. Create new Node, newNode
2. INPUT name, roll number, mark into newNode
3. return newNode

II. addFront()
1. Get n from makeNode()
2. Set n->next to NULL if(HEAD == NULL), else HEAD.
3. HEAD = n

III. removeFront()
1. if(HEAD == NULL)
    1. return
2. temp = HEAD->next
3. Delete HEAD
4. HEAD = temp

IV. addEnd()
1. Get n from makeNode()
2. if(HEAD == NULL)
    1. HEAD = n
3. else
    1. end = HEAD
    2. while(end->next != NULL)
        1. end = end->next
    3. end->next = n

V. removeEnd()
1. if(HEAD == NULL)
    1. return
2. end = HEAD
3. while(end->next != NULL)
    1. secEnd = end
    2. end = end->next
4. if(secEnd == NULL)
    1. HEAD = NULL
5. else
    1. secEnd->next = NULL
6. Delete end

VI. addAfterRoll(rk)
1. Get n from makeNode()
2. pos = HEAD
3. while(pos->roll != rk AND pos != NULL)
    1. pos = pos->next
4. if(pos == NULL)
    1. return
5. n->next = pos->next
6. pos->next = n

VII. deleteRoll(rk)
1. pos = HEAD
2. while(pos->roll != rk AND pos != NULL)
    1. pos = pos->next
3. if(pos == NULL)
    1. return
4. if(secPos == NULL)
    1. HEAD = pos->next
5. else
    1. secPos->next = pos->next
6. Delete pos

IX. showList()
1. n = HEAD
2. while(n != NULL)
    1. DISPLAY n->name
    2. n = n->next

X. main()
1. DISPLAY menu with options A-G
2. INPUT roll number as rk if necessary
3. Call corresponding function from addFront(), removeFront(), addEnd(), removeEnd(), addAfterRoll(rk), deleteRoll(rk), showList()