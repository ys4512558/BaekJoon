import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int cnt1 = 0; //prob24416
    static int cnt2 = 0; //prob24416

    static int f[]; //prob24416

    static int count[];

    static int cost[][];
    static int arr[][];

    public static void main(String[] args) throws IOException {

    }

    private static void prob1149() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        cost = new int[N][3];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            cost[0][i] = arr[0][i];
        }
        int res = Math.min(dp1149(N- 1, 0), Math.min(dp1149(N - 1, 1), dp1149(N - 1, 2)));
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int dp1149(int N, int color) {

        if(cost[N][color] == 0) {
            if(color == 0) {
                cost[N][0] = Math.min(dp1149(N - 1, 1), dp1149(N - 1, 2)) + arr[N][0];
            }
            else if(color == 1) {
                cost[N][1] = Math.min(dp1149(N - 1, 0), dp1149(N - 1, 2)) + arr[N][1];
            }
            else {
                cost[N][2] = Math.min(dp1149(N - 1, 0), dp1149(N - 1, 1)) + arr[N][2];
            }
        }
        return cost[N][color];
    }

    private static void prob1912() throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        int sum[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = sum[0] = arr[0];

        for (int i = 1; i < N; i++) {
            sum[i] = Math.max(sum[i - 1] + arr[i], arr[i]);
            max = Math.max(max, sum[i]);
        }

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1463_2() throws IOException {
        int N = Integer.parseInt(br.readLine());
        count = new int[N+1];
        Arrays.fill(count, 100000);
        count[N] = 0;
        dp1463_2(N);
        sb.append(count[1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    //Top-Down 방식
    private static int dp1463_2(int N) {
        if (N == 1) {
            return 0;
        }
        if(N % 3 == 0)
            count[N/3] = Math.min(count[N]+1, dp1463_2(count[N/3]));
        if(N % 2 == 0)
            count[N/2] = Math.min(count[N]+1, dp1463_2(count[N/2]));
        if(N-1 > 0)
            count[N-1] = Math.min(count[N]+1, dp1463_2(count[N-1]));

        return count[N];
    }


    private static void prob1463() throws IOException {
        int N = Integer.parseInt(br.readLine());
        count = new int[N+1];
        Arrays.fill(count, 100000);
        count[1] = 0;
        dp1463(N);
        sb.append(count[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    //Bottom-Up 방식
    private static void dp1463(int N) {
        for (int i = 1; i <= N; i++) {
            if(i+1 <= N)
                count[i+1] = Math.min(count[i]+1, count[i+1]);
            if(i*2 <= N)
                count[i*2] = Math.min(count[i]+1, count[i*2]);
            if(i*3 <= N)
                count[i*3] = Math.min(count[i]+1, count[i*3]);
        }
    }

    private static void prob24416() throws IOException {
        int N = Integer.parseInt(br.readLine());
        f = new int[N];
        fib(N);
        fibonacci(N);

        sb.append(cnt1).append(" ").append(cnt2);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int fib(int N) {
        if(N == 1 || N == 2) {
            cnt1++;
            return 1;
        }
        else
            return fib(N-1) + fib(N-2);
    }
    private static int fibonacci(int N) {
        f[0] = f[1] = 1;
        for (int i = 2; i < N; i++) {
            cnt2++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[N-1];
    }

}