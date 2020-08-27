package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeMirror {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{4,2,7,1,3,6,9};
        TreeNode root = BinaryTreeUtils.createTreeFromArray(nums);
        TreeNode tree = mirrorTree(root);
        BinaryTreeUtils.levelTraverse(tree);
        System.out.println();

        TreeNode root1 = BinaryTreeUtils.createTreeFromArray(nums);
        TreeNode tree1 = mirrorTreeDfs(root1);
        BinaryTreeUtils.levelTraverse(tree1);
        System.out.println();
    }

    /**
     * 使用BFS
     * @param root 根节点
     * @return 返回新的树
     */
    public static TreeNode mirrorTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode node  = root;
        if(root!=null) {
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            int levelNums = queue.size();
            for(int i=0;i<levelNums;i++) {
                TreeNode pollNode = queue.poll();
                // 交换左右节点的位置
                TreeNode tmp = pollNode.left;
                pollNode.left=pollNode.right;
                pollNode.right=tmp;
                if (pollNode.right != null) {
                    queue.add(pollNode.right);
                }
                if (pollNode.left != null) {
                    queue.add(pollNode.left);
                }
            }
        }
        return node;
    }

    public static TreeNode mirrorTreeDfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTreeDfs(root.right);
        root.right = mirrorTreeDfs(tmp);
        return root;
    }
}
