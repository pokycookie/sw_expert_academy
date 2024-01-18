package ssafy11.swexpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringJoiner;

public class Solution2005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write(String.format("#%d", i + 1));
            bw.newLine();
            solution();
        }
        bw.flush();
        bw.close();
    }

    static void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        map[0][0] = 1;
        bw.write("1");
        bw.newLine();

        for (int i = 1; i < n; i++) {
            StringJoiner sj = new StringJoiner(" ");
            for (int j = 0; j < i + 1; j++) {
                int left = 0;
                int right = map[i - 1][j];

                if (j - 1 >= 0) {
                    left = map[i - 1][j - 1];
                }

                map[i][j] = left + right;
                sj.add(Integer.toString(left + right));
            }
            bw.write(sj.toString());
            bw.newLine();
        }
    }
}

