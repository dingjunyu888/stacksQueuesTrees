package binaryTrees.binarySearchTrees.iterative;

/** Implementation of a basic binary search tree.
 * Methods are implemented iteratively, except for printPreorder.*/
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

    public boolean find(int elem) {
        BSTNode current = root;
        while (current != null) {
            if (current.data == elem)
                return true;
            if (current.data < elem)
                current = current.right;
            else
                current = current.left;
        }
        return false;
    }

    public void insert(int elem) {
        BSTNode prev = null;
        BSTNode current = root;
        if (root == null) {
            root = new BSTNode(elem);
            return;
        }
        while (current != null) {
            if (elem >= current.data) {
                prev = current;
                current = current.right;
            }
            else {
                prev = current;
                current = current.left;
            }
        }
        if (elem < prev.data) {
            prev.left = new BSTNode(elem);
        }
        else {
            prev.right = new BSTNode(elem);
        }
    }

    public void delete(int elem) {
        if (root == null) { // nothing to delete
            return;
        }
        BSTNode prev = null;
        BSTNode current = root;

        // Find current that contains the elem value
        while (current != null) {
            if (elem == current.data)
                break;
            else if (elem > current.data) {
                prev = current;
                current = current.right;
            }
            else {
                prev = current;
                current = current.left;
            }
        }
        //System.out.println(current.data);
        if (current == null)
            return; // element not in the tree, nothing to delete

        // The root also needs to change if we delete the root
        if (current.left == null) {
            if (prev == null) {
                // removing the root with one right child
                root = root.right;
                return;
            }
            if (prev.left == current)
                prev.left = current.right;
            else { //prev.right = current
                prev.right = current.right;
            }
        }
        else if (current.right == null){
            if (prev == null) {
                // removing the root with one left child
                root = root.left;
                return;
            }
            if (prev.left == current)
                prev.left = current.left;
            else { //prev.right = current
                prev.right = current.left;
            }
        }
        else { // has both children
            // Find the smallest value in the right subtree
            BSTNode rightRoot = current.right;
            BSTNode prevBeforeRightRoot = current;
            while (rightRoot.left != null ) {
                prevBeforeRightRoot = rightRoot;
                rightRoot = rightRoot.left;
            }
            System.out.println("smallest in the right subtree " + rightRoot.data);

            int smallest = rightRoot.data;
            current.data = smallest;
            // Remove smallest
            prevBeforeRightRoot.left = rightRoot.right;
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
        System.out.println(tree.find(12));
        System.out.println(tree.find(13));
        System.out.println();
        tree.printPreorder();
        System.out.println();
    }
}
