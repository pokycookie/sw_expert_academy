package ssafy11.swexpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= 10; t++) {
            bw.write(String.format("#%d %d", t, solution()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] sequence = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int ans = 0;
        for (int i = 2; i < n - 2; i++) {
            int curr = sequence[i];
            List<Integer> around = new ArrayList<>();
            for (int j = -2; j <= 2; j++) {
                if (j == 0) {
                    continue;
                }
                around.add(sequence[i + j]);
            }
            int max = Collections.max(around);
            ans += Math.max(0, curr - max);
        }

        return ans;
    }
}
