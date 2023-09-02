import java.io.*;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {

    }

    private static void prob25501() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            cnt = 0;
            int res = recur25501(input, 0, input.length()-1);
            sb.append(res).append(" ").append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int recur25501(String str, int l, int r) {
        cnt++;
        if(l >= r)
            return 1;
        else if (str.charAt(l) != str.charAt(r))
            return 0;
        else
            return recur25501(str, l+1, r-1);
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