import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Training005 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        TreeNode d = new TreeNode(4, null, null);
        TreeNode e = new TreeNode(5, null, null);
        TreeNode f = new TreeNode(6, null, null);
        TreeNode b = new TreeNode(2, null, d);
        TreeNode c = new TreeNode(3, e, f);
        TreeNode a = new TreeNode(1, b, c);

        BinaryTree bTree = new BinaryTree();
        bTree.width_order(a);
    }
}

class BinaryTree {
    // 前序递归
    void pre_order(TreeNode pNode) {
        if (pNode != null) {
            System.out.print(pNode.value + " ");
            pre_order(pNode.LeftNode);
            pre_order(pNode.RightNode);
        }
    }

    // 前序非递归
    void pre_order2(TreeNode pNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = pNode;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.value + " ");
                stack.push(treeNode);
                treeNode = treeNode.LeftNode;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.RightNode;
            }
        }
    }

    // 中序递归
    void mid_order(TreeNode pNode) {
        if (pNode != null) {
            mid_order(pNode.LeftNode);
            System.out.print(pNode.value + " ");
            mid_order(pNode.RightNode);
        }
    }

    // 中序非递归
    void mid_order2(TreeNode pNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = pNode;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.LeftNode;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.value + " ");
                treeNode = treeNode.RightNode;
            }
        }
    }

    // 后序递归
    void aft_order(TreeNode pNode) {
        if (pNode != null) {
            aft_order(pNode.LeftNode);
            aft_order(pNode.RightNode);
            System.out.print(pNode.value + " ");
        }
    }

    // 后序非递归TODO

    // 广度遍历TODO
    void width_order(TreeNode pNode) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if (node.LeftNode != null) {
                queue.offer(node.LeftNode);
            }
            if (node.RightNode != null) {
                queue.offer(node.RightNode);
            }
        }
    }
}

class TreeNode {
    int value = 0;
    TreeNode LeftNode;
    TreeNode RightNode;

    TreeNode(int v, TreeNode left, TreeNode right) {
        this.value = v;
        this.LeftNode = left;
        this.RightNode = right;
    }

}