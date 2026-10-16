import java.util.*;

class Node {
int val;
Node left;
Node right;


Node(int val) {
    this.val = val;
}

}

public class Predecessor {


static Node predecessor;
static Node successor;

static void findPredecessorSuccessor(Node root, int key) {

    predecessor = null;
    successor = null;

    Node curr = root;

    while (curr != null) {

        if (curr.val == key) {

            // Find predecessor
            if (curr.left != null) {
                Node temp = curr.left;

                while (temp.right != null) {
                    temp = temp.right;
                }

                predecessor = temp;
            }

            // Find successor
            if (curr.right != null) {
                Node temp = curr.right;

                while (temp.left != null) {
                    temp = temp.left;
                }

                successor = temp;
            }

            break;
        }

        else if (key < curr.val) {

            // Current node could be the successor
            successor = curr;
            curr = curr.left;

        }

        else {

            // Current node could be the predecessor
            predecessor = curr;
            curr = curr.right;
        }
    }
}

static Node insert(Node root, int val) {

    if (root == null) {
        return new Node(val);
    }

    if (val < root.val) {
        root.left = insert(root.left, val);
    } else if (val > root.val) {
        root.right = insert(root.right, val);
    }

    return root;
}

public static void main(String[] args) {

    Node root = null;

    int[] arr = {50, 30, 70, 20, 40, 60, 80};

    for (int val : arr) {
        root = insert(root, val);
    }

    int key = 50;

    findPredecessorSuccessor(root, key);

    if (predecessor != null) {
        System.out.println("Inorder Predecessor: " + predecessor.val);
    } else {
        System.out.println("Inorder Predecessor: Does not exist");
    }

    if (successor != null) {
        System.out.println("Inorder Successor: " + successor.val);
    } else {
        System.out.println("Inorder Successor: Does not exist");
    }
}


}
