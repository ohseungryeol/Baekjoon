package Programmers.Lv3.양과늑대;

import java.util.*;

class Solution {
    List<Integer>[] graph;
    int ans = 0;

    public int solution(int[] info, int[][] edges) {

        int n = info.length;
        graph = new List[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        go(0, info, 1, 0, new HashSet<>());
        return ans;
    }

    void go(int idx, int[] info, int sheep, int wolv, Set<Integer> unused) {
        if(sheep == wolv) return;

        ans = Math.max(sheep, ans);

        for(int next : graph[idx]) unused.add(next);

        for(int next : unused) {
            Set<Integer> set = new HashSet<>(unused);
            set.remove(next);
            if(info[next] == 1)
                go(next, info, sheep, wolv + 1, set);
            else go(next, info, sheep+1, wolv, set);
        }
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1}, new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}});
    }
}