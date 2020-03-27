class Training012 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        BigNumberSolution b = new BigNumberSolution();
        System.out.println(b.dobigNumberMultiply("123", "123"));
    }
}

// 大数相加&相乘
class BigNumberSolution {
    // 大数相加
    // int的范围：-2^31~2^32-1
    // long的范围：-2^63~2^63-1
    String dobigNumberSum(String stringA, String stringB) {
        int maxLength = stringA.length() > stringB.length() ? stringA.length() : stringB.length();
        int[] arrayA = new int[maxLength + 1];
        int[] arrayB = new int[maxLength + 1];
        int[] result = new int[maxLength + 1];
        for (int i = 0; i < stringA.length(); i++) {
            arrayA[i] = stringA.charAt(stringA.length() - 1 - i) - '0';
        }
        for (int i = 0; i < stringB.length(); i++) {
            arrayB[i] = stringB.charAt(stringB.length() - 1 - i) - '0';
        }

        for (int i = 0; i < result.length; i++) {
            int tmp = result[i];
            tmp = arrayA[i] + tmp;
            tmp = arrayB[i] + tmp;
            if (tmp >= 10) {
                tmp = tmp - 10;
                result[i + 1] = 1;
            }
            result[i] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        boolean isFirst = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if (!isFirst) {
                if (result[i] == 0) {
                    continue;
                }
                isFirst = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    // 大数相乘
    String dobigNumberMultiply(String stringA, String stringB) {
        int[] arrayA = new int[stringA.length()];
        int[] arrayB = new int[stringB.length()];
        int[] Multiply = new int[stringA.length() + stringB.length() - 1];

        for (int i = 0; i < stringA.length(); i++) {
            arrayA[i] = stringA.charAt(stringA.length() - 1 - i) - '0';
        }
        for (int i = 0; i < stringB.length(); i++) {
            arrayB[i] = stringB.charAt(stringB.length() - 1 - i) - '0';
        }

        for (int i = 0; i < stringA.length(); i++) {
            for (int j = 0; j < stringB.length(); j++) {
                Multiply[i + j] += arrayA[i] * arrayB[j];
            }
        }
        String ret = "";
        int carry = 0;
        for (int i = 0; i < Multiply.length; i++) {
            int tmp = Multiply[i] + carry;
            ret = String.valueOf(tmp % 10) + ret;
            carry = tmp / 10;
        }
        if (carry != 0) {
            ret = String.valueOf(carry) + ret;
        }
        int tmp = Integer.parseInt(ret);
        ret = Integer.toString(tmp);
        return ret;
    }
}