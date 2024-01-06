package ssafy11.precourse.hard;

import java.util.*;
import java.io.*;

public class Solution1247 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static Pos[] positions;
    static boolean[] visited;
    static Stack<Integer> stack;
    static int ans;
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

        backtracking();
    }

    static void backtracking() {
        if (stack.size() == n) {
            List<Integer> sequence = new ArrayList<>(stack);
            ans = Math.min(ans, getDistance(sequence));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            stack.push(i);
            visited[i] = true;
            backtracking();
            visited[i] = false;
            stack.pop();
        }
    }

    static int getDistance(List<Integer> sequence) {
        int acc = 0;

        Pos prev = start;
        for (Integer i : sequence) {
            Pos curr = positions[i];
            acc += prev.move(curr);
            prev = curr;
        }
        acc += prev.move(end);

        return acc;
    }
}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int move(Pos target) {
        return Math.abs(x - target.x) + Math.abs(y - target.y);
    }
}
