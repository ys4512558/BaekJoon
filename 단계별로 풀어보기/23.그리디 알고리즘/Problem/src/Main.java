import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        prob1541();
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