package ssafy11.precourse.hard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution4193 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static Pos start, end;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n][n];

            map = new int[n][n];
            for (int j = 0; j < n; j++) {
                map[j] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            st = new StringTokenizer(br.readLine());
            start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (isBlocked()) {
                bw.write(String.format("#%d -1", i + 1));
                bw.newLine();
                continue;
            }

            bw.write(String.format("#%d %d", i + 1, solution()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int solution() {
        Set<Pos> positions = new HashSet<>();
        positions.add(start);
        visited[start.y][start.x] = true;

        int t = 0;
        while (true) {
            t++;
            Set<Pos> tmp = new HashSet<>(positions);
            for (Pos curr : tmp) {
                for (int[] d : direction) {
                    int nextY = curr.y + d[0];
                    int nextX = curr.x + d[1];
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                        continue;
                    }
                    if (visited[nextY][nextX]) {
                        continue;
                    }
                    if (map[nextY][nextX] == 1) {
                        continue;
                    }
                    if (map[nextY][nextX] == 2 && t % 3 != 0) {
                        continue;
                    }
                    visited[nextY][nextX] = true;
                    positions.add(new Pos(nextY, nextX));
                }
            }
            if (visited[end.y][end.x]) {
                return t;
            }
        }
    }

    static boolean isBlocked() {
        boolean[][] visited = new boolean[n][n];
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = true;

        while (!q.isEmpty()) {
            Pos curr = q.poll();
            for (int[] d : direction) {
                int nextY = curr.y + d[0];
                int nextX = curr.x + d[1];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    continue;
                }
                if (visited[nextY][nextX]) {
                    continue;
                }
                if (map[nextY][nextX] == 1) {
                    continue;
                }
                visited[nextY][nextX] = true;
                q.add(new Pos(nextY, nextX));
            }
        }

        return !visited[end.y][end.x];
    }

    static class Pos {
        int x, y;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
