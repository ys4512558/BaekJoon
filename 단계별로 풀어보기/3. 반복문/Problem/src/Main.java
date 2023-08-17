import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //prob2739();
        //prob10950();
        //prob8393();
        //prob25304();
        //prob25314();
        //prob15552();
        //prob11021();
        //prob11022();
        //prob2438();
        //prob2439();
        //prob10952();
        //prob10951();
    }

    private static void prob10951() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";

        /**
         * EOF 주의하기
         */
        while((input = br.readLine()) != null){
            if(input.isEmpty()){
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(a+b));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void prob10952() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = -1;

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sum = a+b;

            if(sum == 0){
                break;
            }
            else{
                bw.write(String.valueOf(sum));
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void prob2439() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = N; j > 0; j--) {
                if(i >= j){
                    bw.write("*");
                }
                else{
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void prob2438() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void prob11022() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(i).append(": ").
                    append(a + " + " + b + " = ").append(a+b).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }

    private static void prob11021() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(i).append(": ").append(a+b).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }

    private static void prob15552() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(a+b) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void prob25314() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        N /= 4;
        for (int i = 0; i < N; i++) {
            bw.write("long ");
        }
        bw.write("int");
        bw.flush();
        bw.close();
    }

    private static void prob25304() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sum += (a*b);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if(X == sum){
            bw.write("Yes");
        }
        else{
            bw.write("No");
        }
        bw.flush();
        bw.close();
    }

    private static void prob8393() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }

    private static void prob10950() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(a+b) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void prob2739() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 9; i++) {
            bw.write(n + " * " + i + " = " + (n * i));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}