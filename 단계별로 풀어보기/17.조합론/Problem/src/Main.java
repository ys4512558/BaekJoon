import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
    }

    private static void prob24723() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        sb.append((int) Math.pow(2, N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob15439() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(N * (N - 1));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}