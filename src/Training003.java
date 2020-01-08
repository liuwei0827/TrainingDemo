class Trainging003 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] a = { 1, 2, 4, 7, 16, 25, 56, 78, 99 };
        solution s = new solution();
        System.out.println(s.find(a, 4));
    }
}

// 二分法
class solution {
    int find(int[] src, int n) {
        if (n < 0) {
            return -1;
        }
        int low = 0;
        int high = src.length-1;
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
}