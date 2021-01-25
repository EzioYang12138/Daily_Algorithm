public class _01_25 {

    private static class UnionFind {
        int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int index) {
            while (index != parent[index]) {
                index = parent[index];
            }

            return index;
        }

        public void merge(int p , int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            parent[pRoot] = qRoot;
        }
    }

//    区域连接求数量的问题用并查集解决
//    大方块由N * N的个小方块组成
//    将小方块按照双线划分顺时针分为0,1,2,3 共4个区域
//    并且小方块之间是两两连接的 ，左方块的 1区域 与 右方块的 3区域连接，上方块的 2区域 与 下方块的 0 区域连接
//    当‘/’时，小方块的 0,3 区域连接， 1,2区域连接
//    当‘\\’时 ，小方块的 0,1区域连接，2,3区域连接
//    当‘ ’时，小方块4个区域连接
//    求区域个数实际是求有多少颗树

    /*  ________
     *  |\ 0 / |
     *  |  \/  |
     *  | 3/\ 1|
     *  | / 2 \|
     *  --------
     * 按如上划分每个 1x1 的方格为四个部分，并分配序号
     */

    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        UnionFind uf = new UnionFind(4 * len * len);

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                int start = 4 * (i * len + j);

                switch (grid[i].charAt(j)) {
                    case ' ':
                        uf.merge(start , start + 1);
                        uf.merge(start + 2 , start + 3);
                        uf.merge(start , start + 2);
                        break;

                    case '/':
                        uf.merge(start , start + 3);
                        uf.merge(start + 1 , start + 2);
                        break;

                    case '\\':
                        uf.merge(start , start + 1);
                        uf.merge(start + 2 , start + 3);
                        break;
                }

                if(i > 0) {
                    uf.merge(start , start - 4 * len + 2);
                }

                if(j > 0) {
                    uf.merge(start + 3 , start - 3);
                }
            }
        }

        int count = 0;
        for(int i = 0 ;i < uf.parent.length; i++) {
            if(i == uf.parent[i]) {
                count++;
            }
        }

        return count;
    }
}
