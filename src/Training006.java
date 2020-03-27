class Training006 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Matrix m = new Matrix(3, 3);
        m.setMatrix();
        System.out.println(m.find(11));

        for (int[] a : m.getmMatrix()) {
            for (int b : a) {
                System.out.print(b);
                System.out.print(" ");
            }
            System.out.println("");
        }
        m.printMatrix();
    }
}

class Matrix {
    // 对角线创建二维数组
    void setMatrix() {
        int value = 0;
        int row = mMatrix.length; // 行
        int column = mMatrix[0].length; // 列
        int x = 0;
        int y = 0;

        for (int t = 0; t < row + column - 1; t++) {
            if (t >= row) {
                x = row - 1;
                y = t - row + 1;
            } else {
                x = t;
                y = 0;
            }
            do {
                mMatrix[x--][y++] = value++;
            } while (x >= 0 && y < column);
        }
    }

    // 顺时针输出二维数组
    void printMatrix() {
        int rows = mMatrix.length;
        int columns = mMatrix[0].length;
        if (mMatrix == null || columns <= 0 || rows <= 0) {
            return;
        }
        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            printMatrixInCircle(columns, rows, start);
            start++;
        }
    }

    void printMatrixInCircle(int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        // 从左到右打印一行
        for (int i = start; i <= endX; i++) {
            System.out.print(mMatrix[start][i] + " ");
        }
        // 从上到下打印一行
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.print(mMatrix[i][endX] + " ");
            }
        }
        // 从右到左打印一行
        if (start < endX && start < endY - 1) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.print(mMatrix[endY][i] + " ");
            }
        }
        // 从下到上打印一行
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                System.out.print(mMatrix[i][start] + " ");
            }
        }
    }
    // 二维数组查找数字
    boolean find(int number) {
        boolean found = false;
        int rows = mMatrix.length;
        int columns = mMatrix[0].length;
        if (mMatrix != null && rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0) {
                if (mMatrix[row][column] == number) {
                    found = true;
                    break;
                } else if (mMatrix[row][column] > number) {
                    column--;
                } else {
                    row++;
                }
            }
        }
        return found;
    }

    int[][] mMatrix = null;

    /**
     * @return the mMatrix
     */
    public int[][] getmMatrix() {
        return mMatrix;
    }

    Matrix(int m, int n) {
        mMatrix = new int[m][n];
    }

}