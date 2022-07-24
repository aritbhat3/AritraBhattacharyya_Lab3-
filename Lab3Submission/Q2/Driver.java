package Lab3Submission.Q2;

public class Driver {
    public static void main(String args[]) {
        Node rootNode = null; //declare the root
        rootNode = InsertNode.insertNode(40, rootNode); //Add the nodes
        rootNode = InsertNode.insertNode(20, rootNode);
        rootNode = InsertNode.insertNode(60, rootNode);
        rootNode = InsertNode.insertNode(10, rootNode);
        rootNode = InsertNode.insertNode(30, rootNode);
        rootNode = InsertNode.insertNode(50, rootNode);
        rootNode = InsertNode.insertNode(70, rootNode);
        int targetSum = 130;
        PairFinder.findPair(targetSum,rootNode);
    }
}