class Training009 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        ListNode head1 = new ListNode();
        ListSolution lSolution = new ListSolution();
        ListNode a = new ListNode(1);
        lSolution.insert(head1, a);
        ListNode b = new ListNode(2);
        lSolution.insert(a, b);
        ListNode c = new ListNode(3);
        lSolution.insert(b, c);
        ListNode d = new ListNode(4);
        lSolution.insert(c, d);
        ListNode e = new ListNode(5);
        lSolution.insert(d, e);
        ListNode head2 = new ListNode();
        ListNode f = new ListNode(6);
        lSolution.insert(head2, f);
        lSolution.insert(f, c);

        CommonNode commonNode= new CommonNode();
        System.out.println(commonNode.FindNode(head1, head2).value);
    }
}

// 链表相关集合二
class CommonNode {
    // 两个链表的公共节点
    ListNode FindNode(ListNode pListNode1, ListNode pListNode2) {
        int nLenght1 = GetListLength(pListNode1);
        int nLenght2 = GetListLength(pListNode2);
        int dif = 0;
        ListNode pLong;
        ListNode pShort;
        if (nLenght2 > nLenght1) {
            pLong = pListNode2;
            pShort = pListNode1;
            dif = nLenght2 - nLenght1;
        } else {
            pLong = pListNode1;
            pShort = pListNode2;
            dif = nLenght1 - nLenght2;
        }
        for (int i = 0; i < dif; i++) {
            pLong = pLong.pNextListNode;
        }

        while(pLong!=pShort){
            pLong = pLong.pNextListNode;
            pShort = pShort.pNextListNode;            
        }
        
        return pLong;
    }

    int GetListLength(ListNode pHead) {
        int nLenght = 0;
        ListNode p = pHead;
        while (p != null) {
            nLenght++;
            p = p.pNextListNode;
        }
        return nLenght;
    }
}