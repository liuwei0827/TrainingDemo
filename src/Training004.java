class Training004 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] a = { 1, 4, 6, 8, 3, 5, 9 };

        Sort s = new Sort();
        s.mergeSort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}

// 排序算法相关集合
class Sort {
    // 冒泡排序
    int[] bubbleSort(int[] src) {
        int i = 0;
        int j = 0;
        for (i = 0; i < src.length - 1; i++) {
            boolean isSorted = true;
            for (j = 0; j < src.length - 1 - i; j++) {
                if (src[j] > src[j + 1]) {
                    int tmp = src[j + 1];
                    src[j + 1] = src[j];
                    src[j] = tmp;
                    isSorted = false;
                }
                if (isSorted == true) {
                    break;
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
    void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }

    // 插入排序
    void insertSort(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }

    // 堆排序
    void downAdjust(int[] array, int parentIndex, int lenght) {
        int tmp = array[parentIndex];
        int childrenIndex = parentIndex * 2 + 1;
        while (childrenIndex < lenght) {
            if (childrenIndex + 1 < lenght && array[childrenIndex] < array[childrenIndex + 1]) {
                childrenIndex++;
            }
            if (tmp >= array[childrenIndex]) {
                break;
            }
            array[parentIndex] = array[childrenIndex];
            parentIndex = childrenIndex;
            childrenIndex = 2 * childrenIndex + 1;
        }
        array[parentIndex] = tmp;
    }

    void heapSort(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            downAdjust(array, 0, i);
        }
    }

    // 计数排序
    int[] countSort(int[] array) {
        // 取得最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        // 根据最大值建立数组并计数
        int[] countArray = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }
        // 遍历输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    // 并归排序
    void mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    void sort(int[] array, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sort(array, L, mid);
        sort(array, mid + 1, R);
        merge(array, L, mid, R);
    }

    void merge(int[] array, int L, int mid, int R) {
        int[] tmp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            if (array[p1] > array[p2]) {
                tmp[i] = array[p2];
                i++;
                p2++;
            } else {
                tmp[i] = array[p1];
                p1++;
                i++;
            }
        }
        while (p1 <= mid) {
            tmp[i++] = array[p1++];
        }
        while (p2 <= R) {
            tmp[i++] = array[p2++];
        }
        for (i = 0; i < tmp.length; i++) {
            array[L + i] = tmp[i];
        }
    }
}