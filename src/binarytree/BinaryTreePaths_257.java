package binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class BinaryTreePaths_257 {
    LinkedList<String> result = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root);
        return result;
    }
    // 遍历二叉树
    void traverse(TreeNode root){
        if (root == null) return ;
        path.addLast(root.val+"");
        // 如果为叶子节点，则返回路径
        if (root.left == null && root.right == null){
            result.add(String.join("->", path));
            path.removeLast();
            return;
        }
        traverse(root.left);
        traverse(root.right);
        path.removeLast();
    }
}
