import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //prob2869();
        //prob10757();
        prob2869();
    }

    private static void prob10757() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        bw.write(String.valueOf(A.add(B)));
        bw.flush();
        bw.close();
    }

    private static void prob2869() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int check = (V - A) % (A - B);
        int day = 0;
        if(check != 0){
            day = (V - A) / (A - B) + 2;
        }
        else {
            day = (V - A) / (A - B) + 1;
        }


        /*int total = 0;
        int day = 0;
        while (true){
            day++;
            total += A;
            if(total >= V){
                break;
            }
            total -= B;
        }*/
        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();
    }

    private static void prob1193() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int cnt = 1;
        int line = 2;
        int a = 1;
        int b = 1;

        while (cnt < X){
            for (int j = 0; j < line; j++) {
                if (line % 2 == 0){
                    a = j+1;
                    b = line-j;
                }
                else {
                    a = line-j;
                    b = j+1;
                }
                cnt++;
                if(cnt >= X){
                    break;
                }
            }
            line++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a).append("/").append(b);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2292() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int way = 1;
        while (true){
            if(cnt >= N){
                bw.write(String.valueOf(way));
                break;
            }
            way++;
            cnt += (6 * way) - 6;
        }
        bw.flush();
        bw.close();
    }

    private static void prob2903() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = 2;
        for (int i = 0; i < N; i++) {
            result = result * 2 - 1;
        }
        bw.write(String.valueOf((int)Math.pow(result, 2)));
        bw.flush();
        bw.close();
    }

    private static void prob2720() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());
            sb.append(C / 25).append(" ");
            C %= 25;
            sb.append(C / 10).append(" ");
            C %= 10;
            sb.append(C / 5).append(" ");
            C %= 5;
            sb.append(C).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11005() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        String result = "";
        while (N > 0){
            int mod = (int) (N % B);
            N /= B;
            if(mod > 9){
                mod += 55;
                result += (char) mod;
            }
            else {
                result += String.valueOf(mod);
            }
        }
        StringBuilder sb = new StringBuilder(result);
        sb.reverse();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        /*
        int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		System.out.println(Integer.toString(N,B).toUpperCase());
         */
    }

    private static void prob2745() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long result = 0;

        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        for (int i = N.length()-1; i >= 0; i--) {
            int tmp = N.charAt(i);
            if(alpha.contains(String.valueOf(N.charAt(i)))){
                tmp -= 55;
            }
            else {
                tmp = Integer.parseInt(String.valueOf(N.charAt(i)));
            }
            result += (tmp * Math.pow(B, (N.length()-1) - i));
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

        //System.out.println(Integer.parseInt(N, B));

    }
}