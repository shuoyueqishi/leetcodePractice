package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *  
 *
 * 提示：
 *
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IncrementBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,3,6,2,4,null,8,1,null,null,null,7,9};
        TreeNode root=createTreeFromArray(arr);
        TreeNode newRoot =increasingBST(root);
    }

    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getArrDfs(root,list);
        Integer[] nums = new Integer[list.size()];
        for (int i=0;i<list.size();i++) {
            nums[i]=list.get(i);
        }
        return createTreeFromArray(nums);

    }
    public static TreeNode createTreeFromArray(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }
        // 使用广度优先搜索构造一棵树
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != null) {
                TreeNode node = queue.remove();
                if (2 * i + 1 < arr.length && arr[2 * i + 1] != null) {
                    TreeNode aNode = new TreeNode(arr[2 * i + 1]);
                    node.left = aNode;
                    queue.add(aNode);
                }
                if (2 * i + 2 < arr.length && arr[2 * i + 2] != null) {
                    TreeNode aNode = new TreeNode(arr[2 * i + 2]);
                    node.right = aNode;
                    queue.add(aNode);
                }
            }
        }
        return root;
    }
    private static void getArrDfs(TreeNode node, List<Integer> list) {
        if(node==null) {
            return;
        }
        getArrDfs(node.left,list);
        list.add(node.val);
        list.add(null);
        getArrDfs(node.right,list);
    }
}
