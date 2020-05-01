import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/submissions/

public class _1337 {

//    public int[] kWeakestRows(int[][] mat, int k) {
//
//        int[] temp = new int[mat.length];
//
//        for (int i = 0; i < mat.length; i++) {
//            int index = 0;
//            for (int j = 0; j < mat[0].length; j++) {
//                if (j == mat[0].length - 1 && mat[i][j] != 0) {
//                    index = mat[0].length;
//                    break;
//                }
//                if (mat[i][j] == 0) {
//                    index = j;
//                    break;
//                }
//            }
//            temp[i] = index;
//        }
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        for (int i = 0; i < temp.length; i++) {
//            queue.add(temp[i]);
//        }
//
//        ArrayList<Integer> temp1 = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            temp1.add(queue.poll());
//        }
//
//        ArrayList<Integer> res = new ArrayList<>();
//
//        for (int i = 0 , j = 0; i < temp.length; i++) {
//            if (temp1.isEmpty()) {
//                break;
//            }
//            if (temp[i] == temp1.indexOf(j)) {
//                res.add(i);
//                temp1.remove(temp1.indexOf(j));
//                j++;
//            }
//        }
//
//        int[] readres = new int[k];
//
//        for (int i = 0; i < k; i++) {
//            readres[i] = res.indexOf(i);
//        }
//
//        return readres;
//    }

    public int[] kWeakestRows(int[][] mat, int k) {

        int len = mat.length;
        int[][] list = new int[len][2];
        for (int i = 0; i < len; i++) {
            list[i][0] = getCount(mat[i]);
            list[i][1] = i;
        }
        Arrays.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list[i][1];
        }
        return res;
    }

    private int getCount(int[] arr) {
        int c = 0;
        for (int num : arr) {
            if (num == 0) {
                break;
            }
            c++;
        }
        return c;
    }

    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        int m = in.nextInt();
//        int n = in.nextInt();
//        int[][] mat = new int[][];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                mat[i][j] = in.nextInt();
//            }
//        }
//
//        int k = in.nextInt();

        int[][] mat = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int k = 3;

        int[] temp = new _1337().kWeakestRows(mat, k);
        System.out.println(temp);
    }


}
