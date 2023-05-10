package leetcode.solution;

import leetcode.BaseSolution;
import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 难易度：Medium
 */
public class LevelOrder3Solution extends BaseSolution<List<List<Integer>>> {
    @Override
    public List<List<Integer>> performSingleTest() {
        TreeNode node0 = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        return levelOrder(node0);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<TreeNode> bfsMemo = new ArrayList<>();
        bfsMemo.add(root);
        int layerCount = 0;
        while (!bfsMemo.isEmpty()) {
            ArrayList<Integer> subResult = new ArrayList<>();
            if (layerCount % 2 == 0) {
                for (int i = 0; i < bfsMemo.size(); i++) {
                    subResult.add(bfsMemo.get(i).val);
                }
            } else {
                for (int i = bfsMemo.size() - 1; i >= 0; i--) {
                    subResult.add(bfsMemo.get(i).val);
                }
            }
            ArrayList<TreeNode> newMemo = new ArrayList<>();
            for (TreeNode node : bfsMemo) {
                if (node.left != null) {
                    newMemo.add(node.left);
                }
                if (node.right != null) {
                    newMemo.add(node.right);
                }
            }
            bfsMemo.clear();
            bfsMemo.addAll(newMemo);
            layerCount++;
            result.add(subResult);
        }
        return result;
    }
}
