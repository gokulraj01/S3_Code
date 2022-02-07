1. Declare a structure, Node with data and pointer to next node
2. Initialize FRONT and REAR as null

- ## `isEmpty()`
    1. if(FRONT == REAR == NULL): return 1
    2. else: return 0

- ## `enqueue(ele)`
    1. Create new node, newNode
    2. if(isEmpty()): FRONT = newNode
    3. else: REAR->next = newNode
    4. newNode->next = NULL
    5. newNode->data = ele
    6. REAR = newNode

- ## `dequeue()`
    1. temp_n = FRONT
    2. temp = temp_n->data
    3. FRONT = temp_n->next
    4. if(FRONT == NULL): REAR = NULL
    5. Delete temp_n
    6. return temp

- ## `showQueue()`
    1. if(isEmpty()): DISPLAY "Queue Empty"
    2. else:
        1. p = FRONT
        2. while(p != NULL): DISPLAY p->data

- ## `main`
    1. Start
    2. DISPLAY menu with Enqueue, Dequeue, Display and Exit
    3. if(exit): return
    4. else if(Enqueue):
        1. INPUT element to enqueue, e
        2. Call enqueue with e
    5. else if(Dequeue):
        1. if(isEmpty()): DISPLAY "Queue Empty"
        2. else: Call dequeue and DISPLAY result
    6. else if(Display):
        1. Call showQueue()
    7. End


