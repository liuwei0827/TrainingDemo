import java.util.concurrent.LinkedBlockingQueue;

class Training0017 {
    public static void main(final String[] args) {
        System.out.println("Hello World");

        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
        final Productor p = new Productor(queue);
        final Consumer c = new Consumer(queue);
        p.start();
        c.start();
    }
}

// 生产者消费者模式
class Productor extends Thread {
    public Productor(LinkedBlockingQueue<Integer> Queue) {
        this.queue = Queue;
    }

    void produce() {
        synchronized (queue) {
            while (queue.size() >= 5) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Product:No" + queue.size());
            queue.offer(queue.size());
            queue.notifyAll();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private LinkedBlockingQueue<Integer> queue;
}

class Consumer extends Thread {
    public Consumer(LinkedBlockingQueue<Integer> Queue) {
        this.queue = Queue;
    }

    void consume() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Consume:No" + queue.poll().intValue());
            queue.notifyAll();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private LinkedBlockingQueue<Integer> queue;
}
