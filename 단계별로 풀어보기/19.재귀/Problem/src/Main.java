import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
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