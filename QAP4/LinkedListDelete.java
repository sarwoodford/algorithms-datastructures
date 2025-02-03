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

    public T errorIfDoesntExist(){
        if (head == null){
            System.out.println("List is empty.");
            return null;
        }

        return null;
    }

    public T deleteAtBeginning(){
        if (head == null){
            return errorIfDoesntExist();
        }
        T data = head.listItem;
        head = head.next;
        return data;
    }

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










