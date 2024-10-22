package EcommerceManagementSystem;

import java.util.Stack;

public class ReturnManager {
    private Stack<ReturnRequest> returnRequests;

    public ReturnManager() {
        returnRequests = new Stack<>();
    }

    public void addReturnRequest(ReturnRequest request) {
        returnRequests.push(request);
    }

    public void processReturnRequest() {
        if (!returnRequests.isEmpty()) {
            returnRequests.pop(); // I don't need printing in my test that's why
//            System.out.println("Processing: " + returnRequests.pop());
        } else {
            System.out.println("No return requests to process.");
        }
    }

    public void displayReturnRequests() {
        for (ReturnRequest request : returnRequests) {
            System.out.println(request);
        }
    }
}
