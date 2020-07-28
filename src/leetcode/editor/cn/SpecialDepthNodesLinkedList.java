package leetcode.editor.cn;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,2,3,4,5,null,7,8]
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 * <p>
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import org.w3c.dom.NodeList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SpecialDepthNodesLinkedList {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, null, 7, 8};
        TreeNode root = BinaryTreeUtils.createTreeFromArray(nums);
        List<List<Integer>> lists = BinaryTreeUtils.levelOrder(root);
        ListNode[] listNodes = listOfDepth(root);
    }

    public static ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> resList = new ArrayList<>();
        if (tree == null) {
            return new ListNode[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int levelNodeNums = queue.size();
            ListNode levelNodeLists = null;
            ListNode curNode = null;
            for (int i = 0; i < levelNodeNums; i++) {
                TreeNode pollNode = queue.poll();
                if (levelNodeLists == null) {
                    levelNodeLists = new ListNode(pollNode.val);
                    curNode=levelNodeLists;
                } else {
                    ListNode newNode =  new ListNode(pollNode.val);
                    curNode.next = newNode;
                    curNode = newNode;
                }
                if (pollNode.left != null) {
                    queue.add(pollNode.left);
                }
                if (pollNode.right != null) {
                    queue.add(pollNode.right);
                }
            }
            resList.add(levelNodeLists);
        }
        ListNode[] resArr = new ListNode[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }
}
