class Training012 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        BigNumberSum b = new BigNumberSum();
        System.out.println(b.dobigNumberSum("123456789", "98765432123454"));
    }
}

class BigNumberSum {
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
}