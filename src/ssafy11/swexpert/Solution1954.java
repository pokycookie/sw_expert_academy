package ssafy11.swexpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringJoiner;

public class Solution1954 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(String.format("#%d%n", i + 1));
            solution(n);
        }
        bw.flush();
        bw.close();
    }

    static void solution(int n) throws IOException {
        int d = 0;
        int cx = n - 1;
        int cy = 0;

        int cnt = 1;

        int[][] ans = new int[n][n];

        int max = n * n;
        for (int i = 0; i < n; i++) {
            ans[0][i] = cnt++;
        }
        n--;
        while (cnt <= max) {
            while (d++ < n) ans[++cy][cx] = cnt++;
            d = 0;
            while (d++ < n) ans[cy][--cx] = cnt++;
            d = 0;
            n--;
            while (d++ < n) ans[--cy][cx] = cnt++;
            d = 0;
            while (d++ < n) ans[cy][++cx] = cnt++;
            d = 0;
            n--;
        }

        StringJoiner sj;
        for (int[] a : ans) {
            sj = new StringJoiner(" ");
            for (int b : a) {
                sj.add(Integer.toString(b));
            }
            bw.write(sj.toString());
            bw.newLine();
        }
    }
}
