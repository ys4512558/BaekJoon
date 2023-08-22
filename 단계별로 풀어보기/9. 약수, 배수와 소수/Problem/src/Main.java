import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

    }

    private static void prob11653() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int num = 2;

        while (N > 1) {
            if(N % num == 0){
                N /= num;
                sb.append(num).append("\n");
            }
            if(N % num != 0){
                num++;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void prob2581() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = M; i <= N ; i++) {
            if(i <= 1){
                continue;
            }
            boolean check = false;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                primes.add(i);
            }
        }
        int sum = 0;
        for (int i = 0; i < primes.size(); i++) {
            sum += primes.get(i);
        }
        StringBuilder sb = new StringBuilder();
        if(sum == 0){
            sb.append(-1);
        }
        else {
            sb.append(sum).append("\n").append(primes.get(0));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void prob1978() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cnt = N;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num < 2){
                cnt--;
            }
            for (int j = 2; j < num; j++) {
                if(num % j == 0){
                    cnt--;
                    break;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    private static void prob9506() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            if (n == -1){
                break;
            }
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    arrayList.add(i);
                }
            }
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(n).append(" = ");
            for (int i = 0; i < arrayList.size(); i++) {
                sum += arrayList.get(i);
                sb.append(arrayList.get(i));
                if ((i+1) != arrayList.size()){
                    sb.append(" + ");
                }
            }
            if (sum != n) {
                sb = new StringBuilder();
                sb.append(n).append(" is NOT perfect.");
            }
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }

    private static void prob2501() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                cnt++;
            }
            if (K == cnt) {
                res = i;
                break;
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    private static void prob5086() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) {
                break;
            }

            if(a % b == 0){
                sb.append("multiple");
            }
            else if(b % a == 0){
                sb.append("factor");
            }
            else {
                sb.append("neither");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}