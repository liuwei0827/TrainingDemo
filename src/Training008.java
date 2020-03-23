import java.util.Stack;

class Training008 {
    // 链表相关合集
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

        System.out.println(lSolution.FindNodeToTail(head, 2).value);
    }
}

class ListSolution {
    // 删除值为K的节点
    void deleteListNode(ListNode hNode, int value) {
        if (hNode == null) {
            return;
        }
        ListNode listNode = hNode;

        // 头节点（有且只有）
        if (listNode.pNextListNode == null && listNode.value == value) {
            listNode = null;
            return;
        }

        ListNode preNode = null;
        // 非头节点
        while (listNode.pNextListNode != null) {
            if (listNode.value == value) {
                doDelete(listNode);
            }
            preNode = listNode;
            listNode = listNode.pNextListNode;
        }
        if (listNode.pNextListNode == null && listNode.value == value) {
            listNode = null;
            preNode.pNextListNode = null;
        }
    }

    void doDelete(ListNode deledteNode) {
        ListNode pNext = deledteNode.pNextListNode;
        deledteNode.value = pNext.value;
        deledteNode.pNextListNode = pNext.pNextListNode;

        pNext = null;
    }

    // 从尾到头打印链表（用stack来实现）
    void printList(ListNode headListNode) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode pListNode = headListNode.pNextListNode;
        while (pListNode != null) {
            stack.push(pListNode);
            pListNode = pListNode.pNextListNode;
        }
        while (!stack.empty()) {
            System.out.print(stack.pop().value + " ");
        }
    }

    // 判断链表是否有环
    ListNode isCycle(ListNode headListNode) {
        if (headListNode == null) {
            return null;
        }
        ListNode p1 = headListNode;
        if (p1 == null) {
            return null;
        }
        ListNode p2 = p1.pNextListNode;
        while (p1 != null && p2 != null) {
            while (p1 == p2) {
                return p2;
            }
            p1 = p1.pNextListNode;
            if (p2.pNextListNode.pNextListNode) {
                p2 = p2.pNextListNode.pNextListNode;
            }
        }
        return null;
    }

    // 链表中环的入口节点
    ListNode EntryOfListNodeLoop(ListNode hListNode) {
        ListNode meetingNode = isCycle(hListNode);
        if (meetingNode == null) {
            return null;
        }
        int nodesInLoop = 1;
        ListNode pNode1 = meetingNode;
        while (pNode1.pNextListNode != meetingNode) {
            pNode1 = pNode1.pNextListNode;
            nodesInLoop++;
        }
        pNode1 = hListNode;
        for (int i = 0; i < nodesInLoop; i++) {
            pNode1 = pNode1.pNextListNode;
        }
        ListNode pNode2 = hListNode;
        while (pNode1 != pNode2) {
            pNode1 = pNode1.pNextListNode;
            pNode2 = pNode2.pNextListNode;
        }
        return pNode1;
    }

    // 反转链表
    ListNode reversListNode(ListNode pHeadListNode) {
        ListNode pReversNode = null;
        ListNode pNode = pHeadListNode;
        ListNode pPreListNode = null;
        while (pNode != null) {
            ListNode pNext = pNode.pNextListNode;
            if (pNext == null) {
                pReversNode = pNode;
            }
            pNode.pNextListNode = pReversNode;
            pReversNode = pNode;
            pNode = pNext;
        }
        return pReversNode;
    }

    // 合并两个排序的链表

    // 链表中的倒数第k个节点
    ListNode FindNodeToTail(ListNode headListNode, int k) {
        if (headListNode == null || k == 0) {
            return null;
        }
        ListNode aheadNode = headListNode;
        ListNode behindNode = headListNode;
        for (int i = 0; i < k - 1; i++) {
            if (aheadNode.pNextListNode != null) {
                aheadNode = aheadNode.pNextListNode;
            } else {
                return null;
            }
        }

        while (aheadNode.pNextListNode != null) {
            aheadNode = aheadNode.pNextListNode;
            behindNode = behindNode.pNextListNode;
        }
        return behindNode;
    }

    void insert(ListNode lasListNode, ListNode pListNode) {
        lasListNode.pNextListNode = pListNode;
        pListNode.pNextListNode = null;
    }
}

class ListNode {
    int value;
    ListNode pNextListNode;

    ListNode() {
        value = 0;
        pNextListNode = null;
    }

    ListNode(int v) {
        value = v;
    }
}