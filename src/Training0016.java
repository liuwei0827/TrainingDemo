class Training016 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(new DP().qingWa(5));
        int[] coinValue = new int[] { 25, 21, 10, 5, 1 };
        int money = 63;
        int[] coinsUsed = new int[money + 1];
        new DP().makeChange(coinValue, coinValue.length, money, coinsUsed);
        System.out.println("面值为 " + (money) + " 的最小硬币数 : " + coinsUsed[money]);

    }
}

class DP {
    // 青蛙跳台问题
    public int qingWa(int a) {
        if (a == 1) {
            return 1;
        } else if (a == 2) {
            return 2;
        } else {
            return qingWa(a - 1) + qingWa(a - 2);
        }
    }

    // 硬币找零
    public static void makeChange(int[] values, int valueKinds, int money, int[] coinsUsed) {
        coinsUsed[0] = 0;
        for (int cents = 1; cents <= money; cents++) {
            int minCoins = cents;
            for (int kind = 0; kind < valueKinds; kind++) {
                if (values[kind] <= cents) {
                    int tmp = coinsUsed[cents - values[kind]] + 1;
                    if (tmp < minCoins) {
                        minCoins = tmp;
                    }
                }
            }
            coinsUsed[cents] = minCoins;
        }
    }
}