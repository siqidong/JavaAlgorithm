/*
Realize a linked list using Node
*/
class MyLinkedList {
    class Node {
        int val;
        Node next;

        public Node (int val) {
            this.val = val;
            this.next = null;
        }
        
        public Node (int val, Node node) {
            this.val = val;
            this.next = node;
        }
    }

    /** Initialize your data structure here. */
    Node head;
    Node tail;
    public MyLinkedList() {
        this.head = new Node(0);
        this.tail = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int i = 0;
        Node temp = head.next;
        while(i<index && temp!=null) {
            i++;
            temp = temp.next;
        }
        if(temp==null) {
            return -1;
        }
        return temp.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newhead = new Node(val);
        Node next = head.next;
        newhead.next = next;
        head.next = newhead;
        if(newhead.next==null) {
            tail = newhead;
        }
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newtail = new Node(val);
        tail.next = newtail;
        tail = newtail;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int i = 0;
        Node temp = head;
        while(i<index && temp!=null) {
            i++;
            temp = temp.next;
        }
        if(temp!=null) {
            Node newnode = new Node(val);
            newnode.next = temp.next;
            temp.next = newnode;
            if(newnode.next==null) {
                tail = newnode;
            }
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int i = 0;
        Node temp = head;
        while(i<index && temp!=null) {
            i++;
            temp = temp.next;
        }
        if(temp==null || temp.next==null) {
            return;
        }
        if(temp.next.next==null) {
            temp.next = null;
            tail = temp;
            return;
        } else {
            temp.next = temp.next.next;
        }
        
    }
}
