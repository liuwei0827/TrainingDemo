class Training015 {
    public static void main(String[] args) {
        System.out.println("Hello World.");
        int[] a = { 1, 2, 3 };
        FullSort fs = new FullSort();
        fs.fullSort(a, 0, a.length - 1);

    }
}

class FullSort {
    // 全排列问题
    void fullSort(int[] src, int start, int end) {
        if (start == end) {
            for (int var : src) {
                System.out.print(var);
            }
            System.out.println();
        } else {
            for (int i = start; i <= end; i++) {
                swap(src, start, i);
                fullSort(src, start + 1, end);
                swap(src, start, i);
            }
        }
    }

    void swap(int[] src, int a, int b) {
        int tmp = src[a];
        src[a] = src[b];
        src[b] = tmp;
    }
    // 全组合问题

    // 八皇后问题
}