import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int arr[];
    static boolean visit[];
    static int cnt = 0;
    static int sudoku[][] = new int[9][9];
    static int oper[] = new int[4];
    static int max = -1000000000;
    static int min = 1000000000;

    static int status[][];

    static int start[];
    static int link[];
    static int temp[];


    static int start_Status = 0;
    static int link_Status = 0;


    public static void main(String[] args) throws IOException {

    }

    private static void prob14889() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        status = new int[N][N];
        start = new int[N / 2];
        link = new int[N / 2];
        visit = new boolean[N];
        temp = new int[2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs14889(N, 0, 0);
        sb.append(min);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs14889(int N, int depth, int pre) {
        if (N / 2 == depth) {
            int idx = 0;
            for (int i = 0; i < visit.length; i++) {
                if (!visit[i]) {
                    link[idx] = i;
                    idx++;
                }
            }

            calc_status(N / 2, 2, 0, 0,0);
            calc_status(N / 2, 2, 0, 0, 1);
            min = (int) Math.min(Math.abs(start_Status - link_Status), min);
            start_Status = link_Status = 0;
            return;
        }

        for (int i = pre; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                start[depth] = i;
                dfs14889(N, depth + 1, start[depth]);
                visit[i] = false;
            }
        }
    }

    private static void calc_status(int N, int M, int depth, int pre, int sel) {
        if (M == depth) {
            int n = temp[0];
            int m = temp[1];
            if (sel == 0)
                start_Status += (status[n][m] + status[m][n]);
            else
                link_Status += (status[n][m] + status[m][n]);
            return;
        }

        for (int i = pre; i < N; i++) {
            temp[depth] = sel == 0 ? start[i] : link[i];
            calc_status(N, M, depth + 1, i+1, sel);
        }
    }

    private static void prob15652_2() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs15652_2(N, M, 0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs15652_2(int N, int M, int depth, int pre) {
        if(M == depth){
            for(int i : arr)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = pre; i < N; i++) {
            arr[depth] = i+1;
            dfs15652_2(N, M, depth+1, arr[depth]-1);
        }
    }

    private static void prob15651_2() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs15651_2(N, M, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs15651_2(int N, int M, int depth) {
        if(M == depth){
            for(int i : arr)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i+1;
            dfs15651_2(N, M, depth+1);
        }
    }


    private static void prob15650_2() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs15650_2(N, M, 0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs15650_2(int N, int M, int depth, int pre){
        if(M == depth){
            for(int i : arr)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = pre; i < N; i++) {
            arr[depth] = i + 1;
            dfs15650_2(N, M, depth+1, arr[depth]);
        }
    }

    private static void prob15649_2() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];
        dfs15649_2(N, M, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs15649_2(int N, int M, int depth){
        if(M == depth){
            for(int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]){
                arr[depth] = i+1;
                visit[i] = true;
                dfs15649_2(N, M, depth+1);
                visit[i] = false;
            }
        }
    }

    private static void prob14888() throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs14888(N,1, arr[0]);
        sb.append((int) max).append("\n").append((int) min);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs14888(int N, int depth, int res){
        if(N == depth){
            max = max > res ? max : res;
            min = min > res ? res : min;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] != 0) {
                oper[i]--;
                switch (i){
                    case 0:
                        dfs14888(N, depth+1, res + arr[depth]);
                        break;
                    case 1:
                        dfs14888(N, depth+1, res - arr[depth]);
                        break;
                    case 2:
                        dfs14888(N, depth+1, res * arr[depth]);
                        break;
                    case 3:
                        dfs14888(N, depth+1, res / arr[depth]);
                        break;
                }
                oper[i]++;
            }
        }
    }

    private static void prob2580() throws IOException {
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs2580(0, 0);
    }

    private static void dfs2580(int x, int y) throws IOException {
        if(x == 9){
            dfs2580(0, y+1);
            return;
        }

        if(y == 9){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            //여러 값이 나올 때 바로 종료하기 위함.
            System.exit(0);
        }

        if(sudoku[y][x] == 0){
            for (int i = 1; i <= 9; i++) {
                if (possibility(x, y, i)) {
                    sudoku[y][x] = i;
                    dfs2580(x+1, y);
                }
            }
            sudoku[y][x] = 0;
            return;
        }

        dfs2580(x+1, y);
    }
    private static boolean possibility(int x, int y, int value){
        for (int i = 0; i < 9; i++) {
            if(x != i && sudoku[y][i] == value)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if(y != i && sudoku[i][x] == value)
                return false;
        }

        int row = (y / 3) * 3;
        int col = (x / 3) * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if(sudoku[i][j] == value)
                    return false;
            }
        }
        return true;
    }

    private static void prob9663() throws IOException {
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dfs9663(N, 0);
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs9663(int N, int depth){
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (possibility(depth)) {
                dfs9663(N, depth + 1);
            }
        }
    }

    private static boolean possibility(int depth) {
        for (int i = 0; i < depth; i++) {
            if(arr[depth] == arr[i])
                return false;
            else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i]))
                return false;
        }
        return true;
    }
    private static void prob15652() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        dfs15652(N, M, 0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs15652(int N, int M, int depth, int pre){
        if(M == depth){
            for(int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = pre; i < N; i++) {
            arr[depth] = i+1;
            dfs15652(N, M, depth+1, i);
        }
    }

    private static void prob15651() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        dfs15651(N, M, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs15651(int N, int M, int depth){
        if (M == depth) {
            for (int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            dfs15651(N, M, depth+1);
        }
    }

    private static void prob15650() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs15650(N, M,1, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs15650(int N, int M, int at, int depth){
        if (M == depth) {
            for (int i : arr)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs15650(N, M, i+1, depth + 1);
        }
    }

    private static void prob15649() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs15649(N, M, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs15649(int N, int M, int depth){
        if(depth == M){
            for (int i : arr)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i+1;
                dfs15649(N, M, depth+1);
                visit[i] = false;
            }
        }
    }
}