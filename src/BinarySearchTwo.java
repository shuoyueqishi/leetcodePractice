import leetcode.editor.cn.TreeNode;

import java.util.*;

public class BinarySearchTwo {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Stack<List<Integer>> stack = new Stack<>();
        levelLists.forEach(item->{
            stack.push(item);
        });
        levelLists.clear();
        while (!stack.isEmpty()) {
            levelLists.add(stack.pop());
        }
        return levelLists;
    }

}
