package Lab3Submission.Q2;

import java.util.LinkedList;

class PairFinder {
    public static void findPair(int target, Node ipNode) {
        //create 2 lists containing left and right subtree elements
        LinkedList<Node> leftList = new LinkedList<>();
        LinkedList<Node> rightList = new LinkedList<>();

        Node leftElement = ipNode;
        Node rightElement = ipNode;

        //as long as there is an input of element OR there are elements inside the lists, we have data to work with
        while(leftElement!=null || rightElement!=null || leftList.size()>0 && rightList.size()>0) {
            //we enter all the elements of the left subtree into the list now
            while (leftElement!=null) {
                leftList.add(leftElement);
                leftElement=leftElement.left;
            }

            //we enter all the elements of the right subtree into the list now
            while (rightElement!=null) {
                rightList.add(rightElement);
                rightElement=rightElement.right;
            }

           //Now traverse the lists using following control variables
            Node LeftNode = leftList.get(leftList.size() - 1);
            Node RightNode = rightList.get(rightList.size() - 1);
            int leftval = LeftNode.value;
            int rightval = RightNode.value;

            //this is to avoid repetition of pairs, so that 60,70 and 70,60 are not treated as different
            if (leftval>=rightval)
                break;

            //Now check for the sum vs the target and remove elements from the list.
            if (leftval + rightval < target) {
                leftList.remove(leftList.size() - 1);
                leftElement = LeftNode.right;
            }
            else if (leftval + rightval > target) {
                rightList.remove(rightList.size() - 1);
                rightElement = RightNode.left;
            }
            else {
                System.out.println("Set found: " + LeftNode.value + "  " + RightNode.value);
                rightList.remove(rightList.size() - 1);
                leftList.remove(leftList.size() - 1);
                leftElement = LeftNode.right;
                rightElement = RightNode.left;
            }
        }
    }
}

