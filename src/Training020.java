
public class Training020 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new BinarySolution().numberOf1(n));
    }
}

// 位运算算法
class BinarySolution {
    // 判断一个数的二进制表示中1出现的个数
    public int numberOf1(int n) {
        int count = 0;
        int flag = 1;
        for (int i = 0; i < 32; i++) {
            if ((flag & n) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}