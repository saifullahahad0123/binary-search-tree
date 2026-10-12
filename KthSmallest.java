import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class KthSmallest {

    static void inorder(Node root, ArrayList<Integer> list) {

        if (root == null) {
            return;
        }

        inorder(root.left, list);

        list.add(root.val);

        inorder(root.right, list);
    }

    static int kthSmallest(Node root, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        inorder(root, list);

        if (k < 1 || k > list.size()) {
            return -1;
        }

        return list.get(k - 1);
    }

    public static void main(String[] args) {

        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(7);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.left = new Node(6);
        root.right.right = new Node(8);

        int k = 3;

        System.out.println(kthSmallest(root, k));
    }
}