import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //prob1018_2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char chess[][] = new char[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                chess[i][j] = tmp.charAt(j);
            }
        }

        char start = 'B';
        int cnt = 0;
        int res = 10000;
        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                cnt = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if(((k % 2 == 0 && l % 2 == 0) || (k % 2 != 0 && l % 2 != 0))
                                && chess[i+k][j+l] != start){
                            cnt++;
                        }
                        else if(((k % 2 == 0 && l % 2 != 0) || (k % 2 != 0 && l % 2 == 0))
                                && (chess[i+k][j+l] == start)){
                            cnt++;
                        }
                        else {
                            continue;
                        }
                    }
                }
                cnt = Math.min(cnt, 64-cnt);
                res = res > cnt ? cnt : res;
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    private static void prob1018() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char chess[][] = new char[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                chess[i][j] = tmp.charAt(j);
            }
        }

        char start = 'B';
        int cnt = 0;
        int res = 10000;
        for (int m = 0; m < 2; m++) {
            if(m == 0){
                start = 'B';
            }
            else {
                start = 'W';
            }
            for (int i = 0; i < N-7; i++) {
                for (int j = 0; j < M-7; j++) {
                    cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            //k, l이 둘 다 짝수인 경우 시작과 같아야 한다.
                            //k, l이 둘 다 홀수일 경우 시작과 같아야 한다.
                            if(((k % 2 == 0 && l % 2 == 0) || (k % 2 != 0 && l % 2 != 0))
                                    && chess[i+k][j+l] != start){
                                cnt++;
                            }
                            else if(((k % 2 == 0 && l % 2 != 0) || (k % 2 != 0 && l % 2 == 0))
                                    && (chess[i+k][j+l] == start)){
                                cnt++;
                            }
                            else {
                                continue;
                            }
                        }
                    }
                    res = res > cnt ? cnt : res;
                }
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    private static void prob1436() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String res = "666";
        int num = 0;

        while (N != 0) {
            num++;
            if(String.valueOf(num).contains(res)){
                N--;
            }
        }
        bw.write(String.valueOf(num));
        bw.flush();
        bw.close();
    }

    private static void prob2839() throws IOException {
        //https://www.acmicpc.net/board/view/113790 다른 방법 풀이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int res = -1;

        Loop:
        for (int i = N / 5; i >= 0; i--) {
            for (int j = 0; j <= N / 3 ; j++) {
                if((5 * i) + (3 * j) == N){
                    res = i + j;
                    break Loop;
                }
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    private static void prob19532() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                boolean res1 = (a * i + b * j) == c;
                boolean res2 = (d * i + e * j) == f;

                if(res1 && res2){
                    sb.append(i).append(" ").append(j);
                    break;
                }
            }
        }
        /*
        대입법 사용하면 아래
        int y = (c*d-a*f)/(b*d-a*e);
        int x = (c*e-b*f)/(a*e-b*d);
        System.out.print(x+" "+y);
         */
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    /**
     * String으로 자릿수를 나눈다.
     * i + 자릿수의 합을 구하고 tmp에 저장
     * tmp와 N이 같다면 break;
     * 이때 작은 수부터 진행하기 때문에 가장 먼저 조건에 만나면
     * 해당 생성자가 가장 작은 수
     * @throws IOException
     */
    private static void prob2231() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int res = 0;

        for (int i = 1; i <= N; i++) {
            String num = String.valueOf(i);
            int tmp = i;
            for (int j = 0; j < num.length(); j++) {
                tmp += Integer.parseInt(String.valueOf(num.charAt(j)));
            }
            if(N == tmp){
                res = i;
                break;
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    private static void prob2798() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int card[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    int tmp = card[i] + card[j] + card[k];
                    if(tmp <= M){
                        sum = Math.max(tmp, sum);
                    }
                    if(sum == M){
                        break;
                    }
                    System.out.println(i);
                }
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}