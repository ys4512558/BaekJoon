import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int visit[];
    static int cnt = 1;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {

    }

    private static void prob24444() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visit = new int[N+1];
        queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i+1), new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            edge.get(e1).add(e2);
            edge.get(e2).add(e1);
        }
        bfs24444(edge, R);
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void bfs24444(Map<Integer, ArrayList<Integer>> edge, int r) {
        visit[r] = cnt++;
        queue.add(r);
        int q;
        while (!queue.isEmpty()){
            q = queue.remove();
            Collections.sort(edge.get(q));
            for (int i = 0; i < edge.get(q).size(); i++) {
                if(visit[edge.get(q).get(i)] == 0) {
                    visit[edge.get(q).get(i)] = cnt++;
                    queue.add(edge.get(q).get(i));
                }
            }
        }
    }

    private static void prob24480() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visit = new int[N+1];
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i+1), new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            edge.get(e1).add(e2);
            edge.get(e2).add(e1);
        }
        dfs24480(edge, R);
        for (int i = 1; i < visit.length; i++) {
            sb.append(visit[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void dfs24480(Map<Integer, ArrayList<Integer>> edge, int r) {
        visit[r] = cnt++;
        Collections.sort(edge.get(r), Collections.reverseOrder());
        for (int i = 0; i < edge.get(r).size(); i++) {
            if(visit[edge.get(r).get(i)] == 0)
                dfs24480(edge, edge.get(r).get(i));
        }
    }
    private static void prob24479() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visit = new int[N+1];
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i+1), new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            edge.get(e1).add(e2);
            edge.get(e2).add(e1);
        }
        dfs24479(edge, R);
        for (int i = 1; i < visit.length; i++) {
            sb.append(visit[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void dfs24479(Map<Integer, ArrayList<Integer>> edge, int r) {
        visit[r] = cnt++;
        Collections.sort(edge.get(r));
        for (int i = 0; i < edge.get(r).size(); i++) {
            if(visit[edge.get(r).get(i)] == 0)
                dfs24479(edge, edge.get(r).get(i));
        }
    }
}