class MyQueue {

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;
    private int size;

    // Constructor
    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Enqueue (insert)
    public void enqueue(int x) {
        Node newNode = new Node(x);

        if (rear == null) {   // empty queue
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Dequeue (remove)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int val = front.data;
        front = front.next;

        if (front == null) {  // queue became empty
            rear = null;
        }

        size--;
        return val;
    }

    // Peek (front element)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.data;
    }

    // Check empty
    public boolean isEmpty() {
        return front == null;
    }

    // Size
    public int size() {
        return size;
    }

    // Display queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {

        MyQueue q = new MyQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.print("Queue: ");
        q.display();   // 10 20 30

        System.out.println("Front: " + q.peek()); // 10

        System.out.println("Removed: " + q.dequeue()); // 10

        System.out.print("After dequeue: ");
        q.display();   // 20 30

        System.out.println("Size: " + q.size()); // 2
    }
}