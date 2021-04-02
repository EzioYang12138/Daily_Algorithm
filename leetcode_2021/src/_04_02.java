public class _04_02 {

    public int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }

        int len = height.length;
        int count = 0;

        int[] reorder = new int[len];

        reorder[len - 1] = 0;

        for (int i = len - 2; i >= 0; i--) {
            reorder[i] = Math.max(height[i + 1], reorder[i + 1]);
        }

        int[] order = new int[len];

        order[0] = 0;

        for (int i = 1; i < len; i++) {
            order[i] = Math.max(order[i - 1], height[i - 1]);
        }

        for (int i = 0; i < len; i++) {
            int t = Math.min(order[i], reorder[i]) - height[i];

            if (t > 0) {
                count += t;
            }
        }

        return count;
    }
}
