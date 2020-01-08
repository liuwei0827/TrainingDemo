class Training002 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int m = 13;
        Fb fb = new Fb(m);
        fb.setOutput(m);
        for (int var : fb.getOutput()) {
            System.out.print(var);
            System.out.print(" ");
        }
    }
}

// 斐波那契数列
class Fb {
    private int[] output = null;

    Fb(int n) {
        output = new int[n];
    }

    /**
     * @return the output
     */
    public int[] getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(int n) {
        for (int p = 0; p < n; p++) {
            output[p] = solution2(p);
        }
    }

    // 递归
    int solution1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else if (n > 1) {
            return solution1(n - 1) + solution1(n - 2);
        } else {
            return 0;
        }
    }

    // 非递归
    int solution2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 1;
        int preResult = 1;
        int prePreRsult = 1;
        if (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                result = preResult + prePreRsult;
                prePreRsult = preResult;
                preResult = result;
            }
            return result;
        }
        return 0;
    }
}