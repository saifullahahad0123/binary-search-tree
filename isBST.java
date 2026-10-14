class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class Triplet {
    int max;
    int min;
    boolean isBST;

    Triplet(int max, int min, boolean isBST) {
        this.max = max;
        this.min = min;
        this.isBST = isBST;
    }
}

class Solution {

    boolean isBST(Node root) {
        return maxMin(root).isBST;
    }

    Triplet maxMin(Node root) {

        if (root == null) {
            return new Triplet(
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                true
            );
        }

        Triplet lst = maxMin(root.left);
        Triplet rst = maxMin(root.right);

        int max = Math.max(
            root.data,
            Math.max(lst.max, rst.max)
        );

        int min = Math.min(
            root.data,
            Math.min(lst.min, rst.min)
        );

        boolean isBST = lst.isBST
                     && rst.isBST
                     && lst.max < root.data
                     && rst.min > root.data;

        return new Triplet(max, min, isBST);
    }
}

public class isBST {

    public static void main(String[] args) {

     

        Node root = new Node(10);

        root.left = new Node(5);
        root.right = new Node(20);

        root.left.left = new Node(2);
        root.left.right = new Node(8);

        Solution sol = new Solution();

        if (sol.isBST(root)) {
            System.out.println("The tree is a BST");
        } else {
            System.out.println("The tree is not a BST");
        }
    }
}