import java.util.LinkedList;
import java.util.Queue;

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
        int data[] = { 4, 6, 12, 8, 16, 14, 10 };

        BTsolution bTsolution = new BTsolution();
        // bTsolution.printBinaryTreeFromTopToButton(a);

        System.out.println(bTsolution.VerifySquenceOfBST(data, 0, data.length - 1));
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

    // 二叉树中和为某一值的路径

    // 序列化二叉树

    // 二叉搜索树的第K大节点
}
