package ssafy11.precourse.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] n = br.readLine().toCharArray();

        int acc = 0;
        for (char c : n) {
            acc += Integer.parseInt(Character.toString(c));
        }
        System.out.println(acc);
    }
}
