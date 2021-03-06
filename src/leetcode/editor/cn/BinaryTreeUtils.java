package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeUtils {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode root = createTreeFromArray(nums);
        levelTraverse(root);
        System.out.println();
        preOrderTraverse(root);
        System.out.println();
        midOrderTraverse(root);
        System.out.println();
        postOrderTraverse(root);
        System.out.println();
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists.toString());
    }

    /**
     * 由数组构建二叉树
     *
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelLists = new ArrayList<>();
        // 为空的时候直接返回
        if (root == null) {
            return levelLists;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        // 先把根节点放入
        queue.add(root);
        while (!queue.isEmpty()) {
            // 每一层的节点总数
            int levelNodeNums = queue.size();
            List<Integer> level = new ArrayList<>();
            // 根据该层的节点总数进行遍历
            for (int i = 0; i < levelNodeNums; i++) {
                // 出队列
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levelLists.add(level);
        }
        return levelLists;
    }

    public static void levelTraverse(TreeNode node) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode pollNode = queue.poll();
            System.out.printf("%4d", pollNode.val);
            if (pollNode.left != null) {
                queue.add(pollNode.left);
            }
            if (pollNode.right != null) {
                queue.add(pollNode.right);
            }
        }
    }

    public static void midOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrderTraverse(node.left);
        System.out.printf("%4d", node.val);
        midOrderTraverse(node.right);
    }

    public static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.printf("%4d", node.val);
        midOrderTraverse(node.left);
        midOrderTraverse(node.right);
    }

    public static void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrderTraverse(node.left);
        midOrderTraverse(node.right);
        System.out.printf("%4d", node.val);
    }
}