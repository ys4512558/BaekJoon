import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] res;
    public static void main(String[] args) throws IOException {
        prob1010();

    }

    private static void prob1010() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            res = new int[M+1][N+1];

            sb.append(dynamic(M, N)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11050() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        res = new int[N+1][K+1];

        sb.append(dynamic(N, K));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int dynamic(int N, int K){
        if(res[N][K] > 0){
            return res[N][K];
        }

        if (N == K || K == 0) {
            res[N][K] = 1;
            return res[N][K];
        }
        res[N][K] = dynamic(N-1, K-1) + dynamic(N-1, K);
        return res[N][K];
    }


    private static void prob10872() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int res = 1;
        for (int i = 1; i <= N; i++) {
            res *= i;
        }
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob24723() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        sb.append((int) Math.pow(2, N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob15439() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(N * (N - 1));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}