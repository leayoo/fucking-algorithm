package graph;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 15:53
 */
public class UF {
    // 记录连通分量
    private int count;
    // 节点 x 的父节点是 parent[x]
    private int[] parent;

    // 一个数组记录树的「重量」
    private int[] size;

    // 构造函数， n 为图的节点总数
    public UF(int n){
        // 一开始互不连通
        this.count = n;
        // 父节点指针初始指向自己
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 如果某两个节点被连通，则让其中的（任意）一个节点的根节点
    // 接到另一个节点的根节点上
    // 将 p 和 q 连接
    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ){
            return;
        }
        // 将两棵树合并为一颗
//        parent[rootP] = rootQ;
        // 小树接到大树下面，比较平衡
        if (size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        // 两个分量合二为一
        count--;
    }

    // 返回某个节点 x 的根节点
    private int find(int x){
        // 根节点的 parent[x] == x
        // 路径压缩写法1
//        while (parent[x] != x){
//            // 这行代码进行路径压缩
//            parent[x] = parent[parent[x]];
//            x = parent[x];
//        }
//        return x;
        // 路径压缩写法2
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }


    // 返回图中有多少个连通分量
    public int count(){
        return count;
    }

    // 判断 p 和 q 是否连通
    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }



}
