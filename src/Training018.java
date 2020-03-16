class Training018 {
    // 二叉树合集
    public static void main(String[] args) {
        TreeNode d = new TreeNode(4, null, null);
        TreeNode e = new TreeNode(5, null, null);
        TreeNode f = new TreeNode(6, null, null);
        TreeNode g = new TreeNode(7, null, null);
        TreeNode b = new TreeNode(2, d, e);
        TreeNode c = new TreeNode(3, f, g);
        TreeNode a = new TreeNode(1, b, c);

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.pre_order(a);
        System.out.println("\n");
        BTsolution bTsolution=new BTsolution();
        bTsolution.BTSMirror(a);
        binaryTree.pre_order(a);

        System.out.println("\n");
        System.out.println("Hello World!");
    }
}

class BTsolution {
    // 二叉树镜像
    void BTSMirror(TreeNode rTree) {
        if (rTree == null) {
            return;
        }
        TreeNode tmpBinaryTree = rTree.LeftNode;
        rTree.LeftNode = rTree.RightNode;
        rTree.RightNode = tmpBinaryTree;

        if (rTree.LeftNode != null) {
            BTSMirror(rTree.LeftNode);
        }
        if (rTree.RightNode != null) {
            BTSMirror(rTree.RightNode);
        }
    }

    // 对称二叉树

    // 从上到下打印二叉树

    // 二叉搜索树的后序遍历序列

    // 二叉树中和为某一值的路径

    // 序列化二叉树

    // 二叉搜索树的第K大节点
}
