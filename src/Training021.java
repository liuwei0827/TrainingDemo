
public class Training021 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class IsUgly {
    // 判断丑数（只由2/3/5因式分解的数）123ddd
    public boolean IsUglyTrueorFalse(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 2;
        }
        return (number == 1) ? true : false;
    }

    int getUglyNumber(int index) {
        int number = 0;
        int UglyFound = 0;
        if (index <= 0) {
            return 0;
        }
        while (UglyFound < index) {
            number++;
            if (IsUglyTrueorFalse(number)) {
                UglyFound++;
            }
        }
        return number;
    }
}