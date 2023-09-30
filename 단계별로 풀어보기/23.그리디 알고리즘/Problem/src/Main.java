import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

    }

    private static void prob1931() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int time[][] = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int end = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(end <= time[i][0]) {
                end = time[i][1];
                cnt++;
            }
        }
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob13305() throws IOException {
        int N = Integer.parseInt(br.readLine());
        long dist [] = new long[N-1];
        long cost [] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            if(cost[i] > cost[i-1])
                cost[i] = cost[i-1];
        }
        long sum = 0;
        for (int i = 0; i < dist.length; i++) {
            sum += dist[i] * cost[i];
        }
        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1541() throws IOException {
        String str = br.readLine();
        boolean check = str.charAt(0)=='-';
        StringTokenizer st = new StringTokenizer(str, "-");
        int res = 0;
        int cnt = st.countTokens();
        for (int i = 0; i < cnt; i++) {
            StringTokenizer stk = new StringTokenizer(st.nextToken(), "+");
            int cnt2 = stk.countTokens();
            int tmp = 0;
            for (int j = 0; j < cnt2; j++) {
                tmp += Integer.parseInt(stk.nextToken());
            }
            if(i == 0 && !check)
                res += tmp;
            else
                res -= tmp;
        }
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11399() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sums[] = new int[N];
        int sum = 0;
        sum = sums[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sums[i] = sums[i-1]+arr[i];
            sum += sums[i];
        }
        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11047() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int money[] = new int[N];
        int current = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        Loop:
        while (current != K){
            for (int i = N-1; i >= 0; i--) {
                if(K-current < money[i])
                    continue;
                current += money[i];
                cnt++;
                i++;
                if(current == K)
                    break Loop;
            }
        }
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}