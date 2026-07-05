public class QueueImplUsingLinkedList {

public static void main(String[] args){
    MyQueue que = new MyQueue();
    que.enqueue(5);
    que.enqueue(12);
    que.getFront();
    que.printQueueElements();
}
}
class MyQueue{
    private Node front;
    private Node rear;
    public MyQueue(){
        front = rear = null;
    }
    public void printQueueElements(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }else{
            Node tempNext = front;
            while(tempNext != null){
                System.out.print(tempNext.data + " -->");
                tempNext = tempNext.next;
            }
        }
    }
    // Enqueue operation adds an element to the end of the queue
    public void enqueue(int newData){
        Node newNode = new Node(newData);
        if(isEmpty()){
            front = rear = newNode;
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
        System.out.println("Front element of queue: " + front.data);
        return front.data;
    }
    // Returns the element at the rear end of the queue without removing it
    public int getRear(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        System.out.println("Rear element of queue: " + rear.data);
        return rear.data;
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
