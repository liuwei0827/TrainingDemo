class Trainning001 {
    public static void main(String[] args) {
        System.out.print("Hello World");
        Singletion object = Singletion.getInstance();
    }
}

    // 单例模式
class Singletion {
    private Singletion() {
    };

    private volatile static Singletion instance;

    public static Singletion getInstance() {
        if (instance == null) {
            synchronized (Singletion.class) {
                if ((instance == null)) {
                    instance = new Singletion();
                }
            }
        }
        return instance;
    }
}