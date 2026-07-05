public class QueueImplUsingLinkedList {


}
class MyQueue{
    private Node front;
    private Node rear;
    public MyQueue(){
        front = rear = null;
    }
    // Enqueue operation adds an element to the end of the queue
    public void enqueue(int newData){
        Node newNode = new Node(newData);
        if(isEmpty()){
            front = rear = null;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
    }
    // Dequeue operation removes an element from the front of the queue
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return;
        }else{
            Node temp = front;
            front = front.next;
            if(front== null){
                rear = null;
            }
            temp = null;
        }
    }

    // Returns the element at the front end of the queue without removing it
    public int getFront(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }
    public boolean isEmpty(){
        return front == null;
    }
}
class Node{
    int data;
    Node next;

    Node(int newData){
        data = newData;
        next = null;
    }
}
