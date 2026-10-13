class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class ArrayToBST {

    public static Node sortedArrayToBST(int[] arr, int start, int end) {

        if (start > end) {
            return null;
        }


        int mid = start + (end - start) / 2;

        Node root = new Node(arr[mid]);

        root.left = sortedArrayToBST(arr, start, mid - 1);

        root.right = sortedArrayToBST(arr, mid + 1, end);

        return root;
    }

    public static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.val + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        Node root = sortedArrayToBST(arr, 0, arr.length - 1);

        System.out.println("Inorder Traversal:");

        inorder(root);
    }
}