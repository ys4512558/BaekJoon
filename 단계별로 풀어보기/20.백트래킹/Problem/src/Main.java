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
    public static void main(String[] args) throws IOException {

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