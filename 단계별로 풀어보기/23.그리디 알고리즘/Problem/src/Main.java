import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

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