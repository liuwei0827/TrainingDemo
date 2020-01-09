class Training006 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Matrix m = new Matrix(3, 2);
        m.setMatrix();

        for (int[] a : m.getmMatrix()) {
            for (int b : a) {
                System.out.print(b);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}

class Matrix {
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
}