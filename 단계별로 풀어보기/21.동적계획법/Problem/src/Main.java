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

    static long w[][][];

    static int arr[];

    static int array[];
    static int score[];

    static long ary[];

    static int max;
    public static void main(String[] args) throws IOException {

    }

    private static void prob2156() throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        score = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(N >= 1)
            score[0] = arr[0];
        if(N >= 2)
            score[1] = arr[0]+arr[1];
        if(N >= 3)
            score[2] = Math.max(score[1], Math.max(score[0] + arr[2], arr[1] + arr[2]));

        for (int i = 3; i < N; i++) {
            score[i] = Math.max(score[i-1], Math.max(score[i-2] + arr[i], score[i-3]+arr[i-1] + arr[i]));
        }
        sb.append(score[N-1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1912_2() throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        score = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        max = score[0] = arr[0];
        dp1912_2(N-1);
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int dp1912_2(int N){
        if(N == 0)
            return score[N];
        if(score[N] == 0){
            score[N] = Math.max(arr[N], arr[N]+dp1912_2(N-1));
            max = Math.max(max, score[N]);
            return score[N];
        }
        return score[N];
    }

    private static void prob9461() throws IOException {
        int T = Integer.parseInt(br.readLine());
        ary = new long[101];
        ary[1] = ary[2] = ary[3] = 1;
        for (int i = 0; i < T; i++) {
            sb.append(dp9461(Integer.parseInt(br.readLine()))).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static long dp9461(int N){
        if(ary[N] == 0)
            return ary[N] = dp9461(N-2)+dp9461(N-3);
        return ary[N];
    }

    private static void prob2579() throws IOException {
        int N = Integer.parseInt(br.readLine());
        array = new int[N+1];
        score = new int[N+1];

        for (int i = 0; i < N; i++) {
            array[i+1] = Integer.parseInt(br.readLine());
        }
        score[1] = array[1];
        if (N >= 2) {
            score[2] = array[1] + array[2];
        }

        for (int i = 3; i <= N; i++) {
            score[i] = Math.max(score[i - 2], score[i - 3] + array[i - 1]) + array[i];
        }

        sb.append(score[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1904() throws IOException {
        int N = Integer.parseInt(br.readLine());

        arr = new int[1000001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;

        sb.append(dp1904(N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int dp1904(int N){
        if(arr[N] == 0)
            arr[N] = (dp1904(N-1)+dp1904(N-2)) % 15746;
        return arr[N];
    }

    private static void prob9184() throws IOException {
        w = new long[51][51][51];
        w[0][0][0] = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            sb = new StringBuilder();
            sb.append("w("+a+", "+b+", "+c+") = " + recur9184(a,b,c)).append("\n");
            bw.write(sb.toString());
            bw.flush();
        }
        bw.close();
    }
    private static long recur9184(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0)
            return w[0][0][0];
        if(w[a][b][c] != 0)
            return w[a][b][c];
        if (a > 20 || b > 20 || c > 20)
            return w[a][b][c] = recur9184(20, 20, 20);

        if (a < b && b < c)
            return w[a][b][c] = recur9184(a, b, c-1)+
                    recur9184(a,b-1, c-1)-
                    recur9184(a, b-1, c);

        return w[a][b][c] = recur9184(a - 1, b, c) +
                recur9184(a - 1, b - 1, c) +
                recur9184(a - 1, b, c - 1) -
                recur9184(a - 1, b - 1, c - 1);
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