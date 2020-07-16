package leetcode.editor.cn;//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import javax.smartcardio.CardNotPresentException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution110 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 由数组构建二叉树
     * @param arr 数组形式的二叉树
     * @return 返回二叉树的根节点
     */
    public static TreeNode createTreeFromArray(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }
        // 使用广度优先搜索构造一棵树
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (int i = 0; i < arr.length / 2; i++) {
            if(arr[i]!=null) {
                TreeNode node = queue.remove();
                if(2*i+1<arr.length&&arr[2*i+1]!=null) {
                   TreeNode aNode = new TreeNode(arr[2*i+1]);
                   node.left=aNode;
                   queue.add(aNode);
               }
               if(2*i+2<arr.length&&arr[2*i+2]!=null) {
                   TreeNode aNode = new TreeNode(arr[2*i+2]);
                   node.right=aNode;
                   queue.add(aNode);
               }
            }
        }
        return root;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        return Math.abs(getDepth(root.left,0)-getDepth(root.right,0))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }

    private static int getDepth(TreeNode node,int dept) {
        if (node==null){
            return 0;
        }
        int lDept = getDepth(node.left,dept+1);
        int rDept = getDepth(node.right,dept+1);
        return Math.max(lDept,rDept)+1;
    }
    public static void main(String[] args) {
       // Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        Integer[] arr = new Integer[]{1,2,2,3,3,null,null,4,4};
        TreeNode tree = createTreeFromArray(arr);
        System.out.println(isBalanced(tree));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
