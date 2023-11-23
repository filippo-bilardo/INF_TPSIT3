class SharedObject {
    private int value;
    private boolean available = false;

    public synchronized int getValue() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return value;
    }

    public synchronized void setValue(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        available = true;
        notifyAll();
    }
}

class Producer implements Runnable {
    private SharedObject sharedObject;

    public Producer(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedObject.setValue(i);
            System.out.println("Produced: " + i);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private SharedObject sharedObject;

    public Consumer(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = sharedObject.getValue();
            System.out.println("Consumed: " + value);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();
        Producer producer = new Producer(sharedObject);
        Consumer consumer = new Consumer(sharedObject);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }
}