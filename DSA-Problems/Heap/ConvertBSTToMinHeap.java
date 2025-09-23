
// https://www.codingninjas.com/codestudio/problems/convert-bst-to-min-heap_920498?leftPanelTab=1

import java.util.*;

// Definition for a binary tree node
class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class ConvertBSTToMinHeap {

    // In-order traversal using Morris Traversal to get sorted values from BST
    private void getInorderMorris(BinaryTreeNode root, List<Integer> elements) {
        BinaryTreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                elements.add(curr.data);
                curr = curr.right;
            } else {
                BinaryTreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    elements.add(curr.data);
                    curr = curr.right;
                }
            }
        }
    }

    // Pre-order traversal to convert sorted elements to Min Heap
    private void buildMinHeap(BinaryTreeNode root, List<Integer> elements, int[] index) {
        if (root == null) return;

        root.data = elements.get(index[0]++);
        buildMinHeap(root.left, elements, index);
        buildMinHeap(root.right, elements, index);
    }

    // Main method to convert BST to Min Heap
    public BinaryTreeNode convertBST(BinaryTreeNode root) {
        List<Integer> elements = new ArrayList<>();

        // Step 1: Get the in-order traversal (sorted elements from BST)
        getInorderMorris(root, elements);

        // Step 2: Use pre-order traversal to overwrite nodes and build a Min Heap
        int[] index = {0}; // index is passed as array to simulate reference
        buildMinHeap(root, elements, index);

        return root;
    }
}
