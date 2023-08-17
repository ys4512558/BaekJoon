import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //prob2738();
        //prob2566();
        //prob10798();
        //prob2563();
    }

    private static void prob2563() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] p = new int[n][2];

        int[][] area = new int[100][100];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                p[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    int x = p[i][0];
                    int y = p[i][1];
                    area[x+j][y+k] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(area[i][j] == 1){
                    cnt++;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10798() throws IOException {
        //20분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;

        String[] str = new String[5];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < n; j++) {
                if(i < str[j].length()){
                    sb.append(str[j].charAt(i));
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    private static void prob2566() throws IOException {
        //10분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = 9;
        int max = 0;

        int row = 0;
        int col = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(max <= tmp){
                    max = tmp;
                    row = i+1;
                    col = j+1;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //sb.append(max+"\n"); //이렇게 하면 시간 더 걸린다
        sb.append(max).append("\n");
        sb.append(row + " " + col);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    private static void prob2738() throws IOException {
        //15분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] mat1 = new int[n][m];
        int[][] mat2 = new int[n][m];

        for (int i = 0; i < 2; i++) {
            for (int  j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    if(i == 0){
                        mat1[j][k] = Integer.parseInt(st.nextToken());
                    }
                    else {
                        mat2[j][k] = Integer.parseInt(st.nextToken());
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat1[i][j] += mat2[i][j];
                bw.write(mat1[i][j] + " ");
            }
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}