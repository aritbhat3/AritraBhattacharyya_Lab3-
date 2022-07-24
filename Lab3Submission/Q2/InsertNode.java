package Lab3Submission.Q2;

class InsertNode {
    //method to assign left/right position in the tree based on root node. Done Recursively.
    public static Node insertNode(int value, Node root) {

        if(root == null) {
            root = new Node(value);
            return root;
        }

        //Assignment is done to left/right subtree based on value, duplicates are not assigned.
        if (root.value < value)
            root.right=insertNode(value, root.right);

        else if (root.value > value)
            root.left=insertNode(value, root.left);

        return root;
    }
}