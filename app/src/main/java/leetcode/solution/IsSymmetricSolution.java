package leetcode.solution;

import leetcode.BaseSolution;
import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 难易度：Easy
 */
public class IsSymmetricSolution extends BaseSolution<Boolean> {
    private TreeNode getTestCase1() {
        TreeNode[] nodes = new TreeNode[]{
                new TreeNode(1),
                new TreeNode(2),
                new TreeNode(2),
                new TreeNode(3),
                new TreeNode(4),
                new TreeNode(4),
                new TreeNode(3)
        };
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];
        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];
        return nodes[0];
    }

    private TreeNode getTestCase2() {
        TreeNode[] nodes = new TreeNode[]{
                new TreeNode(1),
                new TreeNode(2),
                new TreeNode(2),
                new TreeNode(3),
                new TreeNode(3),
        };
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[1].right = nodes[3];
        nodes[2].right = nodes[4];
        return nodes[0];
    }

    @Override
    public Boolean performSingleTest() {
        return isSymmetric(null);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> resultBefore = getBfsResult(root);
        ArrayList<TreeNode> bfsMemo = new ArrayList<>();
        bfsMemo.add(root);
        while (!bfsMemo.isEmpty()) {
            for (TreeNode node : bfsMemo) {
                if (node.left != null && node.right != null) {
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                } else if (node.left == null && node.right != null) {
                    node.left = node.right;
                    node.right = null;
                } else if (node.right == null && node.left != null) {
                    node.right = node.left;
                    node.left = null;
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
        }
        List<Integer> resultAfter = getBfsResult(root);
        return resultBefore.equals(resultAfter);
    }

    private List<Integer> getBfsResult(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> bfsMemo = new ArrayList<>();
        if (root == null) {
            return result;
        }
        bfsMemo.add(root);
        while (!isAllNull(bfsMemo)) {
            ArrayList<TreeNode> newMemo = new ArrayList<>();
            for (TreeNode node : bfsMemo) {
                result.add(node == null ? null : node.val);
                if (node != null) {
                    newMemo.add(node.left);
                    newMemo.add(node.right);
                }
            }
            bfsMemo.clear();
            bfsMemo.addAll(newMemo);
        }
        return result;
    }

    private boolean isAllNull(List<TreeNode> nodes) {
        for (TreeNode node : nodes) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }
}
