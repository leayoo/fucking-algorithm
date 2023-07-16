package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraverse {
    // 双栈写法
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> res = new Stack<>(); // 保存节点序列的栈
        TreeNode cur = root;
        while(cur!=null || !s.isEmpty()) {
            while(cur!=null) {
                res.push(cur.val);
                s.push(cur);
                cur = cur.right; // 修改处
            }
            if(!s.isEmpty()) {
                cur = s.pop();
                cur = cur.left; // 修改处
            }

        }
        while(!res.isEmpty()) ans.add(res.pop()); // 获取倒序的根右左序列
        return ans;
    }
}
