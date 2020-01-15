class Training010 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] array = new int[] { 1, 3, 2, 6, 5, 7, 8, 9, 10, 0 };
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.upAdjust(array);
        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println("");

        int[] array2 = new int[] { 7, 1, 3, 10, 5, 2, 8, 9, 6 };
        binaryHeap.buildHeap(array2);
        for (int i : array2) {
            System.out.print(i + " ");
        }
    }
}

class BinaryHeap {
    // 新建二叉堆
    void buildHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    // 下沉
    void downAdjust(int[] array, int parentIndex, int length) {
        int tmp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (tmp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = tmp;
    }

    // 上浮
    void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int tmp = array[childIndex];
        while (childIndex > 0 && tmp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = tmp;
    }
}