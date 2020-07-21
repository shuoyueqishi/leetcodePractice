package leetcode.editor.cn;
//给定一个 N 叉树，找到其最大深度。
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 我们应返回其最大深度，3。
//
// 说明:
//
//
// 树的深度不会超过 1000。
// 树的节点总不会超过 5000。
// Related Topics 树 深度优先搜索 广度优先搜索


import com.sun.xml.internal.ws.encoding.MtomCodec;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution559 {

    /**
     * 深度优先搜索
     *
     * @param root 根节点
     * @return 返回高度
     */
    public int maxDepthDfs(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            // 递归每个孩子的高度
            int height = maxDepthDfs(child);
            max = Math.max(height, max);
        }
        // 当递归到最下层时，该层的高度为1
        return max + 1;
    }

    public int maxDepthBfs(Node root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            height++;
            int levelNodeNums = queue.size();
            for (int i = 0; i < levelNodeNums; i++) {
                Node pollNode = queue.poll();
                if (pollNode.children != null) {
                    pollNode.children.forEach(item -> {
                        queue.add(item);
                    });
                }
            }
        }
        return height;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
