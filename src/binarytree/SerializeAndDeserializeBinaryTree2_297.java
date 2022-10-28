package binarytree;

import java.util.LinkedList;

// 后序遍历
public class SerializeAndDeserializeBinaryTree2_297 {
    String NULL = "#";
    String SEP = ",";
    /* 主函数，将二叉树序列化为字符串 */
    String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /* 辅助函数，将二叉树存入 StringBuilder */
    void serialize(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append(NULL).append(SEP);
            return;
        }

        serialize(root.left,sb);
        serialize(root.right,sb);
        sb.append(root.val).append(SEP);
    }

    /* 主函数，将字符串反序列化为二叉树结构 */
    TreeNode deserialize(String data){
        LinkedList<String> nodes = new LinkedList<>();
        for(String s: data.split(SEP)){
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        // 从后往前去除元素
        String last = nodes.removeLast();
        if (last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));
        // 先构造右子树，后构造左子树
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);

        return root;
    }
}
