package QAP3;

public class UndoRedo<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;
        private Node (T state) {
            this.state = state;
        }
    }

    private Node currentState;

    public UndoRedo(){
        this.currentState = null;
    }

    //Undo operation
    /**
     * move currentState back to the previous state in the list
     * 
     * @return state of the new current node
     */
    public T undo(){
    //implement me
        if (currentState == null || currentState.prev == null) {
            throw new Error("No states left in the list to undo.");
        }
        currentState = currentState.prev;
        return currentState.state;
    }
    
    //perform an operation
    /**
     * Create a new node, represented by a new state. if there are no current
     * nodes, newState is the currentState. if nodes already exist within the 
     * linked list, link the newState to the currentState and move currentState
     * to the new node.
     * 
     * @param newState
     */
    public void  addState (T newState) {
        //implement me
        Node newNode = new Node(newState);

        if (currentState == null){
            currentState = newNode;
        } else {
            newNode.prev = currentState;
            currentState.next = newNode;
            currentState = newNode;
        }
    }
    
    //Redo Operation
    /** move currentState forward to the next state in the list
     * 
     * @return state of the new current node
     */
    public T redo(){
        //implement me
        if (currentState == null || currentState.next == null) {
            throw new Error("No states left in the list to redo.");
        }
        currentState = currentState.next;
        return currentState.state;
    }
    
    public static void main(String[] args) {
    
    
    }
}
