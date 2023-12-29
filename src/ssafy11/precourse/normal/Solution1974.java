package ssafy11.precourse.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1974 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        int maxCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < maxCase; t++) {
            int result = solution() ? 1 : 0;
            bw.write(String.format("#%d %d", t + 1, result));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static boolean solution() throws IOException {
        graph = new int[9][9];
        for (int i = 0; i < 9; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < 9; i++) {
            if (!checkLine(i)) {
                return false;
            }
        }

        for (int row = 0; row < 9; row += 3) {
            for (int column = 0; column < 9; column += 3) {
                if (!checkBox(row, column)) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean checkLine(int line) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if (!rowSet.add(graph[line][i])) {
                return false;
            }
            if (!columnSet.add(graph[i][line])) {
                return false;
            }
        }
        return true;
    }

    static boolean checkBox(int row, int column) {
        Set<Integer> boxSet = new HashSet<>();

        for (int r = row; r < row + 3; r++) {
            for (int c = column; c < column + 3; c++) {
                if (!boxSet.add(graph[r][c])) {
                    return false;
                }
            }
        }
        return true;
    }
}
