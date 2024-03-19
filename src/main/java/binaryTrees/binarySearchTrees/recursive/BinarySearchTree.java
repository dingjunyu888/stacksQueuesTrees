package binaryTrees.binarySearchTrees.recursive;

/** Implementation of a binary search tree.
 *  The code has been modified from the code of Prof. Galles.
 */
class BinarySearchTree {

    /** An inner class representing a node in a BST tree */
    private class BSTNode {
        int data; // value stored at the node
        BSTNode left; // left subtree
        BSTNode right; // right subtree

        BSTNode(int newdata) {
            data = newdata;
        }
    }

    private BSTNode root; // the root of the tree, an instance variable of class BinarySearchTree

    BinarySearchTree() {
        root = null; // initially, the tree is empty
    }

    /**
     * Insert a given element into the BST tree
     * @param elem element to insert into the BST tree
     */
    public void insert(int elem) {
        root = insert(root, elem);
    }

    /**
     * Return true if a given element is in the tree
     * @param elem element to find
     * @return true if the element is present, false otherwise
     */
    public boolean find(int elem) {
        return find(root, elem);
    }

    /**
     * Delete the node with the given element from the tree
     * @param elem element to remove
     */
    public void delete(int elem) {
        root = delete(root, elem);
    }

    /** Serialize a binary tree (preorder and use / for a null tree) */
    public void printPreorder() {
        printPreorder(root);
    }

    // private helper methods ---------------------------
    /**
     * Find elem in the tree with the given root
     * @param tree root of a tree
     * @param elem element to find
     * @return true if the node with this element is present in the tree
     */
    private boolean find(BSTNode tree, int elem) {
        if (tree == null)
            return false;
        if (elem == tree.data)
            return true;
        if (elem < tree.data)
            return find(tree.left, elem);
        else
            return find(tree.right, elem);
    }


    /**
     * Insert elem into the tree with the given root
     * @param tree root of a tree
     * @param elem element to insert
     * @return the root of a tree that contains the new node
     */
    private BSTNode insert(BSTNode tree, int elem) {
        if (tree == null) {
            return new BSTNode(elem);
        }
        if (elem < tree.data) {
            tree.left = insert(tree.left, elem);
            return tree;
        } else {
            tree.right = insert(tree.right, elem);
            return tree;
        }
    }

    /**
     * Find the node with the value of elem in the tree with given
     * root and delete it
     * @param tree root of a tree
     * @param elem element to delete
     * @return the root of a tree
     */
    private BSTNode delete(BSTNode tree, int elem) {
        if (tree == null)
            return null;
        if (tree.data == elem) { // found node with elem
            if (tree.left == null) // has one child
                return tree.right;
            else if (tree.right == null) // has one child
                return tree.left;
            else { // has two children
                if (tree.right.left == null) {
                    // if the right subtree has no left tree
                    // then the value at the root of the right subtree
                    // is the smallest value in the right subtree.
                    // it means we want to place the value of tree.right at tree.data
                    // and remove tree.right
                    tree.data = tree.right.data;

                    // delete the root of the right subtree
                    tree.right = tree.right.right;
                    return tree;
                } else {
                    // need to find the node with the smallest value
                    // in the right subtree
                    tree.data = removeSmallest(tree.right);
                    return tree;
                }
            }
        } else if (elem < tree.data) { // find and delete in left subtree
            tree.left = delete(tree.left, elem);
            return tree;
        } else {
            tree.right = delete(tree.right, elem); // find and delete in right subtree
            return tree;
        }
    }

    /**
     * Find and remove the node with the smallest value in the tree
     * @param tree root of a tree
     * @return the smallest element in the tree
     */
    private int removeSmallest(BSTNode tree) {
        // the smallest value is always in the left most subtree
        if (tree.left.left == null) { // the smallest value is in tree.left
            int smallest = tree.left.data;
            tree.left = tree.left.right; // delete it
            return smallest;
        } else {
            return removeSmallest(tree.left);
        }
    }


    /** Print a given tree using preorder traversal
     *
     * @param root of the tree
     */
    private void printPreorder(BSTNode root) {
        if (root != null) {
            System.out.print(" " + root.data + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(1);
        tree.insert(10);
        tree.insert(8);
        tree.insert(12);
        tree.insert(16);
        tree.printPreorder();
        System.out.println();
        tree.delete(6);
        tree.printPreorder();
        System.out.println();

    }
}
