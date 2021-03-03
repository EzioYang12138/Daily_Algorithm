public class _03_03 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        int j = 0;


        for (int i = 0; i <= num; i++) {
            int count = 0;

            int k = i;

            while (k != 0) {
                count++;
                k = k & (k - 1);
            }

            res[j++] = count;
        }

        return res;
    }

    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {  //注意要从1开始，0不满足
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 5;
        int[] res = new _03_03().countBits(num);

        int a = 2;
    }
}
