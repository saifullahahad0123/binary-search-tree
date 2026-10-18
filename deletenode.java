class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {

    public static Node deleteNode(Node root, int target) {

        if (root == null) {
            return null;
        }

        if (root.data > target) {
            root.left = deleteNode(root.left, target);
        }

        else if (root.data < target) {
            root.right = deleteNode(root.right, target);
        }

        else {

            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            Node succ = root.right;

            while (succ.left != null) {
                succ = succ.left;
            }

            root.right = deleteNode(root.right, succ.data);

            succ.left = root.left;
            succ.right = root.right;
            return succ;
        }

        return root;
    }
}

public class deletenode {
    public static Node insert(Node root, int data) {

        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.println("BST before deletion:");
        inorder(root);

        root = Solution.deleteNode(root, 50);

        System.out.println("\nBST after deleting 50:");
        inorder(root);
    }
}