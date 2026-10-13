class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class lcabst {

    public static Node lowestCommonAncestor(Node root, int p, int q) {

        while (root != null) {

            if (p < root.val && q < root.val) {
                root = root.left;
            }

            else if (p > root.val && q > root.val) {
                root = root.right;
            }

            else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Node root = new Node(6);

        root.left = new Node(2);
        root.right = new Node(8);

        root.left.left = new Node(0);
        root.left.right = new Node(4);

        root.right.left = new Node(7);
        root.right.right = new Node(9);

        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

        Node ans = lowestCommonAncestor(root, 2, 8);

        if (ans != null) {
            System.out.println("LCA = " + ans.val);
        } else {
            System.out.println("LCA not found");
        }
    }
}