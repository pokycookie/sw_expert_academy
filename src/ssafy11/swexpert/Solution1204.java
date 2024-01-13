package ssafy11.swexpert;

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
            String test = br.readLine();
            bw.write(String.format("#%s %d", test, solution()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static long solution() throws IOException {
        List<Integer> sequence = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Map<Integer, Integer> map = new HashMap<>();
        sequence.forEach(key -> {
            if (!map.containsKey(key)) {
                map.put(key, 0);
            }
            map.put(key, map.get(key) + 1);
        });

        int ans = 0;
        int max = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value > max) {
                ans = key;
                max = value;
            } else if (value == max && key > ans) {
                ans = key;
                max = value;
            }
        }

        return ans;
    }
}

