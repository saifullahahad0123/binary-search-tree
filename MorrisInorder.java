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

public class MorrisInorder {


public static void morrisInorder(Node root) {

    Node current = root;

    while (current != null) {

     
        if (current.left == null) {

            System.out.print(current.data + " ");

            current = current.right;
        }

        else {

            Node predecessor = current.left;

            while (predecessor.right != null &&
                   predecessor.right != current) {

                predecessor = predecessor.right;
            }

            if (predecessor.right == null) {

                predecessor.right = current;

                current = current.left;
            }

            else {

                predecessor.right = null;

                System.out.print(current.data + " ");

                current = current.right;
            }
        }
    }
}

public static void main(String[] args) {

    Node root = new Node(1);

    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);

    System.out.println("Morris Inorder Traversal:");

    morrisInorder(root);
}


}
