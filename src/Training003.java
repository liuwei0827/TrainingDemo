class Trainging003 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] a = { 1, 2, 4, 4, 16, 25, 56, 78, 99 };
        solution s = new solution();
        System.out.println(s.find4(a, 4));
    }
}

// 二分法相关集合
class solution {
    int find(int[] src, int n) {
        if (n < 0) {
            return -1;
        }
        int low = 0;
        int high = src.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = ((low + high) / 2);
            if (src[mid] == n) {
                return mid;
            } else if (src[mid] < n) {
                low = mid - 1;
            } else if (src[mid] > n) {
                high = mid + 1;
            }
        }
        return -1;
    }

    // 第一个相等的数
    int find1(int[] src, int n) {
        if (n < 0) {
            return -1;
        }
        int low = 0;
        int high = src.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = ((low + high) / 2);
            if (src[mid] >= n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < src.length && src[low] == n) {
            return low;
        }
        return -1;
    }

    // 最后一个相等的数
    int find2(int[] src, int n) {
        if (n < 0) {
            return -1;
        }
        int low = 0;
        int high = src.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = ((low + high) / 2);
            if (src[mid] <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (low < src.length && src[high] == n) {
            return high;
        }
        return -1;
    }

    // 第一个大于等于的数
    int find3(int[] src, int n) {
        if (n < 0) {
            return -1;
        }
        int low = 0;
        int high = src.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = ((low + high) / 2);
            if (src[mid] >= n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // 最后一个小于等于的数
    int find4(int[] src, int n) {
        if (n < 0) {
            return -1;
        }
        int low = 0;
        int high = src.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = ((low + high) / 2);
            if (src[mid] <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}