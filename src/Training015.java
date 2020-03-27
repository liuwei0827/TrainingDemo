class Training015 {
    public static void main(String[] args) {
        System.out.println("Hello World.");
        int[] a = { 1, 2, 3 };
        FullSort fs = new FullSort();
        // fs.fullSort(a, 0, a.length - 1);
//        fs.combination(a);
        new Queen8().check(0);
    }
}

// 全排列问题
class FullSort {
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
    void combination(int[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= src.length; i++) {

            combination(src, i, stringBuilder, 0);
        }
    }

    void combination(int src[], int num, StringBuilder sBuilder, int start) {
        System.out.println(sBuilder);
        if (num == 0) {
            System.out.println(sBuilder);
        } else {
            if (start == src.length) {
                return;
            }
            sBuilder.append(src[start]);
            combination(src, num - 1, sBuilder, start + 1);
            sBuilder.deleteCharAt(sBuilder.length() - 1);
            combination(src, num, sBuilder, start + 1);
        }
    }
}

class Queen8 {
    int max = 8;
    int[] array = new int[max];

    public void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + 1 + "");
        }
        System.out.println();
    }

    public Boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }
}