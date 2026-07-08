class Solution {
    static final long MOD = 1_000_000_007L;

    class Node {
        long num;
        long sum;
        int len;

        Node(long num, long sum, int len) {
            this.num = num;
            this.sum = sum;
            this.len = len;
        }
    }

    Node[] tree;
    long[] pow10;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        pow10 = new long[n + 1];
        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        tree = new Node[4 * n];
        build(1, 0, n - 1, s);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            Node res = query(1, 0, n - 1,
                    queries[i][0], queries[i][1]);

            ans[i] = (int)((res.num * res.sum) % MOD);
        }

        return ans;
    }


    void build(int idx, int l, int r, String s) {
        if (l == r) {
            int d = s.charAt(l) - '0';

            if (d == 0) {
                tree[idx] = new Node(0, 0, 0);
            } else {
                tree[idx] = new Node(d, d, 1);
            }
            return;
        }

        int mid = (l + r) / 2;

        build(idx * 2, l, mid, s);
        build(idx * 2 + 1, mid + 1, r, s);

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }


    Node merge(Node a, Node b) {

        long newNum = (a.num * pow10[b.len] + b.num) % MOD;

        long newSum = a.sum + b.sum;

        int newLen = a.len + b.len;

        return new Node(newNum, newSum, newLen);
    }


    Node query(int idx, int l, int r, int ql, int qr) {

        if (qr < l || r < ql) {
            return new Node(0, 0, 0);
        }

        if (ql <= l && r <= qr) {
            return tree[idx];
        }

        int mid = (l + r) / 2;

        Node left = query(idx * 2, l, mid, ql, qr);
        Node right = query(idx * 2 + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }
}