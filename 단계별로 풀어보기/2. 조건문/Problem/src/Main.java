import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //prob1330();
        //prob9498();
        //prob2753();
        //prob14681();
        //prob2884();
        //prob2525();
        //prob2480();
    }

    private static void prob2480() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if(A == B && B == C && C == A){
            bw.write(String.valueOf(10000 + 1000 * A));
        }
        else if(A != B && B != C && C != A){
            int max = Math.max(A,B);
            max = Math.max(max, C);
            bw.write(String.valueOf(100 * max));
        }
        else{
            if(A == B){
                bw.write(String.valueOf(1000 + 100 * A));
            }
            else if(B == C){
                bw.write(String.valueOf(1000 + 100 * B));
            }
            else {
                bw.write(String.valueOf(1000 + 100 * C));
            }
        }

        bw.flush();
        bw.close();
    }

    private static void prob2525() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int C = Integer.parseInt(br.readLine());

        B += C;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if(B / 60 > 0){
            A += (B / 60);
            B -= (B / 60) * 60;
        }

        if(A >= 24){
            A -= 24;
        }
        bw.write(A + " " + B);
        bw.flush();
        bw.close();
    }

    private static void prob2884() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(M < 45){
            if(H > 0){
                H--;
                M += 15;
                bw.write(H + " " + M);
            }
            else{
                M += 15;
                bw.write(23 + " " + M);
            }
        }
        else{
            M -= 45;
            bw.write(H + " " + M);
        }

        bw.flush();
        bw.close();
    }

    private static void prob14681() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(x > 0 && y > 0){
            bw.write('1');
        }
        else if (x < 0 && y > 0){
            bw.write('2');
        }
        else if (x < 0 && y < 0){
            bw.write('3');
        }
        else{
            bw.write('4');
        }

        bw.flush();
        bw.close();
    }

    private static void prob2753() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int year = Integer.parseInt(st.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(((year % 4 == 0) && (year % 100 != 0))
        || year % 400 == 0){
            bw.write('1');
        }
        else{
            bw.write('0');
        }
        bw.flush();
        bw.close();
    }

    private static void prob9498() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int score = Integer.parseInt(st.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(score >= 90){
            bw.write('A');
        }
        else if(score >= 80){
            bw.write('B');
        }
        else if(score >= 70){
            bw.write('C');
        }
        else if(score >= 60){
            bw.write('D');
        }
        else{
            bw.write('F');
        }
        bw.flush();
        bw.close();
    }

    private static void prob1330() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(A > B){
            bw.write('>');
        }
        else if(A < B){
            bw.write('<');
        }
        else {
            bw.write("==");
        }
        bw.flush();
        bw.close();
    }
}