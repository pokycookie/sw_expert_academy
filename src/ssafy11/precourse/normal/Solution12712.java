package ssafy11.precourse.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution12712 {
    static int n, m;
    static int[][] graph;

    static int[][] direction1 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] direction2 = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int maxCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < maxCase; t++) {
            solution(t);
        }

        bw.flush();
        bw.close();
    }

    static void solution(int testcase) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for (int row = 0; row < n; row++) {
            graph[row] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int ans = 0;
        for (int row = 0; row < n; row ++) {
            for (int column = 0; column < n; column++) {
                int result = Math.max(spray(row, column, direction1), spray(row, column, direction2));
                ans = Math.max(ans, result);
            }
        }
        bw.write(String.format("#%d %d", testcase + 1, ans));
        bw.newLine();
    }

    static int spray(int row, int column, int[][] direction) {
        int acc = graph[row][column];
        for (int diff = 1; diff < m; diff++) {
            for (int[] d : direction) {
                int nextRow = row + d[0] * diff;
                int nextColumn = column + d[1] * diff;

                if (nextRow < 0 || nextRow >= n) {
                    continue;
                }
                if (nextColumn < 0 || nextColumn >= n) {
                    continue;
                }

                acc+= graph[nextRow][nextColumn];
            }
        }
        return acc;
    }
}
