package ssafy11.precourse.hard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution1247 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, ans;
    static Pos[] positions;
    static boolean[] visited;
    static Stack<Integer> stack;
    static Pos end;

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

        Pos start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            positions[i] = new Pos(x, y);
        }

        backtracking(start, 0, 0);
    }

    static void backtracking(Pos prev, int depth, int acc) {
        if (acc >= ans) {
            return;
        }
        if (depth == n) {
            ans = Math.min(ans, acc + prev.move(end));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            backtracking(positions[i], depth + 1, acc + prev.move(positions[i]));
            visited[i] = false;
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
