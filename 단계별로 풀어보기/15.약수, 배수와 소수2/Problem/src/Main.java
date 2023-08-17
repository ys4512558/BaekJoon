import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long arr[] = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        ArrayList<Long> prime = new ArrayList<Long>();
        int index = 0;
        long cur = arr[index];
        for (int i = 0; i < arr.length; i++) {
            boolean check = true;
            for (long j = 2; j <= Math.sqrt(cur); j++) {
                if (cur % j == 0) {
                    check = false;
                    break;
                }
            }

            if (check){
                if(cur <= 1){
                    prime.add(2L);
                }
                else {
                    prime.add(cur);
                }
                if(i != arr.length-1){
                    cur = arr[i+1];
                }
            }
            else {
                cur++;
                i--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prime.size(); i++) {
            sb.append(prime.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2485_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> tree = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tree.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(tree);
        int tmp[] = new int[N];
        tmp[0] = tree.get(0);
        int min = 1000000000;
        for (int i = 1; i < N; i++) {
            tmp[i] = tree.get(i) - tree.get(0);
            min = tmp[i] < min ? tmp[i] : min;
        }
        int g = 1;
        for (int i = 2; i <= min; i++) {
            for (int j = 1; j < tmp.length; j++) {
                if(tmp[j] % i != 0){
                    break;
                }
                if(j == tmp.length - 1){
                    g = i;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < tree.size()-1; i++) {
            if(tree.get(i+1) - tree.get(i) != g){
                cnt += (tree.get(i+1) - tree.get(i)) / g - 1;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    private static void prob1735_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A1 = Long.parseLong(st.nextToken());
        long B1 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long A2 = Long.parseLong(st.nextToken());
        long B2 = Long.parseLong(st.nextToken());

        long B = B1 * B2;
        long A = (A1 * B2) + (A2 * B1);
        long g = gcd(A,B);

        StringBuilder sb = new StringBuilder();
        sb.append(A/g).append(" ").append(B/g);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob() throws IOException {
        //https://hunucho.tistory.com/295
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int res = (int) Math.floor(Math.sqrt(N));
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    private static void prob13909() throws IOException {
        //https://velog.io/@gayeong39/%EB%B0%B1%EC%A4%80-13909-%EC%B0%BD%EB%AC%B8-%EB%8B%AB%EA%B8%B0-JAVA
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i * i <= N; i++) {
            cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    private static void prob17103_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N[] = new int[T];
        int max = -1;

        for (int i = 0; i < T; i++) {
            N[i] = Integer.parseInt(br.readLine());
            max = N[i] > max ? N[i] : max;
        }

        boolean primes[] = eratosthenes(max);
        for (int i = 0; i < T; i++) {
            int cnt = 0;
            for (int j = 2; j <= N[i]/2; j++) {
                if(!primes[j] && !primes[N[i]-j]){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob17103() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            boolean primes[] = eratosthenes(N);
            int cnt = 0;
            for (int j = 2; j <= N/2; j++) {
                if(!primes[j] && !primes[N-j]){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean[] eratosthenes(int n) {
        boolean primes[] = new boolean[n+1];
        primes[0] = primes[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if(!primes[i]){
                for (int j = i * i; j <= n; j += i) { //j += i
                    primes[j] = true;
                }
            }
        }
        return primes;
    }

    private static void prob17103_timeOut() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int j = 2; j <= N/2; j++) {
                BigInteger bigInteger = new BigInteger(String.valueOf(j));
                if(bigInteger.isProbablePrime(10) && new BigInteger(String.valueOf(N-j)).isProbablePrime(10)){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob4948() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            if(N == 0){
                break;
            }
            for (int i = N+1; i <= 2*N; i++) {
                boolean check = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if(i % j == 0){
                        check = false;
                        break;
                    }
                }
                if(check){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1929() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = N; i <= M; i++) {
            boolean isPrime = true;
            if(i <= 1){
                continue;
            }
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                sb.append(i).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob4134_1() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            BigInteger bigInteger = new BigInteger(br.readLine());
            if (bigInteger.isProbablePrime(10)) {
                sb.append(bigInteger).append("\n");
            } else {
                sb.append(bigInteger.nextProbablePrime()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void prob4134() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long arr[] = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        ArrayList<Long> prime = new ArrayList<Long>();
        int idx = 0;
        long cur = arr[idx];
        Loop:
        while (true) {
            boolean check = true;
            for (long i = 2; i <= Math.sqrt(cur); i++) {
                if (cur % i == 0) {
                    check = false;
                    break;
                }
            }

            if (check && cur >= arr[idx]){
                if(cur <= 1){
                    prime.add(2L);
                }
                else {
                    prime.add(cur);
                }
                idx++;
                if(idx == arr.length){
                    break Loop;
                }
                cur = arr[idx];
            }
            else {
                cur++;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prime.size(); i++) {
            sb.append(prime.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2485() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> tree = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tree.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(tree);
        int tmp[] = new int[N];
        tmp[0] = tree.get(0);
        for (int i = 1; i < N; i++) {
            tmp[i] = tree.get(i) - tree.get(0);
        }
        int g = 1;
        for (int i = 2; i <= tmp[1]; i++) {
            for (int j = 1; j < tmp.length; j++) {
                if(tmp[j] % i != 0){
                    break;
                }
                if(j == tmp.length - 1){
                    g = i;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < tree.size()-1; i++) {
            if(tree.get(i+1) - tree.get(i) != g){
                cnt += (tree.get(i+1) - tree.get(i)) / g - 1;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    private static void prob1735() throws IOException {
        //int로 했더니 오버플로우 남..
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A1 = Long.parseLong(st.nextToken());
        long B1 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long A2 = Long.parseLong(st.nextToken());
        long B2 = Long.parseLong(st.nextToken());

        long B = B1 * B2 / gcd(B1, B2);
        long A = (A1 * B / B1) + (A2 * B / B2);
        long g = gcd(A,B);

        StringBuilder sb = new StringBuilder();
        sb.append(A/g).append(" ").append(B/g);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob13241() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long g = gcd(N, M);
        StringBuilder sb = new StringBuilder();
        sb.append(N * M / g);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1934() throws IOException {
        //유클리드 호제법
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            long g = gcd(A,B);
            sb.append(A * B / g).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b) {
        if(a % b == 0){
            return b;
        }
        return gcd(b, a%b);
    }
}