import java.util.ArrayList;
import java.util.List;

public class _7_08 {

    public int[] divingBoard(int shorter, int longer, int k) {

        if (k == 0) {
            return new int[]{};
        }

        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        List<Integer> list = new ArrayList<>();

        int temp = shorter * k;
        list.add(temp);
        for (int i = k; i > 0; i--) {
            temp = temp - shorter + longer;
            list.add(temp);
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int shorter = 1;
        int longer = 2;

        int k = 3;
        int[] res = new _7_08().divingBoard(shorter, longer, k);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
