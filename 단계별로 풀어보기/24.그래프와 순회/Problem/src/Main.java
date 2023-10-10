import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int visit[];
    static boolean visited[];
    static int cnt = 1;
    static int res = 0;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {

    }

    private static void prob1260() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i+1), new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            edge.get(node1).add(node2);
            edge.get(node2).add(node1);
        }
        sb.append(V).append(" ");
        dfs1260(edge, V);
        sb.append("\n");

        queue = new LinkedList<>();
        visited = new boolean[N+1];
        bfs1260(edge, V);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs1260(Map<Integer, ArrayList<Integer>> edge, int v) {
        visited[v] = true;
        Collections.sort(edge.get(v));
        for (int i = 0; i < edge.get(v).size(); i++) {
            if(!visited[edge.get(v).get(i)]) {
                sb.append(edge.get(v).get(i)).append(" ");
                dfs1260(edge, edge.get(v).get(i));
            }
        }
    }
    private static void bfs1260(Map<Integer, ArrayList<Integer>> edge, int v) {
        queue.add(v);
        visited[v] = true;
        sb.append(v).append(" ");
        while (!queue.isEmpty()) {
            int q = queue.poll();
            Collections.sort(edge.get(q));
            for (int i = 0; i < edge.get(q).size(); i++) {
                if(!visited[edge.get(q).get(i)]){
                    visited[edge.get(q).get(i)] = true;
                    queue.add(edge.get(q).get(i));
                    sb.append(edge.get(q).get(i)).append(" ");
                }
            }
        }
    }

    private static void prob2606_bfs() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i+1), new ArrayList<>());
        }
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            edge.get(node1).add(node2);
            edge.get(node2).add(node1);
        }
        bfs2606(edge, 1);

        int count = 0;
        for (int i = 2; i <= N; i++) {
            if(visited[i])
                count++;
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs2606(Map<Integer, ArrayList<Integer>> edge, int start) {
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()){
            int q = queue.poll();
            for (int i = 0; i < edge.get(q).size(); i++) {
                if(!visited[edge.get(q).get(i)]){
                    visited[edge.get(q).get(i)] = true;
                    queue.add(edge.get(q).get(i));
                }
            }
        }
    }

    private static void prob2606_dfs() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i+1), new ArrayList<>());
        }
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            edge.get(node1).add(node2);
            edge.get(node2).add(node1);
        }
        dfs2606(edge, 1);
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if(visited[i])
                count++;
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs2606(Map<Integer, ArrayList<Integer>> edge, int start) {
        visited[start] = true;
        for (int i = 0; i < edge.get(start).size(); i++) {
            if(!visited[edge.get(start).get(i)]){
                dfs2606(edge, edge.get(start).get(i));
            }
        }
    }

    private static void prob24445() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visit = new int[N+1];
        queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i + 1), new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            edge.get(e1).add(e2);
            edge.get(e2).add(e1);
        }
        bfs24445(edge, R);
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs24445(Map<Integer, ArrayList<Integer>> edge, int r){
        visit[r] = cnt++;
        queue.add(r);
        while (!queue.isEmpty()) {
            int q = queue.remove();
            Collections.sort(edge.get(q), Collections.reverseOrder());
            for (int i = 0; i < edge.get(q).size(); i++) {
                if (visit[edge.get(q).get(i)] == 0) {
                    visit[edge.get(q).get(i)] = cnt++;
                    queue.add(edge.get(q).get(i));
                }
            }
        }
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