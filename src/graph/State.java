package graph;

import binarytree.TreeNode;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 23:18
 */
public class State {
    int depth;
    TreeNode node;

    State(TreeNode node, int depth){
        this.depth = depth;
        this.node = node;
    }
}

