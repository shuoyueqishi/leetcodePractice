package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MirrorBinaryTree {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,2,2,null,2};
        TreeNode root = BinaryTreeUtils.createTreeFromArray(nums);
        BinaryTreeUtils.preOrderTraverse(root);
        System.out.println();
        BinaryTreeUtils.midOrderTraverse(root);
        System.out.println();
        BinaryTreeUtils.postOrderTraverse(root);
        System.out.println();
        boolean res = isSymmetric(root);
        System.out.println(res);
        boolean res2=isSymmetrical2(root);
        System.out.println(res2);
    }
    public static boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        return isSymmetricalTwo(root.left,root.right);
    }

    private static boolean isSymmetricalTwo(TreeNode node1,TreeNode node2) {
        if (node1==null && node2== null) {
            return true;
        }
        if (node1==null || node2==null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSymmetricalTwo(node1.left,node2.right)&&isSymmetricalTwo(node1.right,node2.left);
    }

    public static boolean isSymmetrical2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midTraverse(root,list,0);
        /*int l=0;
        int r=list.size()-1;
        while (l<=r) {
            if (list.get(l).equals(list.get(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return l>r;*/
        List<Integer> list2 = new ArrayList<>();
        midTraverse(root,list2,0);
        for (int i=0;i<list.size();i++) {
            if (!list.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static void midTraverse(TreeNode node, List<Integer> list, int flag) {
        if (node== null) {
            return;
        }
        if (flag==0) {
            midTraverse(node.left,list,0);
            list.add(node.val);
            midTraverse(node.right,list,0);
        } else {
            midTraverse(node.right,list,1);
            list.add(node.val);
            midTraverse(node.left,list,1);
        }

    }
}
