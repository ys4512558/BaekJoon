import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //prob27866();
        //prob2743();
        //prob9086();
        //prob11654();
        //prob11720();
        //prob10809();
        //prob2675();
        //prob1152();
        //prob2908();
        //prob5622();
        //prob11718();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char input[] = br.readLine().toCharArray();

        String S[] = new String[8];
        S[0] = "ABC";
        S[1] = "DEF";
        S[2] = "GHI";
        S[3] = "JKL";
        S[4] = "MNO";
        S[5] = "PQRS";
        S[6] = "TUV";
        S[7] = "WXYZ";

        int sum = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < S.length; j++) {
                if(S[j].contains(String.valueOf(input[i]))){
                    sum += (j+3);
                    break;
                }
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }

    private static void prob11718() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null){
            if(input.isEmpty()){
                break;
            }
            sb.append(input).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob5622() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        int sum = 0;

        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) >= 65 && S.charAt(i) < 68){
                sum += 3;
            }
            else if(S.charAt(i) >= 68 && S.charAt(i) < 71){
                sum += 4;
            }
            else if(S.charAt(i) >= 71 && S.charAt(i) < 74){
                sum += 5;
            }
            else if(S.charAt(i) >= 74 && S.charAt(i) < 77){
                sum += 6;
            }
            else if(S.charAt(i) >= 77 && S.charAt(i) < 80){
                sum += 7;
            }
            else if(S.charAt(i) >= 80 && S.charAt(i) < 84){
                sum += 8;
            }
            else if(S.charAt(i) >= 84 && S.charAt(i) < 87){
                sum += 9;
            }
            else{
                sum += 10;
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }

    private static void prob2908() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder A = new StringBuilder(st.nextToken());
        StringBuilder B = new StringBuilder(st.nextToken());

        int num1 = Integer.parseInt(A.reverse().toString());
        int num2 = Integer.parseInt(B.reverse().toString());

        StringBuilder sb = new StringBuilder();
        int max = num1 > num2 ? num1 : num2;

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    private static void prob1152() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bw.write(String.valueOf(st.countTokens()));
        bw.flush();
        bw.close();
    }

    private static void prob2675() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            for (int j = 0; j < S.length(); j++) {
                for (int k = 0; k < R; k++) {
                    sb.append(S.charAt(j));
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10809() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int A[] = new int[26];

        Arrays.fill(A, -1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if((s.charAt(i) == j+97) && A[j] == -1){
                    A[j] = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(A[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11720() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }

    private static void prob11654() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        char c = s.charAt(0);

        int code = (int) c;

        bw.write(String.valueOf(code));
        bw.flush();
        bw.close();
    }

    private static void prob9086() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            sb.append(s.charAt(0)).
                    append(s.charAt(s.length()-1)).
                    append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2743() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        bw.write(String.valueOf(s.length()));
        bw.flush();
        bw.close();
    }

    private static void prob27866() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine()) - 1;

        bw.write(s.charAt(n));
        bw.flush();
        bw.close();
    }
}