import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        StringBuilder sb = new StringBuilder();

        sb.append(n*(n-1)*(n-2) / 6).append("\n").append(3);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob24266() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        StringBuilder sb = new StringBuilder();

        //sb.append((long) Math.pow(n,3)).append("\n").append(3);
        sb.append(n*n*n).append("\n").append(3);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob24265() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        StringBuilder sb = new StringBuilder();

        sb.append((n * (n-1)) / 2).append("\n").append(2);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob24264() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        sb.append((long) Math.pow(n, 2)).append("\n").append(2);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob24263() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        sb.append(n).append("\n").append(1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob24313() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a[] = new int[2];
        a[0] = Integer.parseInt(st.nextToken());
        a[1] = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean check = (a[0] * n + a[1]) <= c * n;
        if(check && c >= a[0]){
            bw.write(String.valueOf(1));
        }
        else {
            bw.write(String.valueOf(0));
        }
        bw.flush();
        bw.close();
    }

    private static void prob24262() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(1).append("\n").append(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}