package com.app.array;

import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeTest {
    @org.junit.jupiter.api.Test
    void invertTree() {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode invertedRoot = invertBinaryTree.invertTree(root);

        assertEquals(4, invertedRoot.val);
        assertEquals(7, invertedRoot.left.val);
        assertEquals(2, invertedRoot.right.val);
        assertEquals(9, invertedRoot.left.left.val);
        assertEquals(6, invertedRoot.left.right.val);
        assertEquals(3, invertedRoot.right.left.val);
        assertEquals(1, invertedRoot.right.right.val);
    }

}
