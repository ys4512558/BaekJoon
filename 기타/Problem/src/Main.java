import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

    }

    private static void prob14928() throws IOException {
        String N = br.readLine();
        long res = 0;
        for (int i = 0; i < N.length(); i++) {
            res = (res * 10 + (N.charAt(i) - '0')) % 20000303;
        }
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob25628() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int min = Math.min(A / 2, B);

        sb.append(min);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2754() throws IOException {
        String str = br.readLine();
        if (str.equals("A+")) {
            sb.append(4.3);
        } else if(str.equals("A0")){
            sb.append(4.0);
        } else if (str.equals("A-")) {
            sb.append(3.7);
        } else if (str.equals("B+")) {
            sb.append(3.3);
        } else if (str.equals("B0")) {
            sb.append(3.0);
        } else if (str.equals("B-")) {
            sb.append(2.7);
        } else if (str.equals("C+")) {
            sb.append(2.3);
        } else if (str.equals("C0")) {
            sb.append(2.0);
        } else if (str.equals("C-")) {
            sb.append(1.7);
        } else if (str.equals("D+")) {
            sb.append(1.3);
        } else if (str.equals("D0")) {
            sb.append(1.0);
        } else if(str.equals("D-")){
            sb.append(0.7);
        } else {
            sb.append(0.0);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10828() throws IOException {
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                stack.push(Integer.valueOf(st.nextToken()));
            } else if(cmd.equals("pop")){
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            } else if(cmd.equals("size")){
                sb.append(stack.size()).append("\n");
            } else if(cmd.equals("empty")){
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            } else{
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob5522() throws IOException {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += Integer.parseInt(br.readLine());
        }
        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1550() throws IOException {
        int N = Integer.parseInt(br.readLine(), 16);
        sb.append(N);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2576() throws IOException {
        int arr[] = new int[7];
        int sum = 0;
        int min = 101;
        for (int i = 0; i < 7; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n % 2 != 0) {
                sum += n;
                min = Math.min(min, n);
            }
        }
        if (min == 101) {
            sb.append(-1);
        } else {
            sb.append(sum).append("\n").append(min);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1284() throws IOException {
        String str;
        while (!(str = br.readLine()).equals("0")) {
            int res = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == '0'){
                    res += 4;
                } else if (c == '1') {
                    res += 2;
                } else {
                    res += 3;
                }
            }
            sb.append(res + str.length() + 1).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob3034() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int l = Integer.parseInt(br.readLine());
            if (l <= W || l <= H || l <= Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2))) {
                sb.append("DA").append("\n");
            } else{
                sb.append("NE").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob14489() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int C = Integer.parseInt(br.readLine());

        int res = (A + B) - (2 * C) >= 0 ? (A + B) - (2 * C) : (A + B);
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2752() throws IOException {
        int arr[] = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        sb.append(arr[0] + " ").append(arr[1] + " ").append(arr[2]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob13752() throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(br.readLine());
            for (int j = 0; j < K; j++) {
                sb.append("=");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2441() throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j >= i) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    private static void prob10808() throws IOException {
        int[] cnts = new int[26];
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)-97]++;
        }
        for (int i = 0; i < 26; i++) {
            sb.append(cnts[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob7287() throws IOException {
        sb.append("258").append("\n").append("ys4512558");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2338() throws IOException {
        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());
        sb.append(A.add(B)+"\n").append(A.subtract(B)+"\n").append(A.multiply(B));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2530() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int sec = Integer.parseInt(br.readLine());
        s += sec;
        if(s >= 60){
            m += s / 60;
            s %= 60;
        }
        if(m >= 60){
            h += m / 60;
            m %= 60;
        }
        if(h >= 24){
            h %= 24;
        }
        sb.append(h + " ").append(m + " ").append(s);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob18110() throws IOException{
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

    private static void prob1271() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger N = new BigInteger(st.nextToken());
        BigInteger M = new BigInteger(st.nextToken());
        sb.append(N.divide(M)).append("\n").append(N.mod(M));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10250() throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            if (N % H == 0) {
                sb.append((H * 100) + (N / H)).append('\n');

            } else {
                sb.append(((N % H) * 100) + ((N / H) + 1)).append('\n');
            }
        }
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