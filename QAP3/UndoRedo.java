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
    //Undo operation
    public T undo(){
    //implement me
    }
    
    //perform an operation
    public void  addState (T newState) {
        //implement me
    
    }
    
    //Redo Operation
    public T redo(){
        //implement me
    }
    
    public static void main(String[] args) {
    
    
    }
}
