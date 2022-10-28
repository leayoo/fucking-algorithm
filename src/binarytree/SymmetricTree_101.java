package binarytree;

import com.sun.source.tree.Tree;
import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SymmetricTree_101 {
    // 本题应该不能用分解思想，所以采用递归考虑
    // 解题思路，镜像意味着，这颗树的左子树和右子树的遍历互为倒序。
    // 或者直接遍历的时候比较
    // 左子树先走左边，后走右边，右子树先走右边，后走左边
    List<Integer> resultLeft = new LinkedList<>();
    List<Integer> resultRight = new LinkedList<>();

    public boolean isSymmetric(TreeNode root) {
        traverseLeft(root.left);
        traverseRight(root.right);
        if (resultLeft.size() == resultRight.size()) {
            for (int i = 0; i < resultLeft.size(); i++) {
                if (resultLeft.get(i) == resultRight.get(i)) {
                    continue;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    // 遍历左子树
    void traverseLeft(TreeNode root) {
        if (root == null) {
            resultLeft.add(null);
            return;
        }
        resultLeft.add(root.val);
        traverseLeft(root.left);
        traverseLeft(root.right);
    }

    // 遍历右子树
    void traverseRight(TreeNode root) {
        if (root == null) {
            resultRight.add(null);
            return;
        }
        resultRight.add(root.val);
        traverseRight(root.right);
        traverseRight(root.left);
    }

    // 更优雅的解法
    // 下面用的还是递归方法
    // 如果用迭代的方法，可以使用 BFS 层序遍历，把每一层的节点求出来，
    // 然后用左右双指针判断每一层是否是对称的。
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        // 检查两棵树是否对称
        return check(root.left, root.right);
    }

    boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        // 两个根节点需要相同
        if (left.val != right.val)
            return false;
        return check(left.right, right.left) && check(left.left, right.right);
    }

}
