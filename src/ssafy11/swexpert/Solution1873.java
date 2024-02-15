package ssafy11.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution1873 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int h, w;
    static char[][] map;
    static Tank tank;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[] shape = {'^', 'v', '<', '>'};
    static HashMap<Character, Integer> cm = new HashMap<>();

    static {
        cm.put('U', 0);
        cm.put('D', 1);
        cm.put('L', 2);
        cm.put('R', 3);
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            solution();
            sb.append("#").append(t + 1).append(" ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                switch (map[i][j]) {
                    case '<':
                        tank = new Tank(i, j, 2);
                        break;
                    case '^':
                        tank = new Tank(i, j, 0);
                        break;
                    case 'v':
                        tank = new Tank(i, j, 1);
                        break;
                    case '>':
                        tank = new Tank(i, j, 3);
                        break;
                }
            }
        }

        Integer.parseInt(br.readLine());
        for (char command : br.readLine().toCharArray()) {
            if (command == 'S') tank.shoot();
            else tank.move(cm.get(command));
        }
    }

    static class Tank {
        int r;
        int c;
        int d;

        Tank(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

        void move(int i) {
            map[r][c] = shape[i];
            this.d = i;

            int nr = r + direction[i][0];
            int nc = c + direction[i][1];

            if (nr < 0 || nr >= h || nc < 0 || nc >= w) return;
            if (map[nr][nc] != '.') return;

            map[r][c] = '.';
            map[nr][nc] = shape[i];
            this.r = nr;
            this.c = nc;
        }

        void shoot() {
            int[] d = direction[this.d];
            int nr = r;
            int nc = c;

            while (true) {
                nr += d[0];
                nc += d[1];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) break;
                if (map[nr][nc] == '#') break;
                if (map[nr][nc] == '*') {
                    map[nr][nc] = '.';
                    break;
                }
            }
        }
    }
}
