package Lab3Submission.Q1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1BalancedStr {

    //Driver method
    public static void main(String args[]) {
        String testStr1 = "{{[]}}";
        String testStr2 = "";
        String testStr3 = "(){}[]({[}])";

        //Printer method
        printDecision(testStr1, isBalanced(testStr1));
        printDecision(testStr2, isBalanced(testStr2));
        printDecision(testStr3, isBalanced(testStr3));
    }

    //Method to find out if the input string is Balanced or not
    private static boolean isBalanced(String ipStr) {
        Deque<Character> charStack = new ArrayDeque<Character>();

        //iterate over the entire string and get each character
        for(int el = 0; el<ipStr.length(); el++) {
            char currCh = ipStr.charAt(el);

            //Check open bracket and then go to next iteration if pushed
            if (currCh == '[' || currCh == '{' || currCh == '(') {
                charStack.push(currCh);
                continue;
            }

            //If not pushed, then it means it must be closing bracket
            //If closing bracket comes when stack is empty, it must be non balanced
            if (charStack.isEmpty())
                return false;

            char testChar = charStack.pop();

            //invoke function to check if closing amd opening brackets are the 2 characters in question
            if (checkPair(testChar, currCh))
                continue;
            else
                return false;

        }

        //If there are no issues in the entire string, return Balanced
        return true;
    }

    //Function that checks the opening and closing brackets are of the same type or not
    private static boolean checkPair(char opBracket, char clBracket) {
        if ( (opBracket == '[' && clBracket == ']') || (opBracket == '{' && clBracket == '}') || (opBracket == '(' && clBracket == ')'))
            return true;
        return false;
    }

    //Printer function implementation
    private static void printDecision(String ipStr, boolean decision) {
        String verdict;
        if (decision)
            verdict = "has Balanced Brackets";
        else
            verdict = "does Not have Balanced Brackets";

        System.out.println("The entered string '" +ipStr+"' "+verdict);
    }
}