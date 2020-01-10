class Training004 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] a = { 1, 4, 6, 8, 3, 5, 9 };

        Sort s = new Sort();
        for (int i : s.sort(a)) {
            System.out.print(i + " ");
        }
    }
}

// 各种常用排序算法
class Sort {
    // 冒泡排序
    int[] sort(int[] src) {
        int i = 0;
        int j = 0;
        for (i = 0; i < src.length - 1; i++) {
            for (j = 0; j < src.length - 1 - i; j++) {
                if (src[j] > src[j + 1]) {
                    int tmp = src[j + 1];
                    src[j + 1] = src[j];
                    src[j] = tmp;
                }
            }
        }
        return src;
    }

    // 快速排序

    // 选择排序

    // 插入排序

    // 堆排序
}