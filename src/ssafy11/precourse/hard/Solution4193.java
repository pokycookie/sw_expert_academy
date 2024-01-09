package ssafy11.precourse.hard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4193 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[][] map;
    static List<int[]> obstacle;
    static boolean[][] visited;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            for (int j = 0; j < n; j++) {
                map[j] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            obstacle = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                for (int column = 0; column < n; column++) {
                    if (map[row][column] == 2) {
                        obstacle.add(new int[] { row, column });
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            Pos start = new Pos(st.nextToken(), st.nextToken(), 0);

            st = new StringTokenizer(br.readLine());
            Pos end = new Pos(st.nextToken(), st.nextToken(), 0);

            visited = new boolean[n][n];
            solution(start, end);
        }
    }

    static void solution(Pos start, Pos end) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Pos curr = queue.poll();

            if (map[curr.y][curr.x] == 2 && curr.depth % 3 != 2) {

            }

            for (int[] d : direction) {
                int nextY = curr.y + d[0];
                int nextX = curr.x + d[1];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= n) {
                    continue;
                }
                if (visited[nextY][nextX] || map[nextY][nextX] == 1) {
                    continue;
                }
                if (map[nextY][nextX] == 2 && curr.depth % 3 != 2) {
                    continue;
                }

                queue.offer(new Pos(nextY, nextX, curr.depth + 1));
            }
        }
    }

    static class Pos {
        int x, y, depth;

        public Pos(int y, int x, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        public Pos(String x, String y, int depth) {
            this(Integer.parseInt(x), Integer.parseInt(y), depth);
        }
    }
}
