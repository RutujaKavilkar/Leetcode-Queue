class MyQueue {

    private int[] arr;
    private int front, rear, capacity;

    // Constructor
    public MyQueue(int size) {
        capacity = size;
        arr = new int[capacity];
        front = 0;
        rear = -1;
    }

    // Enqueue (insert)
    public void enqueue(int x) {
        if (rear == capacity - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        rear++;
        arr[rear] = x;
    }

    // Dequeue (remove)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int val = arr[front];
        front++;
        return val;
    }

    // Peek (front element)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    // Check if empty
    public boolean isEmpty() {
        return front > rear;
    }

    // Size of queue
    public int size() {
        return (rear - front + 1);
    }

    // Display queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {

        MyQueue q = new MyQueue(5);

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