
class Solution {
    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        boolean[] ans = new boolean[q];

        long[] h1 = new long[n];
        long[] h2 = new long[n];

        for (int i = 0; i < n; i++) {
            h1[i] = splitMix64(nums[i]);
            h2[i] = splitMix64(nums[i] + 1_000_003);
        }

        XorSegTree xorTree1 = new XorSegTree(h1);
        XorSegTree xorTree2 = new XorSegTree(h2);

        int maxValue = 100_000;
        int[] lastSeen = new int[maxValue + 1];
        Arrays.fill(lastSeen, -1);

        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = lastSeen[nums[i]];
            lastSeen[nums[i]] = i;
        }

        List<List<Integer>> byR = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            byR.add(new ArrayList<>());
        }

        for (int i = 0; i < q; i++) {
            byR.get(queries[i][1]).add(i);
        }

        SumSegTree distinctTree = new SumSegTree(n);

        for (int r = 0; r < n; r++) {
            if (prev[r] != -1) {
                distinctTree.update(prev[r], -1);
            }

            distinctTree.update(r, 1);

            for (int qi : byR.get(r)) {
                int l = queries[qi][0];

                if (distinctTree.query(l, r) != k) {
                    continue;
                }

                if (xorTree1.query(l, r) == 0 &&
                    xorTree2.query(l, r) == 0) {
                    ans[qi] = true;
                }
            }
        }

        return ans;
    }

    private long splitMix64(long x) {
        x += 0x9E3779B97F4A7C15L;
        x = (x ^ (x >>> 30)) * 0xBF58476D1CE4E5B9L;
        x = (x ^ (x >>> 27)) * 0x94D049BB133111EBL;
        return x ^ (x >>> 31);
    }

    static class SumSegTree {
        int n;
        int[] tree;

        SumSegTree(int n) {
            this.n = n;
            tree = new int[2 * n];
        }

        void update(int pos, int delta) {
            pos += n;
            tree[pos] += delta;

            for (pos >>= 1; pos >= 1; pos >>= 1) {
                tree[pos] = tree[2 * pos] + tree[2 * pos + 1];
            }
        }

        int query(int l, int r) {
            int res = 0;

            l += n;
            r += n + 1;

            while (l < r) {
                if ((l & 1) == 1) {
                    res += tree[l++];
                }

                if ((r & 1) == 1) {
                    res += tree[--r];
                }

                l >>= 1;
                r >>= 1;
            }

            return res;
        }
    }

    static class XorSegTree {
        int n;
        long[] tree;

        XorSegTree(long[] arr) {
            n = arr.length;
            tree = new long[2 * n];

            System.arraycopy(arr, 0, tree, n, n);

            for (int i = n - 1; i >= 1; i--) {
                tree[i] = tree[2 * i] ^ tree[2 * i + 1];
            }
        }

        long query(int l, int r) {
            long res = 0;

            l += n;
            r += n + 1;

            while (l < r) {
                if ((l & 1) == 1) {
                    res ^= tree[l++];
                }

                if ((r & 1) == 1) {
                    res ^= tree[--r];
                }

                l >>= 1;
                r >>= 1;
            }

            return res;
        }
    }
}