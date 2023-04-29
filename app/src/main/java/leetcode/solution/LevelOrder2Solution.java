package leetcode.solution;

import leetcode.BaseSolution;
import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 难易度：Easy
 */
public class LevelOrder2Solution extends BaseSolution<List<List<Integer>>> {
    @Override
    public List<List<Integer>> performSingleTest() {
//        TreeNode node0 = new TreeNode(3);
//        TreeNode node1 = new TreeNode(9);
//        TreeNode node2 = new TreeNode(20);
//        TreeNode node3 = new TreeNode(15);
//        TreeNode node4 = new TreeNode(7);
//        node0.left = node1;
//        node0.right = node2;
//        node1.left = node3;
//        node1.right = node4;
        return levelOrder(null);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<TreeNode> bfsMemo = new ArrayList<>();
        bfsMemo.add(root);
        ArrayList<List<Integer>> result = new ArrayList<>();
        while (!bfsMemo.isEmpty()) {
            ArrayList<Integer> layerResult = new ArrayList<>();
            ArrayList<TreeNode> newMemo = new ArrayList<>();
            for (TreeNode node : bfsMemo) {
                layerResult.add(node.val);
                if (node.left != null) {
                    newMemo.add(node.left);
                }
                if (node.right != null) {
                    newMemo.add(node.right);
                }
            }
            result.add(layerResult);
            bfsMemo.clear();
            bfsMemo.addAll(newMemo);
        }
        return result;
    }
}