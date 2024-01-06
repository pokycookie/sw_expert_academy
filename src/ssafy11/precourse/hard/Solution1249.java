package ssafy11.precourse.hard;

import java.util.*;
import java.io.*;

public class Solution1249 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

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
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(Character.toString(input[j]));
            }
        }

        PriorityQueue<Path> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        queue.add(new Path(0, 0, 0));

        while (!queue.isEmpty()) {
            Path curr = queue.poll();
            if (curr.weight > dist[curr.row][curr.column]) {
                continue;
            }
            for (int[] d : direction) {
                int nextRow = curr.row + d[0];
                int nextColumn = curr.column + d[1];

                if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n) {
                    continue;
                }

                int nextPath = curr.weight + graph[nextRow][nextColumn];
                if (nextPath < dist[nextRow][nextColumn]) {
                    dist[nextRow][nextColumn] = nextPath;
                    queue.add(new Path(nextRow, nextColumn, nextPath));
                }
            }
        }

        return dist[n - 1][n - 1];
    }
}

class Path {
    int row;
    int column;
    int weight;

    public Path(int row, int column, int weight) {
        this.row = row;
        this.column = column;
        this.weight = weight;
    }
}
