import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/submissions/

public class _6_01 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = candies[0];

        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        List<Boolean> temp = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            int t = max - candies[i];

            if (t <= extraCandies) {
                temp.add(true);
            } else {
                temp.add(false);
            }
        }

        return temp;

    }
}
