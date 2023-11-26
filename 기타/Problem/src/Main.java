import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

    }

    private static void prob1271() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger N = new BigInteger(st.nextToken());
        BigInteger M = new BigInteger(st.nextToken());
        sb.append(N.divide(M)).append("\n").append(N.mod(M));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10953() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(A + B).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob3046() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R1 = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int R2 = (S * 2) - R1;

        sb.append(R2);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2609() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = Math.max(N, M);
        int min = Math.min(N, M);

        int res_gcd = gcd(max, min);
        int res_lcm = (N * M) / res_gcd;
        sb.append(res_gcd).append("\n");
        sb.append(res_lcm);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int gcd(int n, int m) {
        int tmp = m;
        m = n % m;
        n = tmp;
        return m != 0 ? gcd(n, m) : n;
    }

    private static void prob2747() throws IOException {
        int N = Integer.parseInt(br.readLine());
        long fibo[] = new long[46];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= N; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }

        sb.append(fibo[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1712() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long CB = C - B;

        if (C <= B) {
            sb.append(-1);
        } else {
            sb.append(A / CB + 1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2420() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long res = Math.abs(N - M);
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2475() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[5];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i] * arr[i];
        }
        int res = sum % 10;
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2577() throws IOException {
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int res = A * B * C;

        int num[] = new int[10];

        while (res > 0) {
            num[res % 10]++;
            res /= 10;
        }

        for (int i = 0; i < num.length; i++) {
            sb.append(num[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int grade = Integer.parseInt(st.nextToken());
            int P = (grade * 100) / N;
            if(P >= 0 && P <= 4){
                sb.append("1 ");
            }else if(P <= 11){
                sb.append("2 ");
            } else if (P <= 23) {
                sb.append("3 ");
            } else if(P <= 40){
                sb.append("4 ");
            }else if(P <= 60){
                sb.append("5 ");
            }else if(P <= 77){
                sb.append("6 ");
            }else if(P <= 89){
                sb.append("7 ");
            }else if(P <= 96){
                sb.append("8 ");
            }else if(P <= 100) {
                sb.append("9 ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob30007() throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int W = A*(X-1)+B;
            sb.append(W).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}