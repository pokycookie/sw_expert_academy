package ssafy11.precourse.hard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1868 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static char[][] map;
    static int[][] bomb;
    static boolean[][] visited;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static int n;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            map = new char[n][n];
            visited = new boolean[n][n];
            bomb = new int[n][n];

            for (int j = 0; j < n; j++) {
                map[j] = br.readLine().toCharArray();
            }

            bw.write(String.format("#%d %d", i + 1, solution()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int solution() {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*') {
                    visited[i][j] = true;
                }
                bomb[i][j] = check(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || bomb[i][j] != 0) {
                    continue;
                }
                cnt++;
                dfs(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                cnt++;
                dfs(i, j);
            }
        }

        return cnt;
    }

    static void dfs(int row, int column) {
        if (visited[row][column]) {
            return;
        }
        visited[row][column] = true;
        if (bomb[row][column] != 0) {
            return;
        }
        for (int[] d : direction) {
            int nextRow = row + d[0];
            int nextColumn = column + d[1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n) {
                continue;
            }
            if (visited[nextRow][nextColumn]) {
                continue;
            }
            dfs(nextRow, nextColumn);
        }
    }

    static int check(int row, int column) {
        if (map[row][column] == '*') {
            return -1;
        }

        int acc = 0;
        for (int[] d : direction) {
            int currRow = row + d[0];
            int currColumn = column + d[1];
            if (currRow < 0 || currRow >= n || currColumn < 0 || currColumn >= n) {
                continue;
            }
            if (d[0] == 0 && d[1] == 0) {
                continue;
            }
            if (map[currRow][currColumn] == '*') {
                acc++;
            }
        }
        return acc;
    }
}
