import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _7_13 {

//    https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/submissions/

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value : nums1) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (int item : nums2) {
            if (map.containsKey(item)) {
                int value = map.get(item);
                if (value > 0) {
                    map.put(item, value - 1);
                    res.add(item);
                }
            }
        }

        int[] temp = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            temp[i] = res.get(i);
        }

        return temp;

    }
}
