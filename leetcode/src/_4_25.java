import java.util.ArrayList;
import java.util.List;


//https://leetcode-cn.com/problems/permutations/

public class _4_25 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        helper(nums);
        return res;
    }

    public void helper(int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            helper(nums);
            list.remove(list.size() - 1);
        }
    }
}
