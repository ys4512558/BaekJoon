import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

    }

    private static void prob10870() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int res = recur10870(N);
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int recur10870(int N){
        if(N == 0 || N == 1){
            return N;
        }
        return recur10870(N-1) + recur10870(N-2);
    }

    private static void prob27433() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long res = recur27433(N);
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static long recur27433(int n){
        if(n <= 1){
            return 1;
        }
        return n * recur27433(n-1);
    }
}