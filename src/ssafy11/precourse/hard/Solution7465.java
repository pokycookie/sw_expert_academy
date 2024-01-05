package ssafy11.precourse.hard;

import java.util.*;
import java.io.*;

public class Solution7465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int result = solution();
            bw.write(String.format("#%d %d", i + 1, result));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i);
            cnt++;
        }

        return cnt;
    }

    static void dfs(int vertex) {
        visited[vertex] = true;
        for (int next : graph[vertex]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
