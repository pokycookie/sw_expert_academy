package ssafy11.precourse.hard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1248 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            solution(i + 1);
        }
        bw.flush();
        bw.close();
    }

    public static void solution(int t) throws IOException {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        Tree tree = new Tree(v);

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < e; j++) {
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            tree.add(parent, child);
        }

        int parent = tree.getCommonParent(v1, v2);
        int size = tree.getSubtreeSize(parent);

        bw.write(String.format("#%d %d %d", t, parent, size));
        bw.newLine();
    }
}

class Tree {
    private final int[] parentGraph;
    private final List<Integer>[] childGraph;

    public Tree(int size) {
        parentGraph = new int[size + 1];
        childGraph = new List[size + 1];

        for (int i = 0; i < size + 1; i++) {
            childGraph[i] = new ArrayList<>();
        }
    }

    public void add(int parent, int child) {
        childGraph[parent].add(child);
        parentGraph[child] = parent;
    }

    private List<Integer> getAllParents(int vertex) {
        List<Integer> result = new ArrayList<>();
        if (vertex == 1) {
            result.add(1);
            return result;
        }
        result.add(vertex);
        result.addAll(getAllParents(parentGraph[vertex]));
        return result;
    }

    public int getCommonParent(int v1, int v2) {
        List<Integer> parents1 = getAllParents(v1);
        List<Integer> parents2 = getAllParents(v2);

        for (int p1 : parents1) {
            for (int p2 : parents2) {
                if (p1 == p2) {
                    return p1;
                }
            }
        }
        return 1;
    }

    public int getSubtreeSize(int vertex) {
        int size = 1;

        for (int child : childGraph[vertex]) {
            size += getSubtreeSize(child);
        }
        return size;
    }
}
