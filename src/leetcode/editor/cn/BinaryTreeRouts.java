package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeRouts {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,null,5};
        TreeNode tree = BinaryTreeUtils.createTreeFromArray(nums);
        BinaryTreeUtils.postOrderTraverse(tree);
        System.out.println();
        BinaryTreeUtils.midOrderTraverse(tree);
        System.out.println();
        BinaryTreeUtils.postOrderTraverse(tree);
        System.out.println();
        List<String> routs = binaryTreePaths(tree);
        System.out.println(routs);
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> routs = new ArrayList<>();
        if (root==null) {
            return routs;
        }
        List<Integer> path = new ArrayList<>();
        CalRouteDfs(root,path,routs);
        return routs;
    }

    /**
     * 使用DFS计算路径
     * @param node 当前节点
     * @param path 路径点list
     * @param routs 结果路径
     */
    private static void CalRouteDfs(TreeNode node, List<Integer> path, List<String> routs) {
        if (node != null) {
            path.add(node.val);
            // 当前节点是叶子节点
            if (node.left==null && node.right==null) {
                StringBuilder sb = new StringBuilder();
                for (int i=0;i<path.size();i++) {
                    sb.append(path.get(i));
                    if (i!=path.size()-1){
                        sb.append("->");
                    }
                }
                routs.add(sb.toString());
                // 该叶子节点已经使用，不会再往下递归，需要移除掉
                path.remove(path.size()-1);
            } else { // 当前节点不是叶子节点
                CalRouteDfs(node.left, path, routs);
                CalRouteDfs(node.right, path, routs);
                // 左右子节点都遍历完成之后，要返回到上一层节点，需要移除该节点
                path.remove(path.size()-1);
            }
        }
    }
}
