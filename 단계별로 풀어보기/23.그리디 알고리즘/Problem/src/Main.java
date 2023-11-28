import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

    }

    private static void prob1715() throws IOException {
        int N = Integer.parseInt(br.readLine());
        Queue<Long> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            queue.add(Long.valueOf(br.readLine()));
        }
        int result = 0;

        while (queue.size() > 1) {
            long num1 = queue.poll();
            long num2 = queue.poll();

            result += (num1 + num2);
            queue.add(num1 + num2);
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10162() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int A = 0;
        int B = 0;
        int C = 0;

        while (N > 0){
            if(N >= 300){
                A++;
                N -= 300;
            } else if (N >= 60) {
                B++;
                N -= 60;
            } else if (N >= 10) {
                C++;
                N -= 10;
            } else {
                N = -1;
            }
        }
        sb.append(N == 0 ? (A + " " + B + " " + C) : -1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob5585() throws IOException {
        int N = Integer.parseInt(br.readLine());

        int money = 1000 - N;
        int cnt = 0;
        while (money > 0) {
            if (money >= 500) {
                money -= 500;
                cnt++;
            } else if (money >= 100) {
                money -= 100;
                cnt++;
            } else if (money >= 50) {
                money -= 50;
                cnt++;
            } else if (money >= 10) {
                money -= 10;
                cnt++;
            } else if (money >= 5) {
                money -= 5;
                cnt++;
            } else {
                money -= 1;
                cnt++;
            }
        }
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2217() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], map.containsKey(arr[i]) ? map.get(arr[i])+1 : 1);
        }
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < N; ) {
            max = Math.max(max, arr[i] * (N - i));
            i += map.get(arr[i]);
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1789() throws IOException {
        long N = Long.parseLong(br.readLine());
        long sum = N;
        long cnt = 0;

        for (int i = 1; ; i++) {
            if (sum < 0) {
                break;
            }
            sum -= i;
            cnt++;
        }
        sb.append(cnt - 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1026() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        int B[] = new int[N];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (i == 0) {
                    A[j] = Integer.parseInt(st.nextToken());
                } else {
                    B[j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int s = 0;
        for (int i = 0; i < N; i++) {
            s += (A[i] * B[N - i - 1]);
        }
        sb.append(s);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob13305_2() throws IOException {
        int N = Integer.parseInt(br.readLine());
        long dist[] = new long[N-1];
        long cost[] = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long min = cost[0];
        long sum = 0;
        for (int i = 0; i < N-1; i++) {
            min = Math.min(min, cost[i]);
            sum += (dist[i] * min);
        }
        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1541_2() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        String[] strs = new String[st.countTokens()];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = st.nextToken();
        }
        int res = 0;
        for (int i = 0; i < strs.length; i++) {
            int tmp = 0;
            if (strs[i].contains("+")) {
                st = new StringTokenizer(strs[i], "+");
                while (st.hasMoreTokens()) {
                    tmp += Integer.parseInt(st.nextToken());
                }
            } else {
                tmp += Integer.parseInt(strs[i]);
            }
            res = i == 0 ? (res + tmp) : (res - tmp);
        }
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1931_2() throws IOException {
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
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int end = time[0][1];
        int cnt = 1;
        for (int i = 1; i < time.length; i++) {
            //끝나는 시간이 더 작은 경우
            if (end > time[i][1]) {
                end = time[i][1];
            }
            //시작 시간이 이전 회의 종료 시간보다 크거나 같은 경우
            else if (end <= time[i][0]) {
                end = time[i][1];
                cnt++;
            }
        }
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11047_2() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int coin[] = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = N-1; i >= 0; i--) {
            if(K >= coin[i]){
                cnt += (K / coin[i]);
                K = K % coin[i];
            }
        }
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
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