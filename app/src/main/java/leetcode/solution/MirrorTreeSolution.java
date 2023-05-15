package leetcode.solution;

import leetcode.BaseSolution;
import leetcode.model.TreeNode;

import java.util.ArrayList;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 难易度：Easy
 */
public class MirrorTreeSolution extends BaseSolution<TreeNode> {
    @Override
    public TreeNode performSingleTest() {
        TreeNode result = mirrorTree(new TreeNode(114514));
        return result;
    }

    private TreeNode getTestCase1() {
        TreeNode[] treeNodes = new TreeNode[]{
                new TreeNode(4),    // 0
                new TreeNode(2),    // 1
                new TreeNode(7),    // 2
                new TreeNode(1),    // 3
                new TreeNode(3),    // 4
                new TreeNode(6),    // 5
                new TreeNode(9),    // 6
        };
        treeNodes[0].left = treeNodes[1];
        treeNodes[0].right = treeNodes[2];
        treeNodes[1].left = treeNodes[3];
        treeNodes[1].right = treeNodes[4];
        treeNodes[2].left = treeNodes[5];
        treeNodes[2].right = treeNodes[6];
        return treeNodes[0];
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<TreeNode> bfsMemo = new ArrayList<>();
        bfsMemo.add(root);
        while (!bfsMemo.isEmpty()) {
            for (TreeNode node : bfsMemo) {
                if (node.left != null && node.right != null) {
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                } else if (node.left != null) {
                    node.right = node.left;
                    node.left = null;
                } else if (node.right != null) {
                    node.left = node.right;
                    node.right = null;
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
        return root;
    }
}
