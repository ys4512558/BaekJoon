import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //prob10807();
        //prob10871();
        //prob10818();
        //prob2562();
        //prob10810();
        //prob10813();
        //prob5597();
        //prob3052();
        //prob10811();
        //prob1546();
    }

    private static void prob1546() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        double A[] = new double[N];

        double sum = 0;
        double max = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Double.parseDouble(st.nextToken());
            max = A[i] > max ? A[i] : max;
        }

        for (int i = 0; i < N; i++) {
            A[i] = A[i] / max * 100;
            sum += A[i];
        }
        bw.write(String.valueOf(sum/N));
        bw.flush();
        bw.close();
    }

    private static void prob10811() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = i+1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int cnt = (b - a + 1) / 2;

            for (int j = 0; j < cnt; j++) {
                int tmp = A[a];
                A[a] = A[b];
                A[b] = tmp;
                a++;
                b--;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob3052() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 10;

        Integer[] A = new Integer[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            A[i] %= 42;
        }

        Set<Integer> set = new HashSet<Integer>(Arrays.asList(A));

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }

    private static void prob5597() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] b = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
            b[n] = true;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 30; i++) {
            if(!b[i]){
                sb.append(i).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10813() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = i+1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int tmp = A[a];
            A[a] = A[b];
            A[b] = tmp;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10810() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            for (int j = start-1; j < end; j++) {
                A[j] = num;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2562() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] A = new int[9];

        int max = Integer.parseInt(br.readLine());
        int idx = 0;
        for (int i = 1; i < 9; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp > max){
                max = temp;
                idx = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(idx+1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10818() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        int min = 1000000;
        int max = -1000000;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10871() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            if(A[i] < X){
                sb.append(A[i]).append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10807() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int v = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == v){
                cnt++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}