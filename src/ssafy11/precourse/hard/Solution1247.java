package ssafy11.precourse.hard;

import java.util.*;
import java.io.*;

public class Solution1247 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, ans, acc;
    static Pos[] positions;
    static boolean[] visited;
    static Stack<Integer> stack;
    static Pos start, end;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            solution();
            bw.write(String.format("#%d %d", i + 1, ans));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        stack = new Stack<>();
        positions = new Pos[n];
        visited = new boolean[n];
        ans = Integer.MAX_VALUE;

        start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            positions[i] = new Pos(x, y);
        }

        backtracking(start, 0);
    }

    static void backtracking(Pos prev, int depth) {
        if (depth == n) {
            ans = Math.min(ans, acc + prev.move(end));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            acc += prev.move(positions[i]);
            visited[i] = true;
            backtracking(positions[i], depth + 1);
            visited[i] = false;
            acc -= prev.move(positions[i]);
        }
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int move(Pos target) {
            return Math.abs(x - target.x) + Math.abs(y - target.y);
        }
    }
}
