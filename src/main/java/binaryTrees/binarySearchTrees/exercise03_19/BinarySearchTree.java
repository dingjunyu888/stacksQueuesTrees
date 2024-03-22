package binaryTrees.binarySearchTrees.exercise03_19;

class BinarySearchTree {

    /** An inner class representing a node in a BST tree */
    private class BSTNode {
        int data; // value stored at the node
        BSTNode left; // left subtree
        BSTNode right; // right subtree

        BSTNode(int newdata) {
            data = newdata;
        }
    } // end of class BSTNode

    private BSTNode root; // the root of the tree, an instance variable of class BinarySearchTree

    BinarySearchTree() {
        root = null; // initially, the tree is empty
    }

    /** Print a binary tree (preorder) */
    public void printPreorder() {
        printPreorder(root);
    }

    public boolean findIterative(int elem) {
        BSTNode current = root;
        while (current != null) {
            // FILL IN CODE
            if(elem == current.data) {
                return true;
            }else if(elem < current.data){
                current = current.left;
            }else{
                current = current.right;
            }

        }
        return false;
    }

    public boolean findRecursive(int elem, BSTNode root) {
        // FILL IN CODE
        if(root == null){
            return false;
        }
        if(root.data == elem){
            return true;
        }
        if(elem < root.data){
            return findRecursive(elem, root.left);
        }else{
            return findRecursive(elem, root.right);
        }
    }

    public void insertIterative(int elem) {
        BSTNode prev = null;
        BSTNode current = root;
        if (root == null) {
            root = new BSTNode(elem);
            return;
        }
        while (current != null) {
            if (elem >= current.data) {
                // FILL IN CODE: update prev and current
                prev = current;
                current = current.right;
            }
            else {
                // FILL IN CODE: update prev and current
                prev = current;
                current = current.left;
            }
        }
        if (elem < prev.data) {
            // FILL IN CODE: create a new node and attach to prev
            prev.left = new BSTNode(elem);
        }
        else {
            // FILL IN CODE: create a new node and attach to prev
            prev.right = new BSTNode(elem);
        }
    }

    public BSTNode insertRecursive(int elem, BSTNode root){
        if(root == null){
            return new BSTNode(elem);
        }
        if(elem < root.data){
            root.left = insertRecursive(elem, root.left);
        }else{
            root.right = insertRecursive(elem, root.right);
        }
        return root;
    }

    private void printPreorder(BSTNode root) {
        if (root != null) {
            System.out.print(" " + root.data + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertIterative(6);
        tree.insertIterative(1);
        tree.insertIterative(10);
        tree.insertIterative(8);
        tree.insertIterative(12);
        tree.insertIterative(16);
        tree.printPreorder();
        System.out.println(tree.findIterative(12));
        System.out.println(tree.findIterative(13));
        System.out.println();
        tree.printPreorder();
        System.out.println();
    }
}
