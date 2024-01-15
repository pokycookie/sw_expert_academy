package ssafy11.swexpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution1859 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int ct = 0; ct < t; ct++) {
            bw.write(String.format("#%d %d", ct + 1, solution()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static long solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] sequence = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long ans = 0;
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curr = sequence[i];
            ans += Math.max(0, max - curr);
            max = Math.max(max, curr);
        }

        return ans;
    }
}

