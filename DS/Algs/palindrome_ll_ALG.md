1. Declare a structure, Node with data, pointer to next and previous node.
2. Declare HEAD, TAIL as NULL.

- ## `loadString()`
    1. len = 0
    1. while(c != '\n'):
        1. Create new node, newNode
        2. For first node, set str_head = newNode
        3. newNode->data = c
        4. newNode->next = NULL
        5. newNode->prev = TAIL
        6. TAIL->next = newNode
        7. TAIL = newNode
        8. len += 1
        9. c = INPUT next charecter
    
- ## `checkPalindrome(head, tail, len)`
    1. f = head, r = tail, i = 0
    2. while(i < len/2):
        1. if(data at f != data at r): return 0
        2. f = f->next
        3. r = r->prev
        4. i += 1
    3. return 1

- ## `main`
    1. Start
    2. Call loadString()
    3. Call checkPalindrome with HEAD, TAIL, len, store return value as result
    4. if(result): DISPLAY "Palindrome"
    5. else: DISPLAY "Not Palindrome"
    6. End