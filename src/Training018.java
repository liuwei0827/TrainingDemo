import java.util.LinkedList;
import java.util.Queue;

class Training018 {
    public static void main(String[] args) {
        TreeNode d = new TreeNode(4, null, null);
        TreeNode e = new TreeNode(5, null, null);
        TreeNode f = new TreeNode(6, null, null);
        TreeNode g = new TreeNode(7, null, null);
        TreeNode b = new TreeNode(2, d, e);
        TreeNode c = new TreeNode(3, f, g);
        TreeNode a = new TreeNode(1, b, c);
        int data[] = { 4, 6, 12, 8, 16, 14, 10 };

        BTsolution bTsolution = new BTsolution();
        // bTsolution.printBinaryTreeFromTopToButton(a);

        System.out.println(bTsolution.VerifySquenceOfBST(data, 0, data.length - 1));
        System.out.println("\n");
        System.out.println("Hello World!");
    }
}

// 二叉树相关合集二
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
    Boolean isSymmetrical(TreeNode rNode) {
        return isSymmetrical(rNode, rNode);
    }

    Boolean isSymmetrical(TreeNode pNode1, TreeNode pNode2) {
        if (pRoot1 == null && pRoot2 == null)
            return true;

        if (pRoot1 == null || pRoot2 == null)
            return false;

        if (pRoot1.value != pRoot2.value)
            return false;

        return isSymmetrical(pRoot1.LeftNode, pRoot2.RightNode) && isSymmetrical(pRoot1.RightNode, pRoot2.LeftNode);
    }

    // 从上到下打印二叉树
    void printBinaryTreeFromTopToButton(TreeNode rTree) {
        if (rTree == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(rTree);

        while (queue.size() > 0) {
            TreeNode tmpBinaryTree = queue.poll();
            System.out.print(tmpBinaryTree.value);

            if (tmpBinaryTree.LeftNode != null) {
                queue.offer(tmpBinaryTree.LeftNode);
            }
            if (tmpBinaryTree.RightNode != null) {
                queue.offer(tmpBinaryTree.RightNode);
            }
        }
    }

    // 二叉搜索树的后序遍历序列
    boolean VerifySquenceOfBST(int[] data, int start, int end) {
        int root = data[end];
        int leftEnd = start;
        for (int i = start; i < end; i++) {
            if (data[i] > root) {
                break;
            }
            leftEnd = i;
        }
        int rightStart = leftEnd + 1;
        for (int i = rightStart; i < end; i++) {
            if (data[i] < root) {
                return false;
            }
        }
        boolean left = true;
        if (leftEnd > start) {
            left = VerifySquenceOfBST(data, start, leftEnd);
        }
        boolean right = true;
        if (rightStart < end) {
            right = VerifySquenceOfBST(data, rightStart, end - 1);
        }

        return left && right;
    }

    // 根据前序和中序重建二叉树
    TreeNode Construct(int[] pre, int[] in, int length) {
        if (pre == null || in == null) {
            return null;
        }
        TreeNode root = rebuildBinaryTreeCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    // 构建二叉树
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

    // 二叉树中和为某一值的路径

    // 序列化二叉树

    // 二叉搜索树的第K大节点
}
