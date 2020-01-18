class Training001 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        threadtest t = new threadtest();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
//        t.run();
        }
}

// 线程同步问题测试
class threadtest implements Runnable{
    int args=0;
    @Override
    public void run() {
        synchronized(this){
            for(int i=0;i<100;i++){
                System.out.println(Thread.currentThread().getName()+":"+args);
                args++;
            }           
        }
    }
}