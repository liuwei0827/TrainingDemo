class Trainning001 {
    public static void main(String[] args) {
        System.out.print("Hello World");
    }
}
    // 单例模式
class Singleton {
    private Singleton() {
    };

    private volatile static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if ((instance == null)) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}