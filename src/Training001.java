class Trainning001 {
    // 单例模式
    public static void main(String[] args) {
        Singletion object = Singletion.getInstance();
        System.out.print("Hello World");
    }
}

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