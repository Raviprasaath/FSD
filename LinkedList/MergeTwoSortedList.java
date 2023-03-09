package LinkedList;

class LinkList{
    Node head;

    public class Node{
        int value;
        Node next;
    
        Node(){}
        Node (int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public void add(int index) {
        Node newNode = new Node(index);
        Node temp = head;
        if (temp == null) {
            newNode.next = null;
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public Node merge(Node list1, Node list2) {
        Node temp = new Node(0);
        Node current = temp;
        
        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        
        if (list1 ==  null) {
            temp.next = list2;
        } else if (list2 == null) {
            temp.next = list1;
        }
        return current.next;
    }
}

public class MergeTwoSortedList {
    public static void main(String[] args) {
        LinkList list1 = new LinkList();
        LinkList list2 = new LinkList();
        list1.add(15);
        list1.add(10);
        list1.add(12);
        list1.add(5);
        list1.add(1);
        list1.display();
        System.out.println();
        list2.add(11);
        list2.add(9);
        list2.add(4);
        list2.add(2);
        list2.add(1);
        list2.display(); 
        System.out.println();
        list1.head = new LinkList().merge(list1.head, list2.head);
        list1.display();  
    }
}