package ssafy11.precourse.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1959 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int maxCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < maxCase; t++) {
            bw.write(String.format("#%d %d", t + 1, solution()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] lower = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] upper = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (n > m) {
            int[] tmp1 = lower.clone();
            lower = upper.clone();
            upper = tmp1;

            int tmp2 = n;
            n = m;
            m = tmp2;
        }

        int max = 0;
        for (int i = 0; i <= m - n; i++) {
            int acc = 0;
            for (int j = 0; j < n; j++) {
                acc += lower[j] * upper[j + i];
            }
            max = Math.max(max, acc);
        }

        return max;
    }
}
