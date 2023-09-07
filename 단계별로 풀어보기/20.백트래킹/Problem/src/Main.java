import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int arr[];
    static boolean visit[];
    public static void main(String[] args) throws IOException {

    }

    private static void prob15649() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs15649(N, M, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs15649(int N, int M, int depth){
        if(depth == M){
            for (int i : arr)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i+1;
                dfs15649(N, M, depth+1);
                visit[i] = false;
            }
        }
    }
}