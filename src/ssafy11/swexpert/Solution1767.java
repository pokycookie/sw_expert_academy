package ssafy11.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1767 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, N;
    static int maxC, minL;
    static boolean[][] core, visited;
    static List<Pos> cores;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            solution();
            sb.append("#").append(t + 1).append(" ").append(minL).append("\n");
        }
        System.out.println(sb);
    }

    static void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        cores = new ArrayList<>();

        maxC = Integer.MIN_VALUE;
        minL = Integer.MAX_VALUE;

        core = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                if (st.nextToken().charAt(0) == '1') {
                    core[r][c] = true;
                    if (r != 0 && c != 0 && r != N - 1 && c != N - 1) cores.add(new Pos(r, c));
                }
            }
        }
        visited = new boolean[N][N];
        backtracking(0, 0);
    }

    static void backtracking(int idx, int cnt) {
        if (idx == cores.size()) {
            int L = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (visited[r][c]) L++;
                }
            }
            if (cnt > maxC) {
                maxC = cnt;
                minL = L;
            } else if (cnt == maxC && L < minL) {
                minL = L;
            }
            return;
        }
        for (int[] d : direction) {
            Pos curr = cores.get(idx);
            int nr = curr.r;
            int nc = curr.c;

            boolean[][] copied = copy();
            boolean connected = false;
            while (true) {
                nr += d[0];
                nc += d[1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    connected = true;
                    break;
                }
                if (visited[nr][nc]) break;
                if (core[nr][nc]) break;
                visited[nr][nc] = true;
            }
//			if (!connected) visited = copied;
            backtracking(idx + 1, connected ? cnt + 1 : cnt);
            visited = copied;
        }
    }

    static boolean[][] copy() {
        boolean[][] res = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res[i][j] = visited[i][j];
            }
        }
        return res;
    }

    static class Pos {
        int r;
        int c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

/*
2
7
1 1 1 1 1 1 1
1 0 0 1 0 0 1
1 0 0 0 0 0 1
1 1 0 0 0 0 0
1 0 0 0 0 0 1
0 0 0 0 0 1 1
1 1 1 0 1 1 1
9
0 0 0 1 0 1 1 1 0
1 0 0 1 0 0 0 0 0
1 0 0 1 0 0 0 0 0
1 0 0 0 0 0 1 1 1
0 0 0 0 1 0 0 0 0
1 1 1 0 0 0 0 0 1
0 0 0 0 0 1 0 0 1
0 0 0 0 0 1 0 0 1
0 1 1 1 0 1 0 0 0

#1 10
#2 40 (wrong: 41)
*/
