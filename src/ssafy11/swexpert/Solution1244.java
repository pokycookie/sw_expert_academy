package ssafy11.swexpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1244 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static char[] seq;
    static int n;
    static int ans;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            seq = st.nextToken().toCharArray();
            n = Integer.parseInt(st.nextToken());
            ans = 0;

            backtracking(0);
            bw.write(String.format("#%d %d", i + 1, ans));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void backtracking(int cnt) {
        if (cnt == n) {
            int res = Integer.parseInt(new String(seq));
            ans = Math.max(ans, res);
            return;
        }
        for (int i = 0; i < seq.length - 1; i++) {
            for (int j = i + 1; j < seq.length; j++) {
                swap(i, j);
                backtracking(cnt + 1);
                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {
        char tmp = seq[i];
        seq[i] = seq[j];
        seq[j] = tmp;
    }
}
