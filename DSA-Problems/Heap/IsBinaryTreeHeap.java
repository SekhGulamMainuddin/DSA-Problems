
// https://practice.geeksforgeeks.org/problems/is-binary-tree-heap/1

class Solution {
    static class Node {
        int data;
        Node left, right;
        Node(int val) { this.data = val; }
    }

    private int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private boolean isCBT(Node root, int index, int nodeCount) {
        if (root == null) return true;
        if (index >= nodeCount) return false;

        return isCBT(root.left, 2 * index + 1, nodeCount) &&
               isCBT(root.right, 2 * index + 2, nodeCount);
    }

    private boolean isMaxHeap(Node root) {
        if (root.left == null && root.right == null) return true;

        if (root.right == null) return root.data >= root.left.data;

        return (root.data >= root.left.data && root.data >= root.right.data) &&
               isMaxHeap(root.left) && isMaxHeap(root.right);
    }

    public boolean isHeap(Node root) {
        int count = countNodes(root);
        return isCBT(root, 0, count) && isMaxHeap(root);
    }
}