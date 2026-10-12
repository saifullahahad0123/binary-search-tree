import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class checkbst {

    static void inorder(Node root, ArrayList<Integer> arr) {

        if (root == null) {
            return;
        }

        inorder(root.left, arr);

        arr.add(root.val);

        inorder(root.right, arr);
    }

    static boolean isBST(Node root) {

        ArrayList<Integer> arr = new ArrayList<>();

        inorder(root, arr);

        for (int i = 1; i < arr.size(); i++) {

            if (arr.get(i) <= arr.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(8);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.left = new Node(6);
        root.right.right = new Node(9);

        if (isBST(root)) {
            System.out.println("Valid BST");
        } else {
            System.out.println("Not a BST");
        }
    }
}
