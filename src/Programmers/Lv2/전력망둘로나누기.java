package Programmers.Lv2;

public class 전력망둘로나누기 {
    public int solution(int n, int[][] wires) {
        int answer = n;
        int[] parents = new int[n + 1];

        for (int i = 0; i < wires.length; i++) {

            for (int m = 1; m <= n; m++) parents[m] = m;

            for (int j = 0; j < wires.length; j++) {
                if (j != i) {
                    int start = wires[j][0];
                    int end = wires[j][1];
                    unionParent(parents, start, end);
                }
            }

            int a = 0;
            int b = 0;
            int pivot = parents[1];
            for (int k = 1; k <= n; k++) {

                if (parents[k] == pivot) a++;
                else b++;
            }

            answer = Math.min(answer, Math.abs(a - b));
        }
        System.out.println(answer);
        return answer;
    }

    public static int getParent(int[] parents, int x) {
        if (parents[x] == x) return x;
        return parents[x] = getParent(parents, parents[x]);
    }

    public static void unionParent(int[] parents, int a, int b) {

        a = getParent(parents, a);
        b = getParent(parents, b);

        if (a < b) parents[b] = a;
        else parents[a] = b;
    }


    public static void main(String[] args) {
        전력망둘로나누기 main = new 전력망둘로나누기();
        main.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
    }
}
