class Training004 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] a = { 1, 4, 6, 8, 3, 5, 9 };

        Sort s = new Sort();
        s.quick_sort(a, 0, a.length - 1);
        for (int i : a) {
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
    void quick_sort(int[] src, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int k = src[l];
            while (i < j) {
                while (i < j && src[j] >= k) {
                    j--;
                }
                if (i < j) {
                    src[i++] = src[j];
                }
                while (i < j && src[i] <= k) {
                    i++;
                }
                if (i < j) {
                    src[j--] = src[i];
                }
            }
            src[i] = k;
            quick_sort(src, l, i - 1);
            quick_sort(src, i + 1, r);
        }
    }
    
    // 选择排序

    // 插入排序

    // 堆排序
}