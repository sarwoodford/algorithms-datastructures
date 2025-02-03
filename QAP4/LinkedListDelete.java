package QAP4;

public class LinkedListDelete<T>{
    class Node{
        T listItem;
        Node next;
    
        public Node(T listItem){
            this.listItem = listItem;
            this.next = null;
        }
    }

    private Node head;

    public LinkedListDelete(){
        this.head = null;
    }

    /**
     * add list item, if list is empty, new item becomes head. if
     * list is not empty, item gets added to existing list
     * 
     * @param listItem
     * @return listItem
     */
    public T addListItem(T listItem){
        Node newItem = new Node(listItem);

        if (head == null){
            head = newItem;
        } else{
            Node current = head;
            while( current.next != null ){
                current = current.next;
            }

            current.next = newItem;
        }

        return listItem;
    }

    /**
     * error is displayed if list is empty
     * 
     * @return null
     */
    public T errorIfDoesntExist(){
        if (head == null){
            System.out.println("List is empty.");
            return null;
        }

        return null;
    }

    /**
     * deletes the head, or displays an error if the list
     * is empty
     * 
     * @return data
     */
    public T deleteAtBeginning(){
        if (head == null){
            return errorIfDoesntExist();
        }
        T data = head.listItem;
        head = head.next;
        return data;
    }

    /**
     * deletes an item at the end of the list, displays an 
     * error if the list is empty. if only one list item is
     * in the list, the head is deleted
     * 
     * @return data
     */
    public T deleteAtEnd(){
        if (head == null){
            return errorIfDoesntExist();
        }

        if (head.next == null){
            T data = head.listItem;
            head = null;
            return data;
        }

        Node current = head;

        while(current.next != null && current.next.next != null){
            current = current.next;
        }

        T data = current.next.listItem;
        current.next = null;
        return data;
    }

    /**
     * deletes a list item anywhere in the list, user can specify which item
     * they want deleted. error is thrown if list is empty
     * 
     * @param item
     * @return data
     */
    public T deleteAnywhere(T item){
        if ( head == null){
            return errorIfDoesntExist();
        }

        if(head.listItem.equals(item)){
            return deleteAtBeginning();
        }

        Node current = head;
        while(current.next != null && !current.next.listItem.equals(item)){
            current = current.next;
        }

        if (current.next == null){
            System.out.println("item not found");
            return null;
        }

        T data = current.next.listItem;
        current.next = current.next.next;
        return data;
    }

    /**
     * displays list
     * 
     */
    public void showList(){
        Node current = head;
        while (current!=null){
            System.out.println(current.listItem + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args){
        LinkedListDelete<Integer> list = new LinkedListDelete<>();

        list.showList();
        list.deleteAtBeginning();
        list.deleteAtEnd();

        list.addListItem(10);
        list.addListItem(7);
        list.addListItem(13);
        list.addListItem(4);

        list.showList();
        list.deleteAtBeginning();
        list.showList();
        list.deleteAtEnd();
        list.showList();
        list.deleteAnywhere(1);
        list.showList();
    }
}










