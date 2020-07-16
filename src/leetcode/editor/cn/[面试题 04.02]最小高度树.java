package leetcode.editor.cn;
//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
// 示例: 给定有序数组: [-10,-3,0,5,9], 一个可能
//的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
// 0
// / \
// -3
//  9
//  /
//  /      -10  5 Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import sun.reflect.generics.tree.Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution0402 {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root=sortedArrayToBST(nums);

        System.out.println();
        preOrderTraverse(root);

        // 二叉搜索树的中序遍历是升序序列
        System.out.println();
        midOrderTraverse(root);

        System.out.println();
        postOrderTraverse(root);
        System.out.println();
    }
    public static void midOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrderTraverse(node.left);
        System.out.printf("%4d",node.val);
        midOrderTraverse(node.right);
    }

    public static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.printf("%4d",node.val);
        midOrderTraverse(node.left);
        midOrderTraverse(node.right);
    }

    public static void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrderTraverse(node.left);
        midOrderTraverse(node.right);
        System.out.printf("%4d",node.val);
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = getMinTree(nums,0,nums.length-1);
        return root;
    }
    public static TreeNode getMinTree(int[] nums,int begin, int end) {
        if (begin>end)  {
            return null;
        }
        int mid = begin+(end-begin+1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = getMinTree(nums,begin,mid-1);
        node.right = getMinTree(nums,mid+1,end);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
