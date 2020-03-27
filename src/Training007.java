class Training007 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] a = { 1, 3, 3, 4, 6, 2, 5, 7 };
        FindNumber s = new FindNumber();
        System.out.println(s.getDuplicationNumber(a));
    }
}

class FindNumber {
    // 在一个长度为n的数组中所有数字在0-n-1范围，
    // 找出任意一个重复的数字
    public int getDuplicationNumber(int[]src){
        for(int i=0;i<src.length;i++){
            while(src[i]!=i){
                if(src[i]==src[src[i]]){
                    return src[i];
                }
                int tmp=src[i];
                src[i]=src[tmp];
                src[tmp]=tmp;
            }
        }
        return -1;
    }


    public int getDuplicationNumber2(int[]src){
        if (src == null) {
            return -1;
        }
        int low = 0;
        int high = src.length - 1;
        int mid = 0;
        int countNumber = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            countNumber = count(src, low, mid);
            if (low == high) {
                if (countNumber > 1) {
                    return low;
                }else{
                    break;
                }
            }
            if (countNumber > mid - low + 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int count(int[] src, int start, int end) {
        if (src == null) {
            return 0;
        }
        int count = 0;
        for (int var : src) {
            if (var >= start && var <= end) {
                count++;
            }
        }
        return count;
    }
}