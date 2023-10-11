import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int cnt[][];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int chess[][] = new int[N][M];

    }

    private static void prob11660() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][N];
        long sum[][] = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(i == 0 && j == 0)
                    sum[i][j] = arr[i][j];
                else if(j == 0)
                    sum[i][j] = sum[i-1][j] + arr[i][j];
                else if(i == 0)
                    sum[i][j] = sum[i][j-1] + arr[i][j];
                else
                    sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arr[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;

            long res = 0;
            if(x1 == 0 && y1 == 0) //x1, y1이 0이면 sum[x2][y2]자체
                res = sum[x2][y2];
            else if(x1 == 0)  //x1 == 0이면, 열만 빼면 됨.
                res = sum[x2][y2] - sum[x2][y1-1];
            else if (y1 == 0) //y1 == 0이면, 행만 빼면 됨.
                res = sum[x2][y2] - sum[x1-1][y2];
            else
                res = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];

            sb.append(res).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob16139() throws IOException {
        String str = br.readLine();
        cnt = new int[str.length()+1][26];
        for (int i = 1; i <= str.length(); i++) {
            int idx = str.charAt(i-1) - 'a';
            for (int j = 0; j < 26; j++) {
                if(idx == j)
                    cnt[i][j] = cnt[i-1][j]+1;
                else
                    cnt[i][j] = cnt[i-1][j];
            }
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            int idx = c.charAt(0)-'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int res = cnt[r+1][idx]-cnt[l][idx];
            sb.append(res).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2559() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N+1];
        int sum1[] = new int[N+1]; //전체 누적합
        int sum2[] = new int[N-M+1]; //M개 이상 됐을때 이전의 값들의 누적합

        int cnt = 1; //누적합 요소 개수
        int idx = 0; //M개 이상 누적합 한 후, M개씩 끊어서 저장한 sum2의 인덱스
        int max = -10000001;
        sum1[0] = 0;
        /**
         * i까지의 누적합 - 0~i-M까지의 누적합
         */
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum1[i] = sum1[i-1] + arr[i];
            if(cnt >= M){
                sum2[idx] = sum1[i] - sum1[i-M];
                max = Math.max(max, sum2[idx]);
                idx++;
            }
            cnt++;
        }

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11659() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sum[0] = 0;
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1]+arr[i-1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sum[end]-sum[start-1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}