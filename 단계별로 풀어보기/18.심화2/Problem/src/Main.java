import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

    }

    private static void prob25192() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<String>();
        int N = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            if (tmp.equals("ENTER")) {
                res += set.size();
                set = new HashSet<>();
            }
            else {
                set.add(tmp);
            }
        }
        res += set.size();
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1037_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int res = A[0] * A[A.length-1];
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1037() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int res = A.length % 2 == 0 ? A[0] * A[A.length-1] : A[A.length/2] * A[A.length/2];
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}