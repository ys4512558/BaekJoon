import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int cnt[][];
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        cnt = new int[str.length()+1][26];
        for (int i = 1; i <= str.length(); i++) {
            int idx = str.charAt(i-1)-'a';
            cnt[idx][i] = cnt[idx][i-1]+1;
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            int idx = c.charAt(0)-'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int res = cnt[idx][r+1]-cnt[idx][l];
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