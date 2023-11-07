import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

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