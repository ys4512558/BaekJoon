import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
    }

    private static void prob14215() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len[] = new int[3];

        len[0] = Integer.parseInt(st.nextToken());
        len[1] = Integer.parseInt(st.nextToken());
        len[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(len);

        if(len[0] + len[1] <= len[2]){
            len[2] = len[0] + len[1] - 1;
        }
        bw.write(String.valueOf(len[0]+len[1]+len[2]));
        bw.flush();
        bw.close();
    }

    private static void prob5073() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len[] = new int[3];
            len[0] = Integer.parseInt(st.nextToken());
            len[1] = Integer.parseInt(st.nextToken());
            len[2] = Integer.parseInt(st.nextToken());

            if(len[0] == 0  && len[0] == 0 && len[0] == 0){
                break;
            }
            Arrays.sort(len);

            if(len[0] + len[1] <= len[2]){
                bw.write("Invalid");
            }
            else if(Arrays.stream(len).max().getAsInt() ==
                    Arrays.stream(len).min().getAsInt()){
                bw.write("Equilateral");
            }
            else if(len[0] == len[1] || len[1] == len[2] || len[2] == len[1]){
                bw.write("Isosceles");
            }
            else{
                bw.write("Scalene");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void prob10101() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        if(A == 60 && B == 60 && C == 60){
            sb.append("Equilateral");
        }
        else if(A+B+C == 180 && (A == B || B == C || A == C)){
            sb.append("Isosceles");
        }
        else if(A+B+C == 180 && (A != B && B != C && A != C)){
            sb.append("Scalene");
        }
        else{
            sb.append("Error");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob9063() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int x[] = new int[N];
        int y[] = new int[N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x);
        Arrays.sort(y);

        int result = (x[N-1] - x[0]) * (y[N-1] - y[0]);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void prob15894() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger n = new BigInteger(br.readLine());
        BigInteger four = new BigInteger("4");

        bw.write(String.valueOf(n.multiply(four)));
        bw.flush();
        bw.close();
    }
    private static void prob3009() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X[] = {0, 0, 0};
        int Y[] = {0, 0, 0};

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(X);
        Arrays.sort(Y);

        int x = X[0] == X[1] ? X[2] : X[0];
        int y = Y[0] == Y[1] ? Y[2] : Y[0];

        StringBuilder sb = new StringBuilder();
        sb.append(x).append(" ").append(y);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void prob1085() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int distances[] = {x, y, h-y, w-x};

        int dist = 1000;

        for (int i = 0; i < 4; i++) {
            dist = dist >= distances[i] ? distances[i] : dist;
        }

        bw.write(String.valueOf(dist));
        bw.flush();
        bw.close();
    }
    private static void prob27323() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int h = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(h*w));
        bw.flush();
        bw.close();
    }

}