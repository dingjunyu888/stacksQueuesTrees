package labMarch8;

import stacks.ListStack;
import stacks.Stack;

// Use a stack to allow the user to go back in browsing history
// This implementation does not allow to go forward, only backward.
// Example:
// goToURL("1.org");
// goToURL("2.org");
// goToURL("3.org");
// back() should print 2.org
// back() should print 1.org
public class BrowsingHistory {
    private Stack stackBack = new ListStack();

    public void goToURL(String url) {
        System.out.println("Currently visiting " + url);
        // FILL IN CODE

    }

    public String back() {
        // FILL IN CODE

        return null; // change
    }

    public void printStack() {
        System.out.println(stackBack);
    }

    public static void main(String[] args) {
        BrowsingHistory browserHistory = new BrowsingHistory();
        browserHistory.goToURL("1.com");
        browserHistory.goToURL("2.com");
        browserHistory.goToURL("3.com");
        browserHistory.goToURL("4.com");
        browserHistory.goToURL("5.com");
        browserHistory.printStack();
        System.out.println("back to " + browserHistory.back());
        System.out.println("back to " + browserHistory.back());
        System.out.println("back to " + browserHistory.back());
        browserHistory.goToURL("6.com");
        browserHistory.goToURL("7.com");
        browserHistory.goToURL("8.com");
        browserHistory.printStack();
        System.out.println("back to " + browserHistory.back());
        System.out.println("back to " + browserHistory.back());
        System.out.println("back to " + browserHistory.back());
        browserHistory.printStack();
        browserHistory.goToURL("9.org");
        System.out.println("back to " + browserHistory.back());
        System.out.println("back to " + browserHistory.back());
    }

}
