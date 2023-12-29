package ssafy11.precourse.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution1961 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[][] graph;
    static int n;

    public static void main(String[] args) throws IOException {
        int maxCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < maxCase; t++) {
            solution(t + 1);
        }
        bw.flush();
        bw.close();
    }

    static void solution(int testcase) throws IOException {
        n = Integer.parseInt(br.readLine());
        graph = new String[n][n];

        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine().split(" ");
        }

        List<List<String>> case1 = rotate();
        List<List<String>> case2 = rotate();
        List<List<String>> case3 = rotate();

        bw.write(String.format("#%d%n", testcase));
        for (int i = 0; i < n; i++) {
            String s1 = String.join("", case1.get(i));
            String s2 = String.join("", case2.get(i));
            String s3 = String.join("", case3.get(i));
            bw.write(String.join(" ", s1, s2, s3));
            bw.newLine();
        }
    }

    static List<List<String>> rotate() {
        List<List<String>> result = new ArrayList<>();
        for (int column = 0; column < n; column++) {
            List<String> line = new ArrayList<>();
            for (int row = n - 1; row >= 0; row--) {
                line.add(graph[row][column]);
            }
            result.add(line);
        }
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                graph[row][column] = result.get(row).get(column);
            }
        }
        return result;
    }
}
