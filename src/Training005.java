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
        bTree.aft_order(a);
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

    // 中序递归
    void mid_order(TreeNode pNode) {
        if (pNode != null) {
            mid_order(pNode.LeftNode);
            System.out.print(pNode.value + " ");
            mid_order(pNode.RightNode);
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