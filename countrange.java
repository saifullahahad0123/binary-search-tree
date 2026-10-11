class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class Solution {

    int getCount(Node root, int l, int h) {

        if (root == null) {
            return 0;
        }

        if (root.data < l) {
            return getCount(root.right, l, h);
        }

        else if (root.data > h) {
            return getCount(root.left, l, h);
        }

        else {
            return 1
                + getCount(root.left, l, h)
                + getCount(root.right, l, h);
        }
    }
}

public class countrange {

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(3);
        root.left.right = new Node(7);

        root.right.left = new Node(12);
        root.right.right = new Node(18);

        Solution sol = new Solution();

        int l = 7;
        int h = 15;

        System.out.println(sol.getCount(root, l, h));
    }
}