import java.util.Stack;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

class Training008 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        ListNode head = new ListNode();
        ListSolution lSolution = new ListSolution();
        ListNode a = new ListNode(1);
        lSolution.insert(head, a);
        ListNode b = new ListNode(2);
        lSolution.insert(a, b);
        ListNode c = new ListNode(3);
        lSolution.insert(b, c);
        ListNode d = new ListNode(4);
        lSolution.insert(c, d);
        ListNode e = new ListNode(5);
        lSolution.insert(d, e);

        lSolution.printList(head);
    }
}

class ListSolution{
    // 从尾到头打印链表（用stack来实现）
    void printList(ListNode headListNode){
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode pListNode =headListNode.pNextListNode;
        while(pListNode!=null){
            stack.push(pListNode);
            pListNode=pListNode.pNextListNode;
        }
        while(!stack.empty()){
            System.out.print(stack.pop().value+" ");
        }
    }

    void insert(ListNode lasListNode,ListNode pListNode){
        lasListNode.pNextListNode=pListNode;
        pListNode.pNextListNode=null;
    }
}

class ListNode {
    int value;
    ListNode pNextListNode;

    ListNode(){
        value = 0;
        pNextListNode = null;
    }

    ListNode(int v) {
        value = v;
    }
}