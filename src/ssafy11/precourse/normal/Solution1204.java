package ssafy11.precourse.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution1204 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String testcase = br.readLine();
            List<Integer> sequence = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            int ans = solution(sequence);
            bw.write(String.format("#%s %d", testcase, ans));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int solution(List<Integer> sequence) {
        Map<Integer, Integer> scoreMap = new HashMap<>();
        sequence.forEach(score -> {
            if (!scoreMap.containsKey(score)) {
                scoreMap.put(score, 0);
            }
            scoreMap.put(score, scoreMap.get(score) + 1);
        });

        int result = -1;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> e : scoreMap.entrySet()) {
            if (e.getValue() > maxCount) {
                result = e.getKey();
                maxCount = e.getValue();
            }
            if (e.getValue() == maxCount && e.getKey() > result) {
                result = e.getKey();
            }
        }

        return result;
    }
}
