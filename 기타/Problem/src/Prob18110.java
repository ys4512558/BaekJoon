import java.io.*;
import java.util.Arrays;

public class Prob18110 {
    public static void solve() throws IOException {
        //solved.ac
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int l[] = new int[N];
        int num = (int) Math.round(N * 0.15);
        for (int i = 0; i < N; i++) {
            l[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(l);
        double sum = 0;
        for (int i = num; i < N-num; i++) {
            sum += l[i];
        }
        int res = (int) Math.round(sum / (N - num * 2));
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}
