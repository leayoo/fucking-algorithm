package binarytree;

class SameTree_100 {
    boolean result = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        traverse(p, q);
        return result;
    }

    // 前序遍历比较
    void traverse(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return;
        }

        if (p == null || q == null) {
            result = false;
            return;
        }

        if (p.val != q.val) {
            result = false;
            return;
        }

        traverse(p.left, q.left);
        traverse(p.right, q.right);
    }

    // 更加优雅的写法
    public boolean isSameTree2(TreeNode p, TreeNode q){
        // 判断一对节点是否相同
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree2(p.left,q.left) && isSameTree2(p.right, q.right);
    }
}
