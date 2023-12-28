package ssafy11.precourse.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution2068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int max = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .max()
                    .orElse(0);
            bw.write(String.format("#%d %d", i + 1, max));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
