package leetcode.solution;

import leetcode.BaseSolution;
import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 难易度：Medium
 */
public class LevelOrderSolution extends BaseSolution<int[]> {
    @Override
    public int[] performSingleTest() {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(-1);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(6);
        TreeNode node9 = new TreeNode(8);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        node5.right = node9;
        return levelOrder(node0);
    }
    
    private static final int MAX_LENGTH = 2000;
    
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        int[] result = new int[MAX_LENGTH];
        int resultLength = 0;
        ArrayList<TreeNode> bfsMemo = new ArrayList<>();
        bfsMemo.add(root);
        while (!bfsMemo.isEmpty()) {
            ArrayList<TreeNode> newMemo = new ArrayList<>();
            for (TreeNode node : bfsMemo) {
                result[resultLength++] = node.val;
                if (node.left != null) {
                    newMemo.add(node.left);
                }
                if (node.right != null) {
                    newMemo.add(node.right);
                }
            }
            bfsMemo.clear();
            bfsMemo.addAll(newMemo);
        }
        return Arrays.copyOf(result, resultLength);
    }
}