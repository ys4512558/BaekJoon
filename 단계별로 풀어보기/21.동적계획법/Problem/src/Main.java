import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
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
    static int[][] rgb;
    static int[][] cost;
    static int[][] sum;
    static int[][] wire;
    static int dp[];
    static int tile[];
    static long num[][];
    public static void main(String[] args) throws IOException {

    }

    private static void prob2293() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int coin[] = new int[N];
        int dp[] = new int[K+1];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);

        for (int i = 0; i < coin.length; i++) {
            for (int j = 1; j <= K; j++) {
                if (j - coin[i] > 0) {
                    dp[j] = dp[j] + dp[j-coin[i]];
                } else if (j - coin[i] == 0) {
                    dp[j]++;
                }
            }
        }
        sb.append(dp[K]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob9465() throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int arr[][] = new int[2][N+1];
            int dp[][] = new int[2][N+1];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    dp[j][k] = arr[j][k];
                }
            }

            for (int j = 2; j <= N; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
            }
            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob14051() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[2][1001];
        int dp[] = new int[1001];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken()) + (i-1);
            arr[1][i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            if (arr[0][i] <= N) {
                dp[arr[0][i]] = Math.max(dp[arr[0][i]], dp[i-1] + arr[1][i]);
            }
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }
        sb.append(dp[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11052() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[1001];
        int dp[] = new int[1001];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }

        sb.append(dp[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2193() throws IOException {
        int N = Integer.parseInt(br.readLine());
        long dp[] = new long[91];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        sb.append(dp[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11727() throws IOException {
        int N = Integer.parseInt(br.readLine());

        int dp[] = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        }
        sb.append(dp[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2775() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int sum[][] = new int[k + 1][n + 1];
            for (int j = 0; j <= k; j++) {
                for (int l = 1; l <= n; l++) {
                    if (j == 0) {
                        sum[j][l] = sum[j][l - 1] + l;
                        continue;
                    }
                    sum[j][l] = sum[j - 1][l] + sum[j][l - 1];
                }
            }
            sb.append(sum[k - 1][n]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1003() throws IOException {
        int T = Integer.parseInt(br.readLine());

        Integer dp[][] = new Integer[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            fibonacci1003(dp, N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static Integer[] fibonacci1003(Integer dp[][], int N) {
        if(dp[N][0] == null || dp[N][1] == null) {
            dp[N][0] = fibonacci1003(dp,N - 1)[0] + fibonacci1003(dp,N - 2)[0];
            dp[N][1] = fibonacci1003(dp,N - 1)[1] + fibonacci1003(dp,N - 2)[1];
        }
        return dp[N];
    }

    private static void prob9095() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            dp = new int[N+1];
            sb.append(dp9095(N)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int dp9095(int N) {
        if (N == 1) {
            return dp[1] = 1;
        } else if (N == 2) {
            return dp[2] = 2;
        } else if (N == 3) {
            return dp[3] = 4;
        }

        if(dp[N] == 0){
            dp[N] = dp9095(N - 1) + dp9095(N - 2) + dp9095(N - 3);
        }
        return dp[N];
    }

    private static void prob2565_2() throws IOException {
        int N = Integer.parseInt(br.readLine());
        wire = new int[N][2];
        dp = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(wire[i][1] > wire[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        sb.append(N - max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11054_2() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int len[] = new int[N];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            len[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                //현재 수를 커지는 수로 사용할 경우
                if(arr[i] > arr[j]){
                    len[i] = Math.max(len[i], len[j] + 1);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                //현재 수를 작아지는 수로 사용할 경우
                if(arr[i] < arr[j]){
                    len[i] = Math.max(len[i], len[j] + 1);
                }
            }
        }

        for (int i = 0; i < len.length; i++) {
            max = Math.max(max, len[i]);
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11053() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int len[] = new int[N];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            len[i] = 1;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j])
                    len[i] = Math.max(len[i], len[j]+1);
            }
            max = Math.max(max, len[i]);
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2156_2() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int wine[] = new int[N + 1];
        int sum[] = new int[N + 1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if(N >= 1) {
            sum[1] = wine[1];
            max = sum[1];
        }
        if(N >= 2){
            sum[2] = wine[1] + wine[2];
            max = sum[2];
        }
        for (int i = 3; i <= N; i++) {
            sum[i] = Math.max(sum[i - 1], Math.max(sum[i - 2], sum[i - 3] + wine[i - 1]) + wine[i]);
            max = Math.max(sum[i], max);
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10844() throws IOException {
        int N = Integer.parseInt(br.readLine());
        num = new long[N+1][10];

        long res = 0;

        for (int i = 1; i < 10; i++) {
            res += dp10844(N, i);
        }
        sb.append(res % 1000000000).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static long dp10844(int len, int idx) {
        if(idx < 0 || idx > 9){
            return 0;
        }
        if(len == 1){
            return num[len][idx] = 1;
        }
        if(num[len][idx] == 0){
            num[len][idx] = (dp10844(len-1, idx-1) % 1000000000)
                    + (dp10844(len-1, idx+1) % 1000000000);
        }
        return num[len][idx] % 1000000000;
    }


    private static void prob11726() throws IOException {
        int N = Integer.parseInt(br.readLine());
        tile = new int[1001];
        tile[1] = 1;
        tile[2] = 2;
        for (int i = 3; i <= N; i++) {
            tile[i] = (tile[i-1]+tile[i-2])  % 10007;
        }
        sb.append(tile[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob12865() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N + 1];
        int[] V = new int[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if(W[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }

            }
        }
        sb.append(dp[N][K]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob9251() throws IOException {
        char str1[] = br.readLine().toCharArray();
        char str2[] = br.readLine().toCharArray();

        int dp[][] = new int[str1.length+1][str2.length+1];

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if(str1[i-1] == str2[j-1])
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        sb.append(dp[str1.length][str2.length]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2565() throws IOException {
        int N = Integer.parseInt(br.readLine());
        dp = new int[N];
        wire = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(wire[i][1] > wire[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        sb.append(N-max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1932_2() throws IOException {
        int N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        sum = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = sum[0][0] = cost[0][0];
        for (int i = 0; i < N; i++) {
            dp1932(N-1, i);
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int dp1932(int row, int col){
        if(row == 0)
            return sum[row][col];
        if(sum[row][col] == 0){
            if(col == 0)
                sum[row][col] = dp1932(row-1, col)+cost[row][col];
            else if (col == row)
                sum[row][col] = dp1932(row-1, col-1)+cost[row][col];
            else
                sum[row][col] =
                        Math.max(dp1932(row-1, col-1), dp1932(row-1, col))
                        +cost[row][col];
        }
        max = Math.max(sum[row][col], max);
        return sum[row][col];
    }

    /**
     * 0921 : 1931번 Bottom-Up 방식
     * @throws IOException
     */
    private static void prob1932() throws IOException {
        int N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        sum = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = sum[0][0] = cost[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i+1; j++) {
                if(j == 0) //삼각형의 왼쪽 라인
                    sum[i][j] = sum[i-1][j]+cost[i][j];
                else if(j == i) //삼각형의 오른쪽 라인
                    sum[i][j] = sum[i-1][j-1]+cost[i][j];
                else //가운데
                    sum[i][j] = Math.max(sum[i-1][j-1], sum[i-1][j])+cost[i][j];
                max = Math.max(max, sum[i][j]);
            }
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    /**
     * 0921 : 1149번 Top-Down 방식
     * @throws IOException
     */
    private static void prob1149_2() throws IOException {
        int N = Integer.parseInt(br.readLine());
        rgb = new int[N][3];
        cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cost[0][0] = rgb[0][0];
        cost[0][1] = rgb[0][1];
        cost[0][2] = rgb[0][2];
        dp1149(N-1, 0);
        dp1149(N-1, 1);
        dp1149(N-1, 2);

        int min = Math.min(Math.min(cost[N - 1][0], cost[N - 1][1]), cost[N-1][2]);
        sb.append(min);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int dp1149(int N, int color){
        if(cost[N][color] == 0){
            if(color == 0)
                cost[N][color] = Math.min(dp1149(N-1, 1), dp1149(N-1, 2))+rgb[N][color];
            else if (color == 1)
                cost[N][color] = Math.min(dp1149(N-1, 0), dp1149(N-1, 2))+rgb[N][color];
            else
                cost[N][color] = Math.min(dp1149(N-1, 0), dp1149(N-1, 1))+rgb[N][color];
        }
        return cost[N][color];
    }

    /**
     * 0921 : 1149번 Bottom-Up 방식
     * @throws IOException
     */
    private static void prob1149() throws IOException {
        int N = Integer.parseInt(br.readLine());
        rgb = new int[N][3];
        cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cost[0][0] = rgb[0][0];
        cost[0][1] = rgb[0][1];
        cost[0][2] = rgb[0][2];
        int min = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if(j == 0)
                    cost[i][j] = Math.min(cost[i-1][1], cost[i-1][2])+rgb[i][j];
                else if(j == 1)
                    cost[i][j] = Math.min(cost[i-1][0], cost[i-1][2])+rgb[i][j];
                else
                    cost[i][j] = Math.min(cost[i-1][0], cost[i-1][1])+rgb[i][j];
            }
        }
        min = Math.min(Math.min(cost[N - 1][0], cost[N - 1][1]), cost[N-1][2]);
        sb.append(min);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    /**
     * 0921 : Top-Down 방식
     * @throws IOException
     */

    private static void prob1912_4() throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        score = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        max = score[0] = arr[0];
        dp1912_4(N-1);
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int dp1912_4(int N){
        if(N == 0)
            return score[N];
        if(score[N] == 0){
            score[N] = Math.max(dp1912_4(N-1)+arr[N], arr[N]);
        }
        max = Math.max(score[N], max);
        return score[N];
    }
    /**
     * 23-09-21 : Bottom-Up 방식
     * @throws IOException
     */
    private static void prob1912_3() throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        score = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        max = score[0] = arr[0];
        for (int i = 1; i < N; i++) {
            score[i] = Math.max(score[i-1]+arr[i], arr[i]);
            max = Math.max(score[i], max);
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    private static void prob11054() throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int count1[] = new int[N+1];
        int count2[] = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            count1[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j] && count1[j]>=count1[i])
                    count1[i] = count1[j]+1;
            }
        }
        for (int i = N-1; i >= 0; i--) {
            count2[i] = 1;
            for (int j = N-1; j > i; j--) {
                if(arr[i]>arr[j] && count2[j]>=count2[i])
                    count2[i]=count2[j]+1;
            }
        }
        for (int i = 0; i < N; i++) {
            result = Math.max(count1[i] + count2[i] - 1, result);
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
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
        if(N % 3 == 0)
            count[N/3] = Math.min(count[N]+1, dp1463_2(N/3));
        if(N % 2 == 0)
            count[N/2] = Math.min(count[N]+1, dp1463_2(N/2));
        if(N-1 > 0)
            count[N-1] = Math.min(count[N]+1, dp1463_2(N-1));

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