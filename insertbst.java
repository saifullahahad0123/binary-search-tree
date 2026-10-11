class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    void attach(Node root, int key) {

        if (root == null) return;

        if (root.data == key) return;

        if (key < root.data && root.left == null) {
            root.left = new Node(key);
            return;
        }

        if (key > root.data && root.right == null) {
            root.right = new Node(key);
            return;
        }

        if (key < root.data) {
            attach(root.left, key);
        } else {
            attach(root.right, key);
        }
    }

    Node insert(Node root, int key) {

        if (root == null) {
            return new Node(key);
        }

        attach(root, key);

        return root;
    }

    void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

public class insertbst {

    public static void main(String[] args) {

        Solution sol = new Solution();

        
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);

        System.out.println("Before insertion:");
        sol.inorder(root);

        root = sol.insert(root, 35);

        System.out.println("\nAfter insertion:");
        sol.inorder(root);
    }
}