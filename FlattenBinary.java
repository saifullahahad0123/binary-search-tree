class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {

    public static void flatten(Node root) {

        Node curr = root;

        while (curr != null) {

            if (curr.left != null) {

                Node pred = curr.left;

                while (pred.right != null) {
                    pred = pred.right;
                }

                pred.right = curr.right;

                curr.right = curr.left;

                curr.left = null;
            }

            curr = curr.right;
        }
    }
}

public class FlattenBinary {

    public static void printList(Node root) {

        Node curr = root;

        while (curr != null) {
            System.out.print(curr.val + " ");

            if (curr.left != null) {
                System.out.println("\nError: Left pointer is not null!");
                return;
            }

            curr = curr.right;
        }

        System.out.println();
    }

    public static void main(String[] args) {

       

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.right = new Node(6);

        System.out.println("Before flattening:");
        System.out.println("Binary tree created successfully.");

        Solution.flatten(root);

        System.out.println("After flattening:");
        printList(root);
    }
}