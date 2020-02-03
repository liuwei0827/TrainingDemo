class Training014 {
    public static void main(String[] args) {
        System.out.println();
        //       1
        //     2    3
        //    4   5   6
        //      7    8
        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
        Tree2 t = new Tree2();
        TreeNode treeNode = t.Construct(pre, in, pre.length);
        BinaryTree bTree = new BinaryTree();
        bTree.aft_order(treeNode);
    }
}

class Tree2 {
    // 根据前序和中序重建二叉树
    TreeNode Construct(int[] pre, int[] in, int length) {
        if (pre == null || in == null) {
            return null;
        }
        TreeNode root = rebuildBinaryTreeCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    // 构建二叉树的核心算法
    public TreeNode rebuildBinaryTreeCore(int preorder[], int startPreorder, int endPreorder, int inorder[],
            int startInorder, int endInorder) {
        if (startPreorder > endPreorder || startInorder > endInorder) { // 停止递归的条件
            return null;
        }
        TreeNode root = new TreeNode(preorder[startPreorder], null, null);
        for (int i = startInorder; i <= endInorder; i++) {
            if (preorder[startPreorder] == inorder[i]) {
                // 其中（i - startInorder）为中序排序中左子树结点的个数
                // 左子树
                root.LeftNode = rebuildBinaryTreeCore(preorder, startPreorder + 1, startPreorder + (i - startInorder),
                        inorder, startInorder, i - 1);
                // 右子树
                root.RightNode = rebuildBinaryTreeCore(preorder, (i - startInorder) + startPreorder + 1, endPreorder,
                        inorder, i + 1, endInorder);
            }
        }
        return root;
    }
}